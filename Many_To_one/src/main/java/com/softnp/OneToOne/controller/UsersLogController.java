package com.softnp.OneToOne.controller;

import com.softnp.OneToOne.model.User;
import com.softnp.OneToOne.model.UsersLog;
import com.softnp.OneToOne.repository.UsersLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suren on 03/02/2018.
 */
@RestController
@RequestMapping("/rest/users/log")
public class UsersLogController {

    @Autowired
    private UsersLogRepository usersLogRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<UsersLog> getAll(){
        return usersLogRepository.findAll();
    }

    @RequestMapping(value="/update/{name}")
    public List<UsersLog>update(@PathVariable String name){
        User user = new User();
        user.setName(name)
                .setSalary(128374)
                .setTeamName("Alpha");
        UsersLog usersLog = new UsersLog();
        usersLog.setUsers(user);
        usersLog.setLog("test");
        usersLogRepository.save(usersLog);

        UsersLog usersLog1 = new UsersLog();
        usersLog1.setUsers(user);
        usersLog1.setLog("youtube");
        usersLogRepository.save(usersLog1);

        return usersLogRepository.findAll();
    }



}
