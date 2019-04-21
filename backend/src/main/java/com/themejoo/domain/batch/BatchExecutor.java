package com.themejoo.domain.batch;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by betterfly
 * Date : 2019.04.20
 */

@Slf4j
@AllArgsConstructor
@Component
public class BatchExecutor {

    @Autowired
    private StockInfoRepository stockInfoRepository;

    final String baseUrl = "https://kind.krx.co.kr/corpgeneral/corpList.do";
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private MarketType marketType;

    public BatchExecutor(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();

        List<Locale.LanguageRange> langList = Arrays.asList(
                new Locale.LanguageRange("ko-KR"),
                new Locale.LanguageRange("ko"),
                new Locale.LanguageRange("en-US")
        );
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAcceptLanguage(langList);
    }

    public void executeStockMarket(MarketType marketType) {
        this.marketType = marketType;

        getStockElementList()
                .stream()
                .map(m -> m.getElementsByTag("td").eachText())
                .forEach(v ->{
                    StockInfo stockInfo = new StockInfo();
                    if(v.size()== 10){
                        if(v.iterator().hasNext()) {
                            stockInfoRepository.save(StockInfo.builder()
                                    .stockSeq(marketType.getStockSeq())
                                    .company(v.get(1))
                                    .stockCode(Integer.parseInt(v.get(2)))
                                    .businessType(v.get(3))
                                    .mainProduct(v.get(4))
                                    .listedDate(v.get(5))
                                    .settlingMonth(v.get(6))
                                    .president(v.get(7))
                                    .homepage(v.get(8))
                                    .area(v.get(9))
                                    .build());
                        }
                    }
                });
    }

    private List<Element> getStockElementList(){
        MultiValueMap<String, String> map = stockFormParameter();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request , String.class);
        Document doc = Jsoup.parse(response.getBody());

        return doc.body().getElementsByTag("tr").tagName("td");
    }

    private MultiValueMap<String, String> stockFormParameter(){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("method", "download");
        map.add("marketType", marketType.getStockName());
        map.add("pageIndex", "1");
        map.add("orderMode", "3");
        map.add("orderStat", "D");
        map.add("searchType", "13");
        map.add("fiscalYearEnd", "all");
        map.add("location", "all");

        return map;
    }
}
