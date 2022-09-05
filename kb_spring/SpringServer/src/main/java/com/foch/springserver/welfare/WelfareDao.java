package com.foch.springserver.welfare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelfareDao {
	
    @Autowired
    private WelfareRepository repository;

    public Welfare find(String benefitId) {
    	return repository.findById(benefitId).get();
    }
    
    public Welfare save(Welfare benefit) {
    	return repository.save(benefit);
    }
    
    public void delete(String benefitId) {
    	repository.delete(find(benefitId));
    }
    
}
