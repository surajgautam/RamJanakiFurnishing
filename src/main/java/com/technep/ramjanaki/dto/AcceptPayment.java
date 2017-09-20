package com.technep.ramjanaki.dto;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

public class AcceptPayment {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Double price;

    private Double taxamount;

    private Double totalprice;


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTaxamount() {
        return taxamount;
    }

    public void setTaxamount(Double taxamount) {
        this.taxamount = taxamount;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "AcceptPayment{" +
                "price=" + price +
                ", taxamount=" + taxamount +
                ", totalprice=" + totalprice +
                '}';
    }
}
