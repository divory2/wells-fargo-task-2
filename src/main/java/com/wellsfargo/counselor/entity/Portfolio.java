package com.wellsfargo.counselor.entity;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue
    private Long portfolioId;

    @OneToMany
    @JoinColumn(name = "clientId")
    private Client client;

    @Column(nullable = false)
    private Date createionDate;

    public Long getPortfolioId() {
        return portfolioId;
    }
    protected Portfolio(){

    }

    public Portfolio(Client client, Date createionDate) {
        this.client = client;
        this.createionDate = createionDate;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreateionDate() {
        return createionDate;
    }

    public void setCreateionDate(Date createionDate) {
        this.createionDate = createionDate;
    }
    

}
