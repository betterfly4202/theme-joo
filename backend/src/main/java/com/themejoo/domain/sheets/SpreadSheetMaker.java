package com.themejoo.domain.sheets;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.themejoo.common.GoogleConnector;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */

@Slf4j
@AllArgsConstructor
public class SpreadSheetMaker {

    @Autowired
    private GoogleConnector googleConnector;

    public void makeSpreadSheet(){
        try{
            Sheets service = googleConnector.getSheetsService();

            Spreadsheet spreadsheet = new Spreadsheet()
                    .setProperties(new SpreadsheetProperties()
                            .setTitle("make new sheets"));
            spreadsheet = service.spreadsheets().create(spreadsheet)
                    .setFields("spreadsheetId")
                    .execute();

            log.info("Spreadsheet ID: " + spreadsheet.getSpreadsheetId());
        }catch (IOException e){
            log.info("can not make spread sheet.");
        }
    }
}

