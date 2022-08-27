package com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory;

import com.example.FinanceMobileApp.DataAccess.Abstracts.IGiderTuruDao;
import com.example.FinanceMobileApp.Entities.Concretes.GiderTuru;

import java.util.ArrayList;

public class GiderTuruDao implements IGiderTuruDao {
private ArrayList<GiderTuru> GiderTuruList=new ArrayList<>();

    @Override
    public ArrayList<GiderTuru> GetAll() {
        GiderTuruList.add(new GiderTuru(1,"Market"));
        GiderTuruList.add(new GiderTuru(2,"Ulaşım"));
        GiderTuruList.add(new GiderTuru(3,"Giyim"));
        GiderTuruList.add(new GiderTuru(4,"Yemek"));
        GiderTuruList.add(new GiderTuru(5,"Fatura"));
        GiderTuruList.add(new GiderTuru(6,"Diger"));


        return GiderTuruList;
    }

    @Override
    public void Add(GiderTuru entity) {

    }

    @Override
    public void Update(GiderTuru entity) {

    }

    @Override
    public void Delete(GiderTuru entity) {

    }
}
