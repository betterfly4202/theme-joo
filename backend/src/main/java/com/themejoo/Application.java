package com.themejoo;

import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.themejoo.domain.sheets.SpreadSheetMaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;

/**
 * Created by betterfly
 * Date : 2019.03.23
 */
@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
