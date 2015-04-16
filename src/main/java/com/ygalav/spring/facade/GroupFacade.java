package com.ygalav.spring.facade;

import com.ygalav.spring.dto.GroupDto;
import com.ygalav.spring.entity.Group;

import java.util.List;

public interface GroupFacade {
    List<GroupDto> findAll();
    GroupDto save(GroupDto groupDto);
}
