package com.themejoo.domain.batch;

/**
 * Created by betterfly
 * Date : 2019.04.22
 */
public enum MarketType {
    STOCK_MARKET(1, "stockMkt"),
    KOSDAQ_MARKET(2, "kosdaqMkt"),
    KONEX_MARKET(3, "konexMkt")
    ;

    private int stockSeq;
    private String stockName;

    MarketType(int stockSeq, String stockName){
        this.stockSeq = stockSeq;
        this.stockName = stockName;
    }

    public int getStockSeq() {
        return stockSeq;
    }

    public String getStockName() {
        return stockName;
    }
}
