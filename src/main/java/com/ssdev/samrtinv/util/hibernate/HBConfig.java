package com.ssdev.samrtinv.util.hibernate;

import com.ssdev.samrtinv.model.product.CompoundPrice;
import com.ssdev.samrtinv.model.product.Price;
import com.ssdev.samrtinv.model.product.Product;
import com.ssdev.samrtinv.model.product.ProductItem;
import com.ssdev.samrtinv.model.system.SystemInfo;
import com.ssdev.samrtinv.model.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HBConfig {
    public static SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();
        Properties setting = new Properties();
        setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        setting.put(Environment.URL, "jdbc:mysql://localhost:3306/smartinv");
        setting.put(Environment.USER, "root");
        setting.put(Environment.PASS, "");
        setting.put(Environment.SHOW_SQL, "true");
        setting.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(setting);

        configuration.addAnnotatedClass(SystemInfo.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductItem.class);
        configuration.addAnnotatedClass(Price.class);
        configuration.addAnnotatedClass(CompoundPrice.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}
