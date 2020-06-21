package com.ssdev.samrtinv.dao.system;

import com.ssdev.samrtinv.model.system.SystemInfo;
import com.ssdev.samrtinv.model.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemInfoDao {

    @Autowired
    SessionFactory sessionFactory;

    public SystemInfo getLastSystemEntry() {
        try(Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from SystemInfo order by id desc");
            query.setMaxResults(1);
            SystemInfo systemInfo = (SystemInfo) query.uniqueResult();
            return systemInfo;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void saveSystemInfo(SystemInfo systemInfo) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.save(systemInfo);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
