package com.foch.springserver.model.welfare;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Welfare {
	
	@Id
    int unique_number = 0;
    String business_number = "";
    String location = "";
    String name = "";
    
	public int getUnique_number() {
		return unique_number;
	}

	public void setUnique_number(int unique_number) {
		this.unique_number = unique_number;
	}

	public String getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
