package com.batch.demo.demo.domain.mysql;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @Column(name = "buyer", nullable = false)
    private String buyer;

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}