package com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseConnection extends SQLiteOpenHelper {
    public DataBaseConnection(@Nullable Context context) {
        super(context, "GelirGiderTakibi", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"GelirGider\" (\n" +
                "\t\"gelirGiderId\"\tINTEGER,\n" +
                "\t\"tutar\"\tTEXT,\n" +
                "\t\"tur\"\tTEXT,\n" +
                "\t\"detay\"\tTEXT,\n" +
                "\t\"time\"\tINTEGER,\n" +
                "\t\"hesap\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"gelirGiderId\")\n" +
                ");");

        db.execSQL("CREATE TABLE \"GelirTuru\" (\n" +
                "\t\"gelirTuruId\"\tINTEGER,\n" +
                "\t\"turAdi\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"gelirTuruId\")\n" +
                ");");

         db.execSQL("CREATE TABLE \"GiderTuru\" (\n" +
               "\t\"giderTuruId\"\tINTEGER,\n" +
               "\t\"turAdi\"\tTEXT,\n" +
               "\tPRIMARY KEY(\"giderTuruId\" )\n" +
                ");");






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS GelirGider");
        onCreate(db);
    }
}
