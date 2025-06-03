package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dogId;

    private String name;

    private String desc;

    @Column(name = "other_names")
    private String otherNames;

    private String origin;

    // constructors
    public Dog() {
    }

    public Dog(String name, String desc, String otherNames, String origin) {
        this.name = name;
        this.desc = desc;
        this.otherNames = otherNames;
        this.origin = origin;
    }

    // getters and setters
    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long id) {
        this.dogId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
