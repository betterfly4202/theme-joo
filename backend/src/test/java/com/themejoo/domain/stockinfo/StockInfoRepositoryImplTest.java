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
                .stockSeq(999)
                .company("위메프")
                .stockCode("00999")
                .businessType("테스트_타입")
                .mainProduct("테스트_상품")
                .listedDate("2019-05-05")
                .settlingMonth("5월")
                .president("이충일")
                .homepage("위메프")
                .area("서울 광진구")
            .build());

        //when
        List<StockInfo> stockInfo = stockInfoRepository.findByStockInfoQueryAdvance(stockCode, null);

        List<StockInfo> stockInfo2 = stockInfoRepository.findByStockInfoQueryAdvance(null, company);

        //then
        assertThat(stockInfo.size(), is(1));
        assertThat(stockInfo.get(0).getCompany(), is(company));

        assertThat(stockInfo2.size(), is(1));
        assertThat(stockInfo2.get(0).getStockCode(), is(stockCode));
    }
}