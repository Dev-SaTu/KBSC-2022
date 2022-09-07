package com.foch.springserver.controller;

import com.foch.springserver.model.donate.DonateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DonateContoller {

    @Autowired
    private DonateDAO donateDAO;


}
