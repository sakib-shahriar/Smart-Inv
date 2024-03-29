package com.ssdev.smartinv.dao.common;
import com.ssdev.smartinv.dao.common.lambdainterface.ReadAllSessionTask;
import com.ssdev.smartinv.dao.common.lambdainterface.ReadGenericSessionTask;
import com.ssdev.smartinv.dao.common.lambdainterface.ReadSessionTask;
import com.ssdev.smartinv.dao.common.lambdainterface.SessionTask;
import com.ssdev.smartinv.model.common.BaseModel;
import com.ssdev.smartinv.model.common.Status;
import com.ssdev.smartinv.util.exception.SmartInvException;
import com.ssdev.smartinv.util.security.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class Dao<T extends BaseModel> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public T get(Long id) {
        return read((session -> {
            String hql = String.format("from %s where status!=:st and id=:id", getModelClass().getSimpleName());
            Query<T> query = session.createQuery(hql, getModelClass());
            query.setParameter("id", id);
            query.setParameter("st", Status.DELETED);
            return query.uniqueResult();
        }));
    }

    public T get(Long id, Boolean statusCheck) {
        return read((session -> {
            String clause = statusCheck ? "and status!=:st" : "";
            String hql = String.format("from %s where id=:id %s", getModelClass().getSimpleName(), clause);
            Query<T> query = session.createQuery(hql, getModelClass());
            query.setParameter("id", id);
            if(statusCheck) {
                query.setParameter("st", Status.DELETED);
            }
            return query.uniqueResult();
        }));
    }

    public List<T> getAll() {
        return readAll(session -> {
            String hql = String.format("from %s where status!=:st", getModelClass().getSimpleName());
            Query<T> query = session.createQuery(hql, getModelClass());
            query.setParameter("st", Status.DELETED);
            return query.list();
        });
    }

    public List<T> getAll(Boolean statusCheck) {
        return readAll(session -> {
            String clause = statusCheck ? "where status!=:st" : "";
            String hql = String.format("from %s %s", getModelClass().getSimpleName(), clause);
            Query<T> query = session.createQuery(hql, getModelClass());
            if(statusCheck) {
                query.setParameter("st", Status.DELETED);
            }
            return query.list();
        });
    }

    public Long getCount() {
        return this.<Long>readGeneric(session -> {
            String hql = String.format("select count(t) from %s t", getModelClass().getSimpleName());
            Query query = session.createQuery(hql);
            return (Long) query.uniqueResult();
        });
    }

    public void save(T obj) {
        doSessionTask(session -> {
            if(obj.getCreatedBy() == null) {
                obj.setCreatedBy(SessionUtil.getLoggedInUser().getId());
            }
            if(obj.getCreatedOn() == null) {
                obj.setCreatedOn(new Date());
            }
            if(obj.getVersion() != null) {
                obj.setUpdatedBy(SessionUtil.getLoggedInUser().getId());
                obj.setUpdatedOn(new Date());
            }
            session.saveOrUpdate(obj);
        });
    }

    public void delete(T obj) {
        doSessionTask(session -> {
            obj.setStatus(Status.DELETED);
            session.update(obj);
        });
    }

    public void delete(T obj, Boolean hardDelete) {
        doSessionTask(session -> {
            if(hardDelete) {
                session.delete(obj);
            }
            else {
                obj.setStatus(Status.DELETED);
                session.update(obj);
            }
        });
    }

    protected void doSessionTask(SessionTask task) {
        if(task == null) {
            throw new RuntimeException("No task provided");
        }
        Transaction transaction = null;
        try(Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            task.execute(session);
            transaction.commit();
        }
        catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    protected T read(ReadSessionTask<T> task) {
        if(task == null) {
            throw new SmartInvException("No task provided");
        }
        try(Session session = this.sessionFactory.openSession()) {
            return task.execute(session);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected List<T> readAll(ReadAllSessionTask<T> task) {
        if(task == null) {
            throw new SmartInvException("No task provided");
        }
        try(Session session = this.sessionFactory.openSession()) {
            return task.execute(session);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected <P> P readGeneric(ReadGenericSessionTask<P> task) {
        if(task == null) {
            throw new SmartInvException("No task provided");
        }
        try(Session session = this.sessionFactory.openSession()) {
            return task.execute(session);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}