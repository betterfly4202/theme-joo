package com.themejoo.domain.sheets;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.04.28
 */
public class SheetServiceImplTest {
    private SheetServiceImpl sheetService;

    @Before
    public void setUp(){
        sheetService = new SheetServiceImpl();
    }

    @Test
    public void 시트_만들기() throws IOException {
        sheetService.makeSpreadSheet("테스트_시트");
    }

}