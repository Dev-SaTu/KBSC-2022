package com.foch.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.foch.springserver.benefit.BenefitDao;

@RestController
public class BenefitController {

	@Autowired
	private BenefitDao BenefitDao;
	
	

}
