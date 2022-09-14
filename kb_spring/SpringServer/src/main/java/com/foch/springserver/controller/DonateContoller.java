package com.foch.springserver.controller;

import com.foch.springserver.model.manager.ManagerDao;
import com.foch.springserver.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class DonateContoller {

    @Autowired
    private ManagerDao donateDAO;



    @RequestMapping(value = "/donate/{userId}", method = RequestMethod.POST)
    public boolean donateUser(@PathVariable("userId")String userId){
        return donateDAO.donateUser(3000, userId);
    }



    
}
