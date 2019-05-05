package com.themejoo.domain.sheets;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

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

    @Test
    public void 시트_값_넣기() throws IOException {
        String spreadsheetId = "1xkftjH3E3bsZal4d2tHoq9czJD-HxAVeGHK7lvwBR9Q";
        String range = "A1";

        sheetService.sheetUpdates(spreadsheetId, range);
    }

    @Test
    public void batchUpdate_Test() throws IOException {
        sheetService.batchUpdate();
    }
}