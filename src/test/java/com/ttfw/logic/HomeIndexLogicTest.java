package com.ttfw.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ttfw.bean.HomeIndexInBean;
import com.ttfw.bean.HomeIndexOutBean;
import com.ttfw.service.LoginUserInfoService;

public class HomeIndexLogicTest {

    @Mock
    LoginUserInfoService mockLoginUserInfoService;

    @InjectMocks
    HomeIndexLogic instance;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(instance);
    }

    /**
     * TODO:渡した値で検索した結果を取得していること。
     * 
     */
    @Nested
    class ExecuteTest {

        /**
         * 画面から渡した検索キーで検索処理を呼び出している。
         * 結果を画面に返している。
         * mock:サービスクラス
         */
        /**
         * ちゃんと呼び出しているか確認
         */
        @Test
        void test処理呼び出し確認_検索キー1() {
            // LoginUserInfoService mockLoginUserInfoService = Mock
            // HomeIndexLogic instance = new HomeIndexLogic();
            HomeIndexInBean input = new HomeIndexInBean();
            input.setSearchId("0001");

            HomeIndexOutBean actual = instance.execute(input);

            assertEquals("name01", actual.getUser().getName());
            assertEquals("email01", actual.getUser().getEmail());
            assertEquals(11, actual.getUser().getAge());

        }

        /**
         * 可変になっている確認
         */
        @Test
        void test処理呼び出し確認_検索キー2() {

            // HomeIndexLogic instance = new HomeIndexLogic();
            HomeIndexInBean input = new HomeIndexInBean();
            input.setSearchId("0002");
            HomeIndexOutBean actual = instance.execute(input);

            assertEquals("name02", actual.getUser().getName());
            assertEquals("email02", actual.getUser().getEmail());
            assertEquals(12, actual.getUser().getAge());

        }

    }

    @Test
    void testInputConverter() {

    }
}
