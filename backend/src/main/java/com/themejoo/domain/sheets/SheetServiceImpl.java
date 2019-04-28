package com.themejoo.domain.sheets;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.themejoo.common.CommonUtills;
import com.themejoo.common.GoogleConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */

@Slf4j
@Service
public class SheetServiceImpl implements SheetService{

    @Autowired
    private GoogleConnector googleConnector;

    private Sheets sheetsService;

    @Value("${google.sheet.id}")
    private String sheetId;

    public SheetServiceImpl() {
        googleConnector= new GoogleConnector();
        sheetsService = googleConnector.getSheetsService();
    }

    public void makeSpreadSheet(String sheetTitle) throws IOException {
        Spreadsheet spreadsheet =
                new Spreadsheet()
                        .setProperties(new SpreadsheetProperties()
                        .setTitle(CommonUtills.currentDate("yyMMdd")+sheetTitle));

        spreadsheet =
                sheetsService.spreadsheets()
                             .create(spreadsheet)
                             .setFields("spreadsheetId")
                             .execute();

        log.info("Spreadsheet ID: " + spreadsheet.getSpreadsheetId());
    }

    public ValueRange readSheets(String range) throws IOException {
        ValueRange sheetValues =
                sheetsService.spreadsheets()
                             .values()
                             .get(sheetId, range)
                             .execute();

        return sheetValues;
    }
}