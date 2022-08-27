package com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory;

import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirGiderDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirGider;

import java.util.ArrayList;

public class GelirGiderDao implements IGelirGiderDao {
    ArrayList<GelirGider> GelirGiderList=new ArrayList<>();


    @Override
    public ArrayList<GelirGider> GetAll() {

       // GelirGiderList.add(new GelirGİder(500,-1,"Lcw mont aldım",));
        //GelirGiderList.add(new GelirGİder(1500,-1,"Kira","12.07.2022"));
        //GelirGiderList.add(new GelirGİder(5000,1,"Maaş","12.07.2022"));
        //GelirGiderList.add(new GelirGİder(300,-1,"Lcw mont aldım",".07.2022"));
        //GelirGiderList.add(new GelirGİder(100,-1,"Lcw mont aldım","12.07.2022"));
        //GelirGiderList.add(new GelirGİder(50,1,"market","12.07.2022"));

        return GelirGiderList;
    }

    @Override
    public void Add(GelirGider entity) {
        GelirGiderList.add(entity);
    }

    @Override
    public void Update(GelirGider entity) {

    }

    @Override
    public void Delete(GelirGider entity) {

    }
}
