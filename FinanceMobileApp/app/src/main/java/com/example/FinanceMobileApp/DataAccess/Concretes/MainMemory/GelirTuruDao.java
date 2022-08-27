package com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory;

import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirTuruDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirTuru;

import java.util.ArrayList;

public class GelirTuruDao implements IGelirTuruDao {
    ArrayList<GelirTuru> GelirTuruList=new ArrayList<>();

    @Override
    public ArrayList<GelirTuru> GetAll() {
        GelirTuruList.add(new GelirTuru(1,"Kira"));
        GelirTuruList.add(new GelirTuru(2,"Harçlık"));
        GelirTuruList.add(new GelirTuru(3,"Maaş"));
        GelirTuruList.add(new GelirTuru(4,"Diger"));


        return GelirTuruList;
    }

    @Override
    public void Add(GelirTuru entity) {
    }

    @Override
    public void Update(GelirTuru entity) {

    }

    @Override
    public void Delete(GelirTuru entity) {

    }
}
