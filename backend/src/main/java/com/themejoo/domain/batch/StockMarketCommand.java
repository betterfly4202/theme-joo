package com.themejoo.domain.batch;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by betterfly
 * Date : 2019.04.20
 */
@Slf4j
@AllArgsConstructor
@Service
public class StockMarketCommand implements Command {
    @Autowired
    private BatchExecutor batchExecutor;

    @Override
    public void execute() {
        batchExecutor.executeStockMarket(MarketType.STOCK_MARKET);
    }
}
