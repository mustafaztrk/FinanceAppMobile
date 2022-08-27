package com.example.FinanceMobileApp.Entities.Concretes;

import com.example.FinanceMobileApp.Entities.Abstracts.IEntity;

public class GelirTuru implements IEntity {
    private int id;
    private String TurAdi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurAdi() {
        return TurAdi;
    }

    public void setTurAdi(String turAdi) {
        TurAdi = turAdi;
    }

    public GelirTuru() {
    }

    public GelirTuru(int id, String turAdi) {
        this.id = id;
        TurAdi = turAdi;
    }



}
