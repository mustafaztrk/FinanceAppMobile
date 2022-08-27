package com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirTuruDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirTuru;

import java.util.ArrayList;

public class SQLiteGelirTuruDao implements IGelirTuruDao {

    private DataBaseConnection vt;

    public SQLiteGelirTuruDao(DataBaseConnection vt) {
        this.vt = vt;
    }



    @Override
    public ArrayList<GelirTuru> GetAll() {
        ArrayList<GelirTuru> GelirTuruList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM GelirTuru",null);

        while (c.moveToNext()){
            GelirTuru gelirTuru=new GelirTuru(
                    c.getInt(c.getColumnIndex("gelirTuruId")),
                    c.getString(c.getColumnIndex("turAdi"))
            );

            GelirTuruList.add(gelirTuru);
        }

        return GelirTuruList;
    }

    @Override
    public void Add(GelirTuru entity) {

        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("turAdi",entity.getTurAdi());


        dbx.insertOrThrow("GelirTuru",null,degerler);
        dbx.close();
    }

    @Override
    public void Update(GelirTuru entity) {

    }

    @Override
    public void Delete(GelirTuru entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("GelirTuru","Id?",new String[]{String.valueOf(entity.getId())});
        dbx.close();
    }


}
