package com.themejoo.domain.sheets;

import com.google.api.services.sheets.v4.model.ValueRange;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterfly
 * Date : 2019.04.11
 */
@RestController
@AllArgsConstructor
public class SheetController {
    private SpreadSheetMaker sheetMaker;

    @GetMapping("/sheet")
    public void getSheet(){
        try{
            ValueRange list = sheetMaker.readSheets("A1:L79");
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
