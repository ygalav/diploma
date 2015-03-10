package com.ygalav.spring.service;

import com.ygalav.spring.entity.Group;

public interface GroupService {
    Group findByName(String name);
}
