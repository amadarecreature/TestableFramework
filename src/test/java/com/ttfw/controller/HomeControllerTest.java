package com.ttfw.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.ttfw.logic.HomeLogic;
import com.ttfw.model.User;

public class HomeControllerTest {

    HomeLogic logic;

    @BeforeEach
    public void setup() {
        // MockitoAnnotations.openMocks(this);
        logic = new HomeLogic();

    }

    @Test
    void testIndex001_ロジック呼び方() {
        HomeController instance = new HomeController(logic);
        ModelAndView actual = instance.index();
        User actualUser = (User) actual.getModel().get("user");
        assertEquals("user_name01", actualUser.getName());

    }
}
