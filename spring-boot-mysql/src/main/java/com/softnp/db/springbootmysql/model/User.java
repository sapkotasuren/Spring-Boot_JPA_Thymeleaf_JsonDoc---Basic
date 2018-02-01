package com.softnp.db.springbootmysql.model;

import javax.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String teamName;
    private double salary;

    public User(){}

    public User(String name, String teamName,double salary){
        this.name=name;
        this.teamName=teamName;
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
