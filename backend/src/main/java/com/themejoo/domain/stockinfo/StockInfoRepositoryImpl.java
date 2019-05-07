package com.themejoo.domain.stockinfo;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.themejoo.domain.stockinfo.QStockInfo.stockInfo;

/**
 * Created by betterfly
 * Date : 2019.04.24
 */

@RequiredArgsConstructor
@Service
public class StockInfoRepositoryImpl implements StockInfoRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<StockInfo> findByStockInfoQueryAdvance(String stockCode, String company) {
        return queryFactory
                .selectFrom(stockInfo)
                .where(eqStockCode(stockCode)
                      ,likeCompany(company))
                .fetch();
    }

    private BooleanExpression eqStockCode(String stockCode) {
        if (StringUtils.isEmpty(stockCode)) {
            return null;
        }
        return stockInfo.stockCode.eq(stockCode);
    }

    private BooleanExpression likeCompany(String company) {
        if (StringUtils.isEmpty(company)) {
            return null;
        }
        return stockInfo.company.like(company);
    }
}
