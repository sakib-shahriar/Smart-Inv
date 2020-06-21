package com.ssdev.samrtinv.model.system;

import com.ssdev.samrtinv.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "system_info")
public class SystemInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User lastLoggedInUser;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "data_initialized", nullable = false)
    private Boolean dataInitialized;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getLastLoggedInUser() {
        return lastLoggedInUser;
    }

    public void setLastLoggedInUser(User lastLoggedInUser) {
        this.lastLoggedInUser = lastLoggedInUser;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getDataInitialized() {
        return dataInitialized;
    }

    public void setDataInitialized(Boolean dataInitialized) {
        this.dataInitialized = dataInitialized;
    }
}
