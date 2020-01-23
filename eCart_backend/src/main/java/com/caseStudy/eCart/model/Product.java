package com.caseStudy.eCart.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Component
@Entity
@Table(name = "Products")
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "Name")
    private String name;
    @Column(name = "Price")
    private int price;
    @Column(name = "Active")
    private int active;
    @Column(name = "Src")
    private String src;
    @Column(name = "Category")
    private String category;
    @Column(name = "DeliveredBy")
    private String deliveredby;
    @Column(name = "Others")
    private String others;

    public Product() {
    }
        public Long getId () {
            return this.pid;
        }

        public void setId ( Long pid){
            this.pid = pid;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public int getPrice () {
            return price;
        }

        public void setPrice ( int price){
            this.price = price;
        }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDeliveredby() {
        return deliveredby;
    }

    public void setDeliveredby(String deliveredby) {
        this.deliveredby = deliveredby;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
