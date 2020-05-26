package com.ssdev.samrtinv.service.system;

import com.ssdev.samrtinv.dao.system.SystemInfoDao;
import com.ssdev.samrtinv.dao.user.UserDao;
import com.ssdev.samrtinv.model.system.SystemInfo;
import com.ssdev.samrtinv.model.user.Role;
import com.ssdev.samrtinv.model.user.User;
import com.ssdev.samrtinv.util.security.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SystemService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SystemInfoDao systemInfoDao;

    public void initialize() {
        User admin = initializeAdmin();
        addSystemEntry(admin);
    }

    public Boolean isInitialized() {
        SystemInfo systemInfo = this.systemInfoDao.getLastSystemEntry();
        if(systemInfo == null || !systemInfo.getDataInitialized()) {
            return false;
        }
        return true;
    }

    private User initializeAdmin() {
        User admin = new User();
        admin.setFirstName("System");
        admin.setLastName("Admin");
        admin.setEmail("admin@email.com");
        admin.setPassword(CryptoUtil.encrypt("admin@123456"));
        admin.setRole(Role.ADMIN);
        admin.setCreatedOn(new Date());
        admin.setCreatedBy(0L);
        userDao.save(admin);
        return admin;
    }

    public void addSystemEntry(User user) {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setDataInitialized(true);
        systemInfo.setLastLoggedInUser(user);
        systemInfo.setLastLoginTime(new Date());
        this.systemInfoDao.saveSystemInfo(systemInfo);
    }
}
