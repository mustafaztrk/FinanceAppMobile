package com.example.FinanceMobileApp.Business.Concretes;

import com.example.FinanceMobileApp.Business.Abstracts.IGiderTuruService;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGiderTuruDao;
import com.example.FinanceMobileApp.Entities.Concretes.GiderTuru;

import java.util.ArrayList;

public class GiderTuruManager implements IGiderTuruService {
    IGiderTuruDao _IGiderTuruDao;

    public GiderTuruManager(IGiderTuruDao _IGiderTuruDao) {
        this._IGiderTuruDao = _IGiderTuruDao;
    }

    @Override
    public ArrayList<GiderTuru> GetAll() {
        return _IGiderTuruDao.GetAll();
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
