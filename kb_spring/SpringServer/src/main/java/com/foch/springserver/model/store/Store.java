package com.foch.springserver.model.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
	
    @Id
    @Column(name = "business_number", nullable = false)
    String businessNumber;
    
    @Column(name = "name")
    String name;
    
    String tel;
    String location;
    String description;
    int score;
    
    @Column(name = "userId", nullable = false)
    String userId;
    
    @Column(name = "account_number", nullable = false)
    String accountNumber;

    public String getUser_id(){return userId;}
    public void setUser_id(String user_id){this.userId = user_id;}

    public String getAccount_number(){return accountNumber;}
    public void setAccount_number(String account_number){this.accountNumber = account_number;}
    public String getBusiness_number(){return businessNumber;}
    public void setBusiness_number(String business_number){this.businessNumber = business_number;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getTel(){return tel;}
    public void setTel(String tel){this.tel = tel;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location = location;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    @Override
    public String toString(){
        return "Store{" +
            "name='" + name + '\'' +
            ", tel='" + tel + '\'' +
            ", location='" + location + '\'' +
            ", businessNumber='" + businessNumber + '\'' +
            ", description='" + description + '\'' +
            ", score='" + score + '\'' +
            ", accountNumber='" + accountNumber + '\''+
            ", user_id='" + userId + '\'' +
            '}';
    }
}
