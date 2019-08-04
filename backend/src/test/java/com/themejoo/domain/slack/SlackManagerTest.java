package com.themejoo.domain.slack;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.07.10
 */
public class SlackManagerTest {
    private SlackManager slackManager;
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        slackManager = new SlackManager();
        restTemplate = new RestTemplate();
    }

    @Test
    public void 알람_호출(){
        SlackManager.SlackMessageAttachement att = new SlackManager.SlackMessageAttachement();
        att.setText("alarm test....");
        att.setUsername("betterFLY");
        att.setChannel("#general");
        att.setIcon_emoji(":dog:");


//        SlackManager.SlackMessage slackMessage =
//                SlackManager.SlackMessage.builder()
//                        .channel(SlackManager.SlackTarget.INCOMING_URL.webHookUrl)
//                        .attachments(Lists.newArrayList(att))
//                        .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<SlackManager.SlackMessageAttachement> request = new HttpEntity<>(att, headers);

        assertEquals(HttpStatus.OK, restTemplate.postForEntity(SlackManager.SlackTarget.INCOMING_URL.webHookUrl, request, String.class).getStatusCode());
    }
}