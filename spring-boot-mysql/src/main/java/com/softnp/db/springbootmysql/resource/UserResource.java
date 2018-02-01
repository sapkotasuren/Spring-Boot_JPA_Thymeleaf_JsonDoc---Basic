package com.softnp.db.springbootmysql.resource;

import com.softnp.db.springbootmysql.model.User;
import com.softnp.db.springbootmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> createUser(@RequestBody User user) {
        User u = new User();
        u.setName(user.getName());
        u.setSalary(user.getSalary());
        u.setTeamName(user.getTeamName());
        userRepository.save(u);
        return userRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<User> delete(@PathVariable Integer id) {
        userRepository.delete(id);
        return userRepository.findAll();
    }


}
