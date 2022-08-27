package com.example.FinanceMobileApp.Entities.Concretes;

import com.example.FinanceMobileApp.Entities.Abstracts.IEntity;

public class GelirGider implements IEntity {
    //tarih tür tutar  detay
    private int id;
    private double tutar ;
    private int tür;
    private String detay;
    private int time;

    private int hesap;//1Nakit, 2Kredi,3Banka hesab

    public GelirGider() {
    }

    public GelirGider(int id, double tutar, int tür, String detay, int time, int hesap) {
        this.id = id;
        this.tutar = tutar;
        this.tür = tür;
        this.detay = detay;
        this.time = time;

        this.hesap = hesap;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public int getTür() {
        return tür;
    }

    public void setTür(int tür) {
        this.tür = tür;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public int getHesap() {
        return hesap;
    }

    public void setHesap(int hesap) {
        this.hesap = hesap;
    }
}
