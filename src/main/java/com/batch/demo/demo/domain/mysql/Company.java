package com.batch.demo.demo.domain.mysql;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "company")
public class Company {

    @Column(name = "CName")
    @Id
    private String companyName;

    @Column(name = "StockPrice", precision = 19, scale = 2)
    private BigDecimal stockPrice;

    @Column(name = "country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}