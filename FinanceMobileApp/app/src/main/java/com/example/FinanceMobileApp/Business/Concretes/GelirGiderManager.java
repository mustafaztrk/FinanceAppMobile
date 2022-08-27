package com.example.FinanceMobileApp.Business.Concretes;



import com.example.FinanceMobileApp.Business.Abstracts.IGelirGiderService;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirGiderDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirGider;

import java.util.ArrayList;

public class GelirGiderManager implements IGelirGiderService {
    IGelirGiderDao _GelirGİderDao;

    public GelirGiderManager(IGelirGiderDao _GelirGİderDao) {
        this._GelirGİderDao = _GelirGİderDao;
    }

    @Override
    public ArrayList<GelirGider> GetAll( ) {
        return _GelirGİderDao.GetAll();
    }

    @Override
    public void Add(GelirGider entity) {
        _GelirGİderDao.Add(entity);
    }

    @Override
    public void Update(GelirGider entity) {

    }

    @Override
    public void Delete(GelirGider entity) {

    }
}
