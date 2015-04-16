package com.ygalav.spring.dto;

import com.ygalav.spring.entity.Group;

public class GroupDto {
    private Integer id;
    private String name;

    public GroupDto(Integer id,String name){
        this.id=id;
        this.name=name;
    }
public GroupDto(){}
    public Integer getId() {return id;}
    public void setId(Integer id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}



}

