package com.ygalav.spring.controller;

import com.ygalav.spring.entity.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/groups")
public class GroupController {
    @RequestMapping("/")
    public String showGroupHomePage(Model modGroup) {
        Group group1 = new Group();
        group1.setId(1);
        group1.setName("СІ-11-01");
        Group group2 = new Group();
        group2.setId(2);
        group2.setName("СІ-11-02");
        ArrayList groupList= new ArrayList();
        groupList.add(group1);
        groupList.add(group2);
        modGroup.addAttribute("spysokGroup",groupList);
        return "groupsHome";
    }
}


