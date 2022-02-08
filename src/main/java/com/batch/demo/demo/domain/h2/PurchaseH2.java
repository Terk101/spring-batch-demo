package com.batch.demo.demo.domain.h2;

import com.batch.demo.demo.domain.mysql.Product;

import javax.persistence.*;

@Entity
@Table(name = "PurchaseH2")
public class PurchaseH2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product", nullable = false)
    private ProductH2 product;

    @Column(name = "buyer", nullable = false)
    private String buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public ProductH2 getProduct() {
        return product;
    }

    public void setProduct(ProductH2 product) {
        this.product = product;
    }

}
