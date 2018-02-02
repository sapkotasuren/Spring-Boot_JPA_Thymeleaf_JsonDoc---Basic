package com.softnp.OneToOne.model;

import javax.persistence.*;

@Entity
public class UsersContacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer phNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;


    public UsersContacts() {
    }

    public UsersContacts(Integer phNo, User user) {
        this.phNo = phNo;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UsersContacts setUser(User user) {
        this.user = user;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public UsersContacts setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPhNo() {
        return phNo;
    }

    public UsersContacts setPhNo(Integer phNo) {
        this.phNo = phNo;return this;
    }
}
