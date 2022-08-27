package com.example.FinanceMobileApp.DataAccess.Abstracts;


import java.util.ArrayList;

public interface IEntityRepository<T> {

    ArrayList<T> GetAll();
    void Add(T entity);
    void Update(T entity);
    void Delete(T entity);

}
