package com.ygalav.spring.repository;

import com.ygalav.spring.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByName(String name);
}
