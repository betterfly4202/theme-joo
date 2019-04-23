package com.themejoo.domain.sheets;

import com.querydsl.jpa.JPQLQuery;
import com.themejoo.domain.batch.QStockInfo;
import com.themejoo.domain.batch.StockInfo;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.23
 */

@Service
public class SheetServiceImpl extends QuerydslRepositorySupport {

    public SheetServiceImpl() {
        super(StockInfo.class);
    }

    public List<StockInfo> findByStockInfoSeq(Integer stockSeq){
        QStockInfo stockInfo = QStockInfo.stockInfo;

        JPQLQuery jpqlQuery = from(stockInfo);
        jpqlQuery.where(stockInfo.stockSeq.eq(stockSeq));
        return jpqlQuery.fetch();
    }
}
