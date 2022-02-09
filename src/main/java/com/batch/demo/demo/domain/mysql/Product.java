package com.batch.demo.demo.domain.mysql;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "PName", nullable = false)
    private String id;

    @Column(name = "Price", precision = 10)
    private BigDecimal price;

    @Column(name = "Category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "Manufacturer")
    private Company manufacturer;

    public Company getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Company manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }
}