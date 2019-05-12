package com.themejoo.domain.stockinfo;

import com.themejoo.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by betterfly
 * Date : 2019.04.24
 */

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Data
@Table(name = "tb_stock_info")
public class StockInfo extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private int stockSeq;
    private String company;
    private String stockCode;
    private String businessType;
    private String mainProduct;
    private String listedDate;
    private String settlingMonth;
    private String president;
    private String homepage;
    private String area;

    @Builder
    public StockInfo(int stockSeq, String company, String stockCode, String businessType, String mainProduct,
                     String listedDate, String settlingMonth, String president, String homepage, String area){
        this.stockSeq = stockSeq;
        this.company = company;
        this.stockCode = adjustStringLength(stockCode);
        this.businessType = businessType;
        this.mainProduct = mainProduct;
        this.listedDate = listedDate;
        this.settlingMonth = settlingMonth;
        this.president = president;
        this.homepage = homepage;
        this.area = area;
    }

    private String adjustStringLength(String value){

        final int STOCK_CODE_LENGTH = 6;

        if (value.length() < STOCK_CODE_LENGTH){
            for (int i=0; i <= STOCK_CODE_LENGTH-value.length(); i++){
                value = "0" + value;
            }
        }

        return value;
    }
}
