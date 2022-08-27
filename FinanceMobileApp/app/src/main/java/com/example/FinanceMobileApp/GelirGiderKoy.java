package com.example.FinanceMobileApp;

import androidx.appcompat.app.AppCompatActivity;


import androidx.annotation.Nullable;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FinanceMobileApp.Business.Concretes.GelirGiderManager;
import com.example.FinanceMobileApp.Business.Concretes.GelirTuruManager;
import com.example.FinanceMobileApp.Business.Concretes.GiderTuruManager;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirGiderDao;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirTuruDao;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGiderTuruDao;
import com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory.GelirGiderDao;
import com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory.GelirTuruDao;
import com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory.GiderTuruDao;

import com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite.DataBaseConnection;
import com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite.SQLiteGelirGiderDao;
import com.example.FinanceMobileApp.Entities.Concretes.GelirGider;
import com.example.FinanceMobileApp.Entities.Concretes.GelirTuru;
import com.example.FinanceMobileApp.Entities.Concretes.GiderTuru;

import java.util.ArrayList;
import java.util.Calendar;






public class GelirGiderKoy extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<GelirTuru> GlrList=new ArrayList<GelirTuru>();
    private ArrayList<GiderTuru> GdrList=new ArrayList<GiderTuru>();
    private ArrayAdapter<String> arrayAdapter;
    private ImageButton btn_cek;
    private Button btnKaydet,btnGelir,btnGider;
    private ImageView imgVFoto;
    private static final int CAMERA_REQUEST=0;

    private ImageButton imgBtnTarihSecim;
    private DatePickerDialog datePickerDialog;
    private TextView txtVTarih;
    private Calendar calendar;
    private int yıl, ay, gun;

    //Kaydetme
    private EditText eTxtTutar,eDTxtDetay;
    private int hesapTür=1;
    private Button btnNakit,btnKredi,btnBanka;
    private Spinner spnTür;
    private int tür=1;
    private Bitmap fototemp;

    double a=1;

    private DataBaseConnection vt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir_gider_koy);

        btn_cek=findViewById(R.id.imgBtnFoto);
        btnKaydet=findViewById(R.id.btnKaydet);

        imgVFoto=findViewById(R.id.imgVFoto);

        spinner=findViewById(R.id.spnTür);

        btnGelir=findViewById(R.id.btnGelir);
        btnGider=findViewById(R.id.btnGider);

        eTxtTutar=findViewById(R.id.eTxtTutar);
        eDTxtDetay=findViewById(R.id.eDTxtDetay);
        spnTür=findViewById(R.id.spnTür);


        btnNakit=findViewById(R.id.btnNakit);
        btnKredi=findViewById(R.id.btnKredi);
        btnBanka=findViewById(R.id.btnBanka);


        IGelirTuruDao gelirTuruDao=new GelirTuruDao();
        GelirTuruManager gelirTuruManager=new GelirTuruManager(gelirTuruDao);

        IGiderTuruDao giderTuruDao=new GiderTuruDao();
        GiderTuruManager giderTuruManager=new GiderTuruManager(giderTuruDao);

        GlrList=gelirTuruManager.GetAll();
        GdrList=giderTuruManager.GetAll();


        ArrayList<String> gelirGiderTemp=new ArrayList<>();

        btnGelir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gelirGiderTemp.clear();
                for (GelirTuru var : GlrList)
                {
                    gelirGiderTemp.add(var.getTurAdi());

                }
                spinner.setAdapter(arrayAdapter);
                a=a*a;
                tür=1;
            }
        });
        btnGider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                gelirGiderTemp.clear();
                for (GiderTuru var : GdrList)
                {

                    gelirGiderTemp.add(var.getGiderTurAdi());

                }
                spinner.setAdapter(arrayAdapter);
                a=a*-1;

                tür=2;
            }
        });

        arrayAdapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,gelirGiderTemp);


        spinner.setAdapter(arrayAdapter);



        btn_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });






        imgBtnTarihSecim = findViewById(R.id.imgBtnTarihSecim);
        txtVTarih = findViewById(R.id.txtVTarih);

        calendar = Calendar.getInstance();
        yıl = calendar.get(Calendar.YEAR);
        ay = calendar.get(Calendar.MONTH);
        gun = calendar.get(Calendar.DAY_OF_MONTH);
        txtVTarih.setText(gun+"/"+(ay+1)+"/"+yıl);
        imgBtnTarihSecim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                yıl = calendar.get(Calendar.YEAR);
                ay = calendar.get(Calendar.MONTH);
                gun = calendar.get(Calendar.DAY_OF_MONTH);
                txtVTarih.setText(gun+"/"+(ay+1)+"/"+yıl);
                datePickerDialog = new DatePickerDialog(GelirGiderKoy.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                txtVTarih.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, yıl, ay, gun);
                datePickerDialog.show();
            }
        });



        //Kaydetme Kısmı
        IGelirGiderDao gelirGİderDao=new GelirGiderDao();
        GelirGiderManager gelirGiderManager=new GelirGiderManager(gelirGİderDao);


        btnNakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hesapTür=1;
                Toast.makeText(getApplicationContext(),"Hesap türü 'Nakit' olarak secildi ",Toast.LENGTH_LONG).show();

            }
        });
        btnKredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hesapTür=2;
                Toast.makeText(getApplicationContext(),"Hesap türü 'Kredi Kartı' olarak secildi ",Toast.LENGTH_LONG).show();

            }
        });
        btnBanka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b= 1;
                double c=b*(-1);

                hesapTür=3;
                Toast.makeText(getApplicationContext(),"Hesap türü 'Hesap Kartı' olarak secildi ",Toast.LENGTH_LONG).show();
            }
        });




        vt=new DataBaseConnection(this);
        GelirGiderManager manager=new GelirGiderManager(new SQLiteGelirGiderDao(vt));

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // id   tutar               tür                     detay                   tarih               foto
                // gelirGiderManager.Add(new GelirGİder(1,eTxtTutar.getText(),spnTür.getSelectedItem(),eDTxtDetay.getText(),txtVTarih.getText(),imgVFoto.getDrawable(),hesapTür));
                GelirGider temp=new GelirGider();
                temp.setId(1);
                double c=0;
                c=Double.valueOf(String.valueOf(eTxtTutar.getText()));
                temp.setTutar(Double.parseDouble(String.valueOf(c*a)));


                temp.setDetay((eDTxtDetay.getText()).toString());
                // temp.setTime((Time) Calendar.getInstance().getTime());
                // temp.setFoto(fototemp);
                temp.setHesap(hesapTür);
                temp.setTür(tür);
                manager.Add(temp);

            }
        });



        int i=0;



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imgVFoto.setImageBitmap(image);
            fototemp=image;
        }
    }
}
