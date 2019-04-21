package com.themejoo.domain.batch;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by betterfly
 * Date : 2019.04.17
 */

@RestController
@RequestMapping("/batch")
@Slf4j
public class StockCrawlingController {
    @Autowired
    private StockMarketCommand stockMarketCommand;

    @Autowired
    private KosdaqMarketCommand kosdaqMarketCommand;

    @Autowired
    private KonexMarketCommand konexMarketCommand;

    @GetMapping("/stockMkt")
    public void getStockList(){
        stockMarketCommand.execute();
    }

    @GetMapping("/kosdaqMkt")
    public void getKosdaqList(){
        kosdaqMarketCommand.execute();
    }

    @GetMapping("/konexMkt")
    public void getKonexList(){
        konexMarketCommand.execute();
    }
}
