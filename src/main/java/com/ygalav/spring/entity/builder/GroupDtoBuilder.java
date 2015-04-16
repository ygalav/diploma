package com.ygalav.spring.entity.builder;

import com.ygalav.spring.dto.GroupDto;
import com.ygalav.spring.entity.Group;

public class GroupDtoBuilder {
    private Integer id;
    private String name;

    public GroupDtoBuilder setId(Integer id){
        this.id=id;
        return this;

    }
    public GroupDtoBuilder setName(String name){
        this.name=name;
        return this;
    }
    public GroupDto createGroupDto(){return new GroupDto(id,name);}
}
