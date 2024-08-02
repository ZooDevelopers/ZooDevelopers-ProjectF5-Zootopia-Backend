package org.factoriaf5.zootopia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Species {
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String family;
    private String gender;
    private String date;
    private String country;

    
    public Species(long id, String name, String type, String family, String gender, String date, String country) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.family = family;
        this.date = date;
        this.country = country;
        this.gender = gender;
        
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getGender() {
        return gender;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getFamily() {
        return family;
    }


    public void setFamily(String family) {
        this.family = family;
    }



   


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }

  

    

}
