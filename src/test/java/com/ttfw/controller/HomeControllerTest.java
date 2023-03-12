package com.ttfw.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.ttfw.bean.HomeIndexInBean;
import com.ttfw.bean.HomeIndexOutBean;
import com.ttfw.logic.HomeIndexLogic;
import com.ttfw.model.User;

public class HomeControllerTest {

    /**
     *
     */
    @Mock
    HomeIndexLogic logic;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

    }

    /**
     * 引数渡し、受け取り確認
     * メソッド呼び出し
     */
    @Test
    public void testIndex001_ロジッククラス呼び方_1() {
        String inputId = "id001";
        String USER_NAME01 = "user_name01";

        HomeIndexInBean inputBean = new HomeIndexInBean();
        HomeIndexOutBean outputBean = new HomeIndexOutBean();
        User inputUser = new User();
        inputUser.setName(USER_NAME01);
        outputBean.setUser(inputUser);

        HomeController instance = new HomeController(logic);
        when(logic.inputConverter(inputId)).thenReturn(inputBean);
        when(logic.execute(inputBean)).thenReturn(outputBean);

        ModelAndView actual = instance.index(inputId);

        HomeIndexOutBean actualOutput = (HomeIndexOutBean) actual.getModel().get("models");

        assertEquals(USER_NAME01, actualOutput.getUser().getName());

        /**
         * 呼び出し回数の確認
         * 引数を想定通り受け取っている。
         */
        verify(logic, times(1)).inputConverter(inputId);

        // ビジネスロジックメソッド
        verify(logic, times(1)).execute(inputBean);
    }

    /**
     * 引数渡し、受け取り確認
     * メソッド呼び出し
     * 引数バリエーション
     */
    @Test
    public void testIndex001_ロジッククラス呼び方_2() {
        String inputId = "id001_2";
        String USER_NAME01 = "user_name01_2";

        HomeIndexInBean inputBean = new HomeIndexInBean();
        HomeIndexOutBean outputBean = new HomeIndexOutBean();
        User inputUser = new User();
        inputUser.setName(USER_NAME01);
        outputBean.setUser(inputUser);

        HomeController instance = new HomeController(logic);
        when(logic.inputConverter(inputId)).thenReturn(inputBean);
        when(logic.execute(inputBean)).thenReturn(outputBean);

        ModelAndView actual = instance.index(inputId);

        HomeIndexOutBean actualOutput = (HomeIndexOutBean) actual.getModel().get("models");

        assertEquals(USER_NAME01, actualOutput.getUser().getName());

        /**
         * 呼び出し回数の確認
         * 引数を想定通り受け取っている。
         */

        // 引数処理メソッド
        verify(logic, times(1)).inputConverter(inputId);

        // ビジネスロジックメソッド
        verify(logic, times(1)).execute(inputBean);
    }
}
