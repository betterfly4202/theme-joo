package com.themejoo.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.04.28
 */


public class CommonUtillsTest {

    @Test
    public void 현재_날짜_테스트(){
        String currentDate = CommonUtills.currentDate("yyMMdd");

        assertNotNull(currentDate);
    }
}