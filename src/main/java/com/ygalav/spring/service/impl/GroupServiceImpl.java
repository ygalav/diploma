package com.ygalav.spring.service.impl;

import com.ygalav.spring.entity.Group;
import com.ygalav.spring.repository.GroupRepository;
import com.ygalav.spring.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Override
    public Group findByName(String name) {
        return groupRepository.findByName(name);
    }
}
