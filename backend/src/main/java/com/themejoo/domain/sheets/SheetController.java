package com.themejoo.domain.sheets;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.themejoo.domain.batch.StockInfo;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.11
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Api(value = "v1/sheet", description = "sheet api")
public class SheetController {
    private SpreadSheetMaker sheetMaker;


    @Autowired
    private SheetServiceImpl sheetService;

    @GetMapping("/sheet")
    public void getSheet(){
        try{
            ValueRange list = sheetMaker.readSheets("A1:L79");
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/stock")
    public List<StockInfo> getStockListFromSeq(
            @RequestParam Integer stockSeq){

        return sheetService.findByStockInfoSeq(stockSeq);
    }
}
