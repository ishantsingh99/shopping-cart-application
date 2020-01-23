package com.caseStudy.eCart.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "cart")
@EntityListeners(AuditingEntityListener.class)
public class cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private userDetails user;
    @Column
    private int quantity;
    @Column
    private int totalprice;

    public cart()
    { }
    public cart(Product product, userDetails user, int quantity, int totalprice) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }
    public cart(Product product, userDetails user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public userDetails getUser() {
        return user;
    }

    public void setUser(userDetails user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
