package com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.FinanceMobileApp.DataAccess.Abstracts.IGiderTuruDao;
import com.example.FinanceMobileApp.Entities.Concretes.GiderTuru;

import java.util.ArrayList;

public class SQLiteGiderTuruDao implements IGiderTuruDao {
    private DataBaseConnection vt;

    public SQLiteGiderTuruDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<GiderTuru> GetAll() {

        ArrayList<GiderTuru> GiderTuruList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM GiderTuru",null);



        while (c.moveToNext()){
            GiderTuru giderTuru=new GiderTuru(
                    c.getInt(c.getColumnIndex("giderTuruId")),
                    c.getString(c.getColumnIndex("turAdi"))
            );

            GiderTuruList.add(giderTuru);
        }


        return GiderTuruList;
    }

    @Override
    public void Add(GiderTuru entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("turAdi",entity.getGiderTurAdi());


        dbx.insertOrThrow("GiderTuru",null,degerler);
        dbx.close();
    }

    @Override
    public void Update(GiderTuru entity) {

    }

    @Override
    public void Delete(GiderTuru entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("GiderTuru","Id?",new String[]{String.valueOf(entity.getId())});
        dbx.close();
    }
}
