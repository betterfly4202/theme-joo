package com.themejoo.domain.stockinfo;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.04.28
 */
public class StockInfoTest {

    private StockInfo stockInfo;

    @Before
    public void setUp(){
        stockInfo = new StockInfo();
    }

    @Test
    public void stock_Code_길이(){
        StockInfo info = StockInfo.builder()
                 .code("4000")
                 .build();

        String stockCode = info.getCode();

        assertThat(stockCode, is("004000"));
    }

}