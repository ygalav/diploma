package com.ygalav.spring.service.impl;

import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Group;
import com.ygalav.spring.repository.GroupRepository;
import com.ygalav.spring.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
    public Group save(Group group) {
        return groupRepository.save(group);
    }
    @Override

    public Group findByName(String name) {
        return groupRepository.findByName(name);
    }

}

