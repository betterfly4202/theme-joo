package com.themejoo.domain.batch;

import com.themejoo.domain.stockinfo.StockInfo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.04.17
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StockCrawlingControllerTest {
    private RestTemplate restTemplate;
    private String baseUrl;
    private HttpHeaders headers;

    @Before
    public void setUp(){
        List<Locale.LanguageRange> langList = Arrays.asList(
                new Locale.LanguageRange("ko-KR"),
                new Locale.LanguageRange("ko"),
                new Locale.LanguageRange("en-US")
        );

        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAcceptLanguage(langList);
        baseUrl = "https://kind.krx.co.kr/corpgeneral/corpList.do";
    }

    @Test
    public void 배치_URL_접속_테스트(){
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void RestTemplate_FORM_테스트(){
        //given
        MultiValueMap<String, String> map = stockMktMap();

        //when
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request , String.class);
        String responseBody = response.getBody();

        Document doc = Jsoup.parse(response.getBody());
        doc.body();

        //then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Assert.assertTrue(responseBody.contains("td"));

        // http://blog.saltfactory.net/post-multipart-form-data-using-resttemplate-in-spring/
        // https://www.baeldung.com/rest-template
        // https://jojoldu.tistory.com/341
    }

    @Test
    public void jsoup_form_data(){
        //given
        MultiValueMap<String, String> map = stockMktMap();

        //when
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request , String.class);
        Document doc = Jsoup.parse(response.getBody());
        Element element = doc.body();

        List<Element> thList = element.getElementsByTag("tr").tagName("td");
        StockInfo stockInfoVO = new StockInfo();
        thList.stream()
                .map(m -> m.getElementsByTag("td").eachText())
                .forEach(v ->{
                    if(v.size()== 10){
                        stockInfoVO.setCompany(v.get(1));
                        stockInfoVO.setCode((v.get(2)));
                        stockInfoVO.setBusinessType(v.get(3));
                        stockInfoVO.setMainProduct(v.get(4));
                        stockInfoVO.setListedDate(v.get(5));
                        stockInfoVO.setSettlingMonth(v.get(6));
                        stockInfoVO.setPresident(v.get(7));
                        stockInfoVO.setHomepage(v.get(8));
                        stockInfoVO.setArea(v.get(9));
                    }
                });
        System.out.println(stockInfoVO.toString());
    }

    private MultiValueMap<String, String> stockMktMap(){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("method", "download");
        map.add("marketType", "kosdaqMkt");
        map.add("pageIndex", "1");
        map.add("orderMode", "3");
        map.add("orderStat", "D");
        map.add("searchType", "13");
        map.add("fiscalYearEnd", "all");
        map.add("location", "all");

        return map;
    }
}