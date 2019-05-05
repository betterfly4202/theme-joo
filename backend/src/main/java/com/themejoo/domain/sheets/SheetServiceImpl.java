package com.themejoo.domain.sheets;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import com.themejoo.common.CommonUtills;
import com.themejoo.common.GoogleConnector;
import com.themejoo.common.SheetsConstants;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.ValueInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.06
 */

@Slf4j
@Service
public class SheetServiceImpl{

    @Autowired
    private GoogleConnector googleConnector;

    private Sheets sheetsService;

    @Value("${google.sheet.id}")
    private String sheetId;

    public SheetServiceImpl() {
        googleConnector= new GoogleConnector();
        sheetsService = googleConnector.getSheets();
    }

    public void makeSpreadSheet(String sheetTitle) throws IOException {
        Spreadsheet spreadsheet =
                new Spreadsheet()
                        .setProperties(new SpreadsheetProperties()
                        .setTitle(CommonUtills.currentDate("yyMMdd")+"_"+sheetTitle));

        spreadsheet =
                sheetsService.spreadsheets()
                             .create(spreadsheet)
                             .execute();

        log.info("Spreadsheet ID: " + spreadsheet.getSpreadsheetId());
    }

    public ValueRange readSheets(String sheetId, String range) throws IOException {
        ValueRange sheetValues =
                sheetsService.spreadsheets()
                             .values()
                             .get(sheetId, range)
                             .execute();

        return sheetValues;
    }

    public void sheetUpdates(String sheetId, String range) throws IOException {
        Sheets sheetsService = googleConnector.getSheets();
        Sheets.Spreadsheets.Values.Update request =
                sheetsService.spreadsheets().values().update(sheetId, range, setSpreadValues());
        request.setValueInputOption(SheetsConstants.VALUE_INPUT_OPTIONS);

        UpdateValuesResponse response = request.execute();
        response.getUpdatedRange();
        response.getUpdatedData();

        System.out.println(response);
    }

    public void batchUpdate() throws IOException {
        // The new values to apply to the spreadsheet.
        String spreadsheetId = "1xkftjH3E3bsZal4d2tHoq9czJD-HxAVeGHK7lvwBR9Q";
        List<ValueRange> data = new ArrayList<>(); // TODO: Update placeholder value.


        List<List<Object>> list = new ArrayList<>();
        List<Object> subList = new ArrayList<>();
        subList.add("=googlefinance(\"KRX:306200\", \"price\", TODAY()-30, TODAY(), 7)");

        list.add(subList);

        ValueRange valueRange = new ValueRange();
        valueRange.setRange("A1");
        valueRange.setMajorDimension(SheetsConstants.MAJOR_DIMENSION);
        valueRange.setValues(list);
        data.add(valueRange);

        // TODO: Assign values to desired fields of `requestBody`:
        BatchUpdateValuesRequest requestBody = new BatchUpdateValuesRequest();
        requestBody.setValueInputOption(SheetsConstants.VALUE_INPUT_OPTIONS);
        requestBody.setData(data);

        Sheets sheetsService = googleConnector.getSheets();
        Sheets.Spreadsheets.Values.BatchUpdate request =
                sheetsService.spreadsheets().values().batchUpdate(spreadsheetId, requestBody);

        BatchUpdateValuesResponse response = request.execute();

        // TODO: Change code below to process the `response` object:
        System.out.println(response);
    }

    private ValueRange setSpreadValues(){
        ValueRange requestBody = new ValueRange();
        List<List<Object>> list = new ArrayList<>();
        List<Object> subList = new ArrayList<>();
        subList.add("=googlefinance(\"KRX:306200\", \"price\", TODAY()-30, TODAY(), 7)");

        list.add(subList);

        requestBody.setMajorDimension(SheetsConstants.MAJOR_DIMENSION)
                .setValues(list);

        return requestBody;
    }
}