package com.themejoo.domain.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.20
 */
@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo, Long> {
}
