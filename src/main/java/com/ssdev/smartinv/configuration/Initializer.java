package com.ssdev.smartinv.configuration;

import com.ssdev.smartinv.service.system.SystemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class Initializer implements InitializingBean {

    @Autowired
    private SystemService systemService;

    @Override
    public void afterPropertiesSet() {
        if(!this.systemService.isInitialized()) {
            this.systemService.initialize();
        }

        DataSourceFactory dataSourceFactory = new DataSourceFactory() {
            @Override
            public ConnectionProperties getConnectionProperties() {
                return null;
            }

            @Override
            public DataSource getDataSource() {
                return null;
            }
        };
    }
}
