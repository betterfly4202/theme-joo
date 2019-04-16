package com.themejoo.domain.sheets;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.themejoo.common.GoogleConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */

@Slf4j
@Component
public class SpreadSheetMaker {

    @Autowired
    private GoogleConnector googleConnector;

//    @Value("${google.sheet.id}")
//    private String sheetId;

    public SpreadSheetMaker() {
        googleConnector = new GoogleConnector();
    }

    public void makeSpreadSheet(String sheetTitle) throws IOException {
        Sheets service = googleConnector.getSheetsService();

        Spreadsheet spreadsheet = new Spreadsheet()
                .setProperties(new SpreadsheetProperties()
                        .setTitle(sheetTitle));

        spreadsheet = service.spreadsheets().create(spreadsheet)
                .setFields("spreadsheetId")
                .execute();

        log.info("Spreadsheet ID: " + spreadsheet.getSpreadsheetId());
    }

    public ValueRange readSheets(String range) throws IOException {
        Sheets service = googleConnector.getSheetsService();
        String sheetId = "1QRZM7G5VN39ftI16dw033zotxNaJwkiQu3aQpsJUK2A";
        ValueRange sheetValues = service.spreadsheets().values().get(sheetId, range).execute();

        return sheetValues;
    }
}