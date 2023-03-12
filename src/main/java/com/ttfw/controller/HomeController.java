package com.ttfw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ttfw.bean.HomeIndexInBean;
import com.ttfw.bean.HomeIndexOutBean;
import com.ttfw.logic.HomeIndexLogic;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {

    @Autowired
    HomeIndexLogic logic;

    @RequestMapping
    public ModelAndView index(String id) {

        HomeIndexInBean input = logic.inputConverter(id);

        HomeIndexOutBean result = logic.execute(input);

        return new ModelAndView("home", "models", result);
    }

}
