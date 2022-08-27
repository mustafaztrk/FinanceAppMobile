package com.example.FinanceMobileApp.Business.Concretes;

import com.example.FinanceMobileApp.Business.Abstracts.IGelirTuruService;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirTuruDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirTuru;

import java.util.ArrayList;

public class GelirTuruManager implements IGelirTuruService {
    IGelirTuruDao _GelirTuruDao;

    public GelirTuruManager(IGelirTuruDao _GelirTuruDao) {
        this._GelirTuruDao = _GelirTuruDao;
    }

    @Override
    public ArrayList<GelirTuru> GetAll() {
        return _GelirTuruDao.GetAll();
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
