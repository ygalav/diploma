package com.ygalav.spring.service;

import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    Group save(Group group);
    Group findByName(String name);
}
