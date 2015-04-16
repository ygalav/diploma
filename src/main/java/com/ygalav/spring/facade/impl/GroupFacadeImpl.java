package com.ygalav.spring.facade.impl;

import com.ygalav.spring.dto.GroupDto;
import com.ygalav.spring.entity.Group;
import com.ygalav.spring.entity.builder.GroupBuilder;
import com.ygalav.spring.entity.builder.GroupDtoBuilder;
import com.ygalav.spring.facade.GroupFacade;
import com.ygalav.spring.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupFacadeImpl implements  GroupFacade{
    @Autowired
    private GroupService groupService;

    @Override
    public List<GroupDto> findAll(){
        List<Group> groups=groupService.findAll();
        List<GroupDto> groupDtos=new ArrayList<>();
        for(Group group :groups){
            groupDtos.add(toDto(group));
        }
        return groupDtos;
    }
    @Override
    public GroupDto save(GroupDto groupDto){
        Group group=groupService.save(fromDto(groupDto));
        return toDto(group);
    }
    private GroupDto toDto(Group group){
        return new GroupDtoBuilder()
                .setId(group.getId())
        .setName(group.getName())
                .createGroupDto();
    }
    private Group fromDto(GroupDto group){
        return new GroupBuilder()
                .setId(group.getId())
                .setName(group.getName())
                .createGroup();


    }

}
