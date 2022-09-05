package com.foch.springserver.model.store;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
    @Id
    String business_number;
    String name;
    String tel;
    String location;
    String pic;
    String description;
    int score;
    String user_id;
    String account_number;

    public String getUser_id(){return user_id;}
    public void setUser_id(String user_id){this.user_id = user_id;}

    public String getAccount_number(){return account_number;}
    public void setAccount_number(String account_number){this.account_number = account_number;}
    public String getBusiness_number(){return business_number;}
    public void setBusiness_number(String business_number){this.business_number = business_number;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getTel(){return tel;}
    public void setTel(String tel){this.tel = tel;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location = location;}

    public String getPic(){return pic;}
    public void setPic(String pic){this.pic = pic;}

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
            ", business_number='" + business_number + '\'' +
            ", pic='" + pic + '\'' +
            ", description='" + description + '\'' +
            ", score='" + score + '\'' +
            ", account_number='" + account_number + '\''+
            ", user_id='" + user_id + '\'' +
            '}';
    }
}
