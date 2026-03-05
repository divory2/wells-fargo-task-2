package com.wellsfargo.counselor.entity;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {
    @Id
    @GeneratedValue()
    private Long clientId;

    @Column(nullable =false)
    private String client_FirstName;
    
    @Column(nullable = false)
    private String client_LastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String client_Email;


    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;


    protected Client (){

    }


    public Long getClientId() {
        return clientId;
    }


    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


    public void setClient_FirstName(String client_FirstName) {
        this.client_FirstName = client_FirstName;
    }


    public void setClient_LastName(String client_LastName) {
        this.client_LastName = client_LastName;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setClient_Email(String client_Email) {
        this.client_Email = client_Email;
    }


    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }


    public String getClient_FirstName() {
        return client_FirstName;
    }


    public String getClient_LastName() {
        return client_LastName;
    }


    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }


    public String getClient_Email() {
        return client_Email;
    }


    public Advisor getAdvisor() {
        return advisor;
    }


    public Client(String client_FirstName, String client_LastName, String address, String phone, String client_Email,
            Advisor advisor) {
        this.client_FirstName = client_FirstName;
        this.client_LastName = client_LastName;
        this.address = address;
        this.phone = phone;
        this.client_Email = client_Email;
        this.advisor = advisor;
    }


    @Override
    public String toString() {
        return "Client [clientId=" + clientId + ", client_FirstName=" + client_FirstName + ", client_LastName="
                + client_LastName + ", address=" + address + ", phone=" + phone + ", client_Email=" + client_Email
                + ", advisor=" + advisor + "]";
    }

    


    





    


}
