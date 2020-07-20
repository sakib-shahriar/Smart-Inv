package com.ssdev.smartinv.util.hibernate;

import com.ssdev.smartinv.model.common.Address;
import com.ssdev.smartinv.model.customer.Customer;
import com.ssdev.smartinv.model.invoice.Invoice;
import com.ssdev.smartinv.model.invoice.InvoiceItem;
import com.ssdev.smartinv.model.invoice.InvoicePrice;
import com.ssdev.smartinv.model.order.Order;
import com.ssdev.smartinv.model.order.OrderItem;
import com.ssdev.smartinv.model.common.CompoundPrice;
import com.ssdev.smartinv.model.order.OrderPrice;
import com.ssdev.smartinv.model.product.Price;
import com.ssdev.smartinv.model.product.Product;
import com.ssdev.smartinv.model.product.ProductItem;
import com.ssdev.smartinv.model.system.SystemInfo;
import com.ssdev.smartinv.model.user.User;
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
        setting.put(Environment.GLOBALLY_QUOTED_IDENTIFIERS, true);
        configuration.setProperties(setting);

        configuration.addAnnotatedClass(SystemInfo.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductItem.class);
        configuration.addAnnotatedClass(Price.class);
        configuration.addAnnotatedClass(CompoundPrice.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(OrderItem.class);
        configuration.addAnnotatedClass(OrderPrice.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Invoice.class);
        configuration.addAnnotatedClass(InvoiceItem.class);
        configuration.addAnnotatedClass(InvoicePrice.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}
