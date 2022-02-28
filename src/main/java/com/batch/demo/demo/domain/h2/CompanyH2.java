package com.batch.demo.demo.domain.h2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "CompanyH2")
public class CompanyH2 {

    @Column(name = "Cname")
    @Id
    private String companyName;

    @Column(name = "StockPrice")
    private BigDecimal stockPrice;

    @Column(name = "Country")
    private String country;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() {
        return "CompanyH2{" +
                "companyName='" + companyName + '\'' +
                ", stockPrice=" + stockPrice +
                ", country='" + country + '\'' +
                '}';
    }
}
