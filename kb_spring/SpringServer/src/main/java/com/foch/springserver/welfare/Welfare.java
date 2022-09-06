package com.foch.springserver.welfare;

import javax.persistence.Entity;

import org.json.JSONObject;

@Entity
public class Welfare {
	
    int unique_number = 0;
    String business_number = "";
    String location = "";
    String name = "";
    
	@Override
    public String toString() {
    	
    	JSONObject object = new JSONObject();
    	
    	object.put("unique_number", unique_number);
    	object.put("business_number", business_number);
    	object.put("location", location);
    	object.put("name", name);
    	
    	return String.format("Benefit%s", object.toString()); 
    			
    }
    
}
