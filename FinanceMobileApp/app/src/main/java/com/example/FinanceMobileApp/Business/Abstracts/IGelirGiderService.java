package com.example.FinanceMobileApp.Business.Abstracts;


import com.example.FinanceMobileApp.Entities.Concretes.GelirGider;

import java.util.ArrayList;

public interface IGelirGiderService {
    ArrayList<GelirGider> GetAll();
    void Add(GelirGider gelirGİder);
    void Delete(GelirGider gelirGİder);
    void Update(GelirGider gelirGİder);
}
