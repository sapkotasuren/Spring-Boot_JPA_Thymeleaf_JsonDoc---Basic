package com.softnp.OneToOne.controller;


import com.softnp.OneToOne.model.User;
import com.softnp.OneToOne.model.UsersContacts;
import com.softnp.OneToOne.model.UsersLog;
import com.softnp.OneToOne.repository.UsersContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/usersContacts")
public class UsersContactsController {

    @Autowired
    private UsersContactsRepository usersContactsRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<UsersContacts> getUsersContacts() {
        return usersContactsRepository.findAll();
    }

    @RequestMapping(value = "/update/{name}", method = RequestMethod.GET)
    public List<UsersContacts> update(@PathVariable String name) {
        User user = new User();
        UsersContacts usersContacts = new UsersContacts();
        UsersLog usersLog = new UsersLog();
        UsersLog usersLog2 = new UsersLog();

        usersLog.setLog("Hi Youtube");
        usersLog2.setLog("Hi DC");

        user.setName(name).setTeamName("Alpha").setSalary(2324);
        usersContacts.setPhNo(1111).setUser(user);
        usersContactsRepository.save(usersContacts);
        return usersContactsRepository.findAll();
    }


}
