package com.ygalav.spring.entity.builder;

import com.ygalav.spring.entity.Group;

public class GroupBuilder {
    private Integer id;
    private String name;

    public GroupBuilder setId(Integer id){
       this.id=id;
        return this;
    }
    public GroupBuilder setName(String name){
        this.name=name;
        return this;
    }
    public Group createGroup(){
        Group group=new Group();
        group.setName(name);
        return group;
    }
}
