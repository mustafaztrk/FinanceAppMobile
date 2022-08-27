package com.example.FinanceMobileApp.Business.Abstracts;

import java.util.ArrayList;

public interface IBusinessService<T> {

    ArrayList<T> GetAll();
    void Add(T entity);
    void Update(T entity);
    void Delete(T entity);

}