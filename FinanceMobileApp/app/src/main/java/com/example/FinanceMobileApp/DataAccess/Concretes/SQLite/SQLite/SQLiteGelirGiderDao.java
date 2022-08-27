package com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirGiderDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirGider;

import java.util.ArrayList;

public class SQLiteGelirGiderDao implements IGelirGiderDao {
    private DataBaseConnection vt;

    public SQLiteGelirGiderDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<GelirGider> GetAll() {
        ArrayList<GelirGider> GelirGiderList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM GelirGider",null);

        while (c.moveToNext()){
            GelirGider gelirGider=new GelirGider(
                    c.getInt(c.getColumnIndex("gelirGiderId"))
                    ,Double.valueOf(c.getString(c.getColumnIndex("tutar"))),
                    c.getInt(c.getColumnIndex("tur")),
                    c.getString(c.getColumnIndex("detay")),
                   c.getInt(c.getColumnIndex("time")),
                    c.getInt(c.getColumnIndex("hesap")));

            GelirGiderList.add(gelirGider);
        }

        return GelirGiderList;
    }

    @Override
    public void Add(GelirGider entity) {

        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("tutar",entity.getTutar());
        degerler.put("tur",entity.getTür());
        degerler.put("detay",entity.getDetay());
         degerler.put("time",entity.getTime());
        degerler.put("hesap",entity.getHesap());

        dbx.insertOrThrow("GelirGider",null,degerler);
        dbx.close();

    }

    @Override
    public void Update(GelirGider entity) {

    }

    @Override
    public void Delete(GelirGider entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("GelirGider","Id?",new String[]{String.valueOf(entity.getId())});
        dbx.close();

    }
}
