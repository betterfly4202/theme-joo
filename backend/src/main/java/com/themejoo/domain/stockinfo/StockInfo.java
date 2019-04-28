package com.themejoo.domain.stockinfo;

import com.themejoo.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

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
    private int stockCode;
    private String businessType;
    private String mainProduct;
    private String listedDate;
    private String settlingMonth;
    private String president;
    private String homepage;
    private String area;

    @Builder
    public StockInfo(int stockSeq, String company, int stockCode, String businessType, String mainProduct,
                     String listedDate, String settlingMonth, String president, String homepage, String area){
        this.stockSeq = stockSeq;
        this.company = company;
        this.stockCode = stockCode;
        this.businessType = businessType;
        this.mainProduct = mainProduct;
        this.listedDate = listedDate;
        this.settlingMonth = settlingMonth;
        this.president = president;
        this.homepage = homepage;
        this.area = area;
    }
}
