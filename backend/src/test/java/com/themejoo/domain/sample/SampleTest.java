package com.themejoo.domain.sample;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.03.25
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    SampleRepository repository;

    @After
    public void cleanUp(){
        repository.deleteAll();
    }

    @Test
    public void 테스트_저장_리스트(){
        // given
        LocalDateTime now = LocalDateTime.now();
        repository.save(Sample.builder()
                .title("테스트_제목")
                .contents("테스트_내용")
                .author("betterFLY")
                .build());

        // when
        List<Sample> list = repository.findAll();

        // then
        Sample sample = list.get(0);
        assertThat(sample.getTitle(), is("테스트_제목"));
        assertThat(sample.getAuthor(), is("betterFLY"));
        assertTrue(sample.getRegDate().isAfter(now));
    }

}