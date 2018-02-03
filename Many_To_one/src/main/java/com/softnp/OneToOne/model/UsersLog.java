package com.softnp.OneToOne.model;

import javax.persistence.*;


@Entity
public class UsersLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Long id;
    private String log;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User users;


    public UsersLog() {
    }

    public UsersLog(String log) {
        this.log = log;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
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
