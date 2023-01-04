package com.ttfw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ttfw.bean.LogicInputBean;
import com.ttfw.logic.HomeLogic;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {

    @Autowired
    HomeLogic logic;

    @RequestMapping
    public ModelAndView index() {

        LogicInputBean input = new LogicInputBean();
        LogicOutputBean result = logic.execute(input);

        return new ModelAndView("home", "user", result.getUser());
    }

}
