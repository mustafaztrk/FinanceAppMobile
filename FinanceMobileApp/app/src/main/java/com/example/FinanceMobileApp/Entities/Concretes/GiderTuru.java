package com.example.FinanceMobileApp.Entities.Concretes;

import com.example.FinanceMobileApp.Entities.Abstracts.IEntity;

public class GiderTuru implements IEntity {
    private int id;
    private String GiderTurAdi;


    public GiderTuru() {
    }

    public GiderTuru(int id, String giderTurAdi) {
        this.id = id;
        GiderTurAdi = giderTurAdi;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiderTurAdi() {
        return GiderTurAdi;
    }

    public void setGiderTurAdi(String giderTurAdi) {
        GiderTurAdi = giderTurAdi;
    }
}
