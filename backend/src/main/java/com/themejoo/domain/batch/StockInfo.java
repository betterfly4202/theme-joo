package com.themejoo.domain.batch;

import com.themejoo.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.20
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_stock_info")
@Data
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

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stockInfo", cascade = CascadeType.PERSIST)
//    private List<StockInfo> stockInfoList = new ArrayList<>();

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
