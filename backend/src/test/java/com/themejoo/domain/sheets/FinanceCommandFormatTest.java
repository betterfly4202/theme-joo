package com.themejoo.domain.sheets;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.05.05
 */
public class FinanceCommandFormatTest {
    // =googlefinance("KRX:306200", "price", TODAY()-30, TODAY(), 7)
    // GOOGLEFINANCE(시세_표시, [속성], [시작일], [종료일|일수], [간격])
    private String baseSheetFormat = "=GOOGLEFINANCE(\"%s\", \"%s\", %s, %d)";


    private FinanceCommandMaker financeCommandMaker;
    @Before
    public void setUp(){
        financeCommandMaker = FinanceCommandMaker.builder()
                .stockSubject("KRX:306200")
                .attributes("price")
                .startDate("TODAY()-30")
                .endDate("7")
                .build();
    }

    @Test
    public void 동적_포매터_만들기(){
        String getPrice = String.format(baseSheetFormat,"KRX:306200", "price", "TODAY()-30", 7);

        String getPriace2 = financeCommandMaker.getCommand();

        assertTrue(getPrice.equals(getPriace2));
    }
}