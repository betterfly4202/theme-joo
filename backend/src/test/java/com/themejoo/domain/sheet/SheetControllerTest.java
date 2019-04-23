package com.themejoo.domain.sheet;

import com.querydsl.jpa.JPQLQuery;
import com.themejoo.domain.batch.QStockInfo;
import com.themejoo.domain.batch.StockInfo;
import com.themejoo.domain.sheets.SheetServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jdo.annotations.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by betterfly
 * Date : 2019.04.23
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SheetControllerTest extends QuerydslRepositorySupport {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SheetServiceImpl sheetService;

    public SheetControllerTest() {
        super(StockInfo.class);
    }

    @Test
    @Transactional
    public void Where조건() {
        List<StockInfo> result = sheetService.findByStockInfoSeq(3);

        log.info("result size : {}", result.size());
    }
}
