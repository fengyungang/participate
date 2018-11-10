package com.participate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @RequestMapping("/getMenu")
    public ModelAndView getMenu(){
        return new ModelAndView("sys/sysmnu");
    }
}
