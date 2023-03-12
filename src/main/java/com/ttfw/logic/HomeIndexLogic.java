package com.ttfw.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.ttfw.bean.HomeIndexInBean;
import com.ttfw.bean.HomeIndexOutBean;
import com.ttfw.model.User;
import com.ttfw.service.LoginUserInfoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HomeIndexLogic {

    @Autowired
    LoginUserInfoService loginUserInfoService;

    public HomeIndexOutBean execute(HomeIndexInBean input) {
        HomeIndexOutBean logicOutputBean = new HomeIndexOutBean();

        User user = new User();
        if (input.getSearchId().equals("0001")) {
            user.setName("name01");
            user.setAge(11);
            user.setEmail("email01");
        } else {
            user.setName("name02");
            user.setAge(12);
            user.setEmail("email02");
        }

        logicOutputBean.setUser(user);
        // TODO 可変に
        return logicOutputBean;
    }

    public HomeIndexInBean inputConverter(String id) {
        return null;
    }

}
