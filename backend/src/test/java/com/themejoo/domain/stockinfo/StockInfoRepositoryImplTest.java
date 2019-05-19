package com.themejoo.domain.stockinfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.05.07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockInfoRepositoryImplTest {
    @Autowired
    private StockInfoRepositoryImpl stockInfoRepository;

    @Autowired
    private StockInfoRepository repository;

    @After
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    public void 동적쿼리_테스트(){
        //given
        String stockCode = "000999";
        String company = "위메프";

        repository.save(StockInfo.builder()
                .company("위메프")
                .code("00999")
                .businessType("테스트_타입")
                .mainProduct("테스트_상품")
                .listedDate("2019-05-05")
                .settlingMonth("5월")
                .president("이충일")
                .homepage("위메프")
                .area("서울 광진구")
            .build());

        //when
        StockInfo stockInfo = stockInfoRepository.findByStockInfoQueryAdvance(stockCode, null);
        StockInfo stockInfo2 = stockInfoRepository.findByStockInfoQueryAdvance(null, company);

        //then
        assertThat(stockInfo.getCompany(), is(company));
        assertThat(stockInfo2.getCode(), is(stockCode));
    }
}