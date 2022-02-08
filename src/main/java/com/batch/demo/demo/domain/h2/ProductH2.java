package com.batch.demo.demo.domain.h2;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ProductH2")
public class ProductH2 {
    @Id
    @Column(name = "PName", nullable = false)
    private String productName;

    @Column(name = "Price", precision = 10)
    private BigDecimal price;

    @Column(name = "Category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "Manufacturer")
    private CompanyH2 manufacturer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CompanyH2 getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CompanyH2 manufacturer) {
        this.manufacturer = manufacturer;
    }
}
