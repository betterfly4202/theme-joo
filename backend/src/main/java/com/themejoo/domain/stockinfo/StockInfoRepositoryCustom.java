package com.themejoo.domain.stockinfo;

import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.24
 */
public interface StockInfoRepositoryCustom {
    List<StockInfo> findByStockInfoSeq(Integer stockSeq);
}
