package com.felix.entity;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    private String id;
    private String name;
    private String sex;
    private List<Pet> pets=new ArrayList<Pet>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
