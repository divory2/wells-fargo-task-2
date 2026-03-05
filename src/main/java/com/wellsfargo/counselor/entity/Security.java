package com.wellsfargo.counselor.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Security {

    @Id
    @GeneratedValue()
    private Long securityId;


    @OneToMany
    @JoinColumn(name = "portfolioId")
    Portfolio portfolio;

    @Column(nullable = false)
    private String name;


    
    protected Security(){

    }
    public Security(Portfolio portfolio, String name, String category, Float purchasPrice, Date puchaseDate,
            Integer quantity) {
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchasPrice = purchasPrice;
        this.puchaseDate = puchaseDate;
        this.quantity = quantity;
    }

    @Column(nullable = false)
    private String category;


    @Override
    public String toString() {
        return "Security [securityId=" + securityId + ", portfolio=" + portfolio + ", name=" + name + ", category="
                + category + ", purchasPrice=" + purchasPrice + ", puchaseDate=" + puchaseDate + ", quantity="
                + quantity + "]";
    }

    @Column(nullable = false)
    private Float purchasPrice;

    @Column(nullable = false)
    private Date puchaseDate;

    @Column(nullable = false)
    private Integer quantity;

    public Long getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Long securityId) {
        this.securityId = securityId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPurchasPrice() {
        return purchasPrice;
    }

    public void setPurchasPrice(Float purchasPrice) {
        this.purchasPrice = purchasPrice;
    }

    public Date getPuchaseDate() {
        return puchaseDate;
    }

    public void setPuchaseDate(Date puchaseDate) {
        this.puchaseDate = puchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    



}
