package com.softnp.OneToOne.model;

import javax.persistence.*;


@Entity
public class UsersLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Long id;
    private String log;

    @Column(name = "user_id")
    private Integer userId;

    public UsersLog() {
    }

    public UsersLog(String log, Integer userId) {
        this.userId = userId;
        this.log = log;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
