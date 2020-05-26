package com.ssdev.samrtinv.configuration;

import com.ssdev.samrtinv.service.system.SystemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements InitializingBean {

    @Autowired
    private SystemService systemService;
    @Override
    public void afterPropertiesSet() {
        if(!this.systemService.isInitialized()) {
            this.systemService.initialize();
        }
    }
}
