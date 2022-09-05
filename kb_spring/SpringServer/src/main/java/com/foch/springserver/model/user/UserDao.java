package com.foch.springserver.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserDao{
    @Autowired
    private UserRepository repository;

    public void addUser(User user){
        repository.save(user);        
    }

    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(users::add);
        return users;
    }

    public void delete(User user){
        repository.delete(user);
    }

    public User findUser(String userId){
        return repository.findById(userId).orElse(null);
    }

    public void changeType(String userId, int type){
        repository.chageValue(userId, type);
    }
}
