package com.ttfw.logic;

import com.ttfw.bean.LogicInputBean;
import com.ttfw.controller.LogicOutputBean;
import com.ttfw.model.User;

public class HomeLogic {

    public LogicOutputBean execute(LogicInputBean input) {
        LogicOutputBean logicOutputBean = new LogicOutputBean();

        // TODO 可変に
        User user = new User();
        user.setName("user_name01");
        logicOutputBean.setUser(user);
        return logicOutputBean;
    }

}
