package com.caseStudy.eCart.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Component
@Entity
@Table(name = "history")
@EntityListeners(AuditingEntityListener.class)
public class orderHistory  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hid;
    @Column
    private int totalquantity;
    @ManyToOne
    private Product product;

    @ManyToOne
    private userDetails user;
    @Column
    private int totalprice;
    @Column(nullable = false)
    private LocalDate date;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
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
    public LocalDate getDate() {
        date = LocalDate.now();
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();

    }

    public int getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(int totalquantity) {
        this.totalquantity = totalquantity;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}

