package com.themejoo.domain.sheets;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.04.13
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
        properties = "spring.config.location=classpath:/client_secret.yml")
public class SheetControllerTest {
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void oauth_sheet_접근 () throws Exception {
//        given()
//                .when()
//                .get("/sheet")
//                .then()
//                .statusCode(200);
    }

}