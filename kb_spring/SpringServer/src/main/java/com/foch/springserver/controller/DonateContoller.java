package com.foch.springserver.controller;

import com.foch.springserver.model.manager.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class DonateContoller {

    @Autowired
    private ManagerDao donateDAO;

    @RequestMapping(value= "/asdf", method = RequestMethod.GET)
    public String hell()
    {
        return "Hell";
    }

    @RequestMapping(value = "/donate/{userId}", method = RequestMethod.POST)
    public boolean donateUser(@Param("pay")int pay, @Param("userId")String userId){
        return donateDAO.donateUser(pay, userId);
    }



    
}
