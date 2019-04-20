package com.themejoo.domain.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/crawling/stockMkt")
    public void getStockList(){

        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://kind.krx.co.kr/corpgeneral/corpList.do";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("method", "download");
        map.add("marketType", "stockMkt");
        map.add("pageIndex", "1");
        map.add("orderMode", "3");
        map.add("orderStat", "D");
        map.add("searchType", "13");
        map.add("fiscalYearEnd", "all");
        map.add("location", "all");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request , String.class);
        String responseBody = response.getBody();

        log.info("responseBody : {}", responseBody);
    }
}
