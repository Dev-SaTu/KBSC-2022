package com.foch.springserver.model.store;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
    @Id
    String id;
    String name;
    String tel;
    String location;
    String business_number;
    String pic;
    String description;
    int score;

    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getTel(){return tel;}
    public void setTel(String tel){this.tel = tel;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location = location;}

    public String getBusinessNumber(){return business_number;}
    public void setBusinessNumber(String business_number){this.business_number = business_number;}

    public String getPic(){return pic;}
    public void setPic(String pic){this.pic = pic;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    @Override
    public String toString(){
        return "Store{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", tel='" + tel + '\'' +
            ", location='" + location + '\'' +
            ", business_number='" + business_number + '\'' +
            ", pic='" + pic + '\'' +
            ", description='" + description + '\'' +
            ", score='" + score + '\'' +
            '}';
    }
}
