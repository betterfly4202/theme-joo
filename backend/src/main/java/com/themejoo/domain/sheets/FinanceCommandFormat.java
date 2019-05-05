package com.themejoo.domain.sheets;

import lombok.Builder;

/**
 * Created by betterfly
 * Date : 2019.05.05
 */

/**
 *  GOOGLEFINANCE(시세_표시, [속성], [시작일], [종료일|일수], [간격])
 */
public class FinanceCommandFormat {
    private final String baseSheetFormat = "=GOOGLEFINANCE(\"%s\", \"%s\", %s, %s)";
    private final String sheetFormatContainsInterval = "=GOOGLEFINANCE(\"%s\", \"%s\", %s, %s, %d)";

    private String stockSubject;
    private String attributes;
    private String startDate;
    private String endDate;
    private Integer interval;

    @Builder
    public FinanceCommandFormat(String stockSubject, String attributes, String startDate, String endDate, int interval) {
        this.stockSubject = stockSubject;
        this.attributes = attributes;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = interval;
    }

    public String getCommand(){
        return String.format(baseSheetFormat, stockSubject, attributes, startDate, endDate);
    }
    public String getCommandContainsInterval(){
        return String.format(sheetFormatContainsInterval, stockSubject, attributes, startDate, endDate, interval);
    }
}
