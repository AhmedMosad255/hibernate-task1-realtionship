package com.spring.hibernate;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "friends")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
