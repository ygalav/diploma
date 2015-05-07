package com.ygalav.spring.controller;

import com.ygalav.spring.dto.GroupDto;
import com.ygalav.spring.entity.Group;
import com.ygalav.spring.facade.GroupFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller



@RequestMapping(value = "/groups")
public class GroupController {
    @Autowired
    private GroupFacade groupFacade;
    @RequestMapping("/")
    public String showGroupHomePage(Model modGroup) {
        modGroup.addAttribute("groupDto", new GroupDto());

        modGroup.addAttribute("groups", groupFacade.findAll());

             return "groupsHome";}
        @RequestMapping(value = "/",method = RequestMethod.POST)
        public String save(@ModelAttribute GroupDto groupDto) {
            groupFacade.save(groupDto);
            return "redirect:/groups/";

        }
}


