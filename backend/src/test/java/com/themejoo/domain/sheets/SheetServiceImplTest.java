package com.themejoo.domain.sheets;

import com.themejoo.domain.stockinfo.StockInfo;
import com.themejoo.domain.stockinfo.StockInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.04.28
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "/application.yml")
public class SheetServiceImplTest {

    @Autowired
    private SheetServiceImpl sheetService;

    @Autowired
    private StockInfoRepository repository;

    @Value("${google.sheet.id}")
    private String sheetId;

    @Before
    public void setUp(){

    }

    @Test
    public void 시트_만들기() throws IOException {
        sheetService.makeSpreadSheet("테스트_시트");
    }

    @Test
    public void 시트_값_넣기() throws IOException {
        sheetService.sheetUpdates(null);
    }

    @Test
    public void 시트_데이터_읽기() {
        repository.save(StockInfo.builder()
                .stockSeq(1)
                .company("111110")
                .stockCode("111110")
                .businessType("테스트_타입")
                .mainProduct("테스트_상품")
                .listedDate("2019-05-05")
                .settlingMonth("5월")
                .president("이충일")
                .homepage("위메프")
                .area("서울 광진구")
                .build());

        sheetService.getFinanceDetail(StockInfo.builder().stockCode("111110").build());
    }

    @Test
    public void adsf() throws IOException {
        sheetService.aa(sheetId, "A1:B10");
    }
}