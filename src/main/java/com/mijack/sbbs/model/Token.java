package com.mijack.sbbs.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
public class Token {
    @Id
    private long id;
    @NotNull
    @OneToOne()
    @JoinColumn(name = "user_id", unique = true, nullable = false, updatable = false)
    private User user;
    @NotNull
    private String token;
    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
