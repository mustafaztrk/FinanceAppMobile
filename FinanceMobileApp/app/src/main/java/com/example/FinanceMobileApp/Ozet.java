package com.example.FinanceMobileApp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.FinanceMobileApp.Business.Concretes.GelirGiderManager;

import com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite.DataBaseConnection;
import com.example.FinanceMobileApp.DataAccess.Concretes.SQLite.SQLite.SQLiteGelirGiderDao;

import com.example.FinanceMobileApp.Entities.Concretes.GelirGider;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;


public class Ozet extends Fragment {

    Button btn_veri1,btn_veri2,btn_veri3,btn_veri4,btn_veri5,btn_veri6,btn_veri7;
    private TextView txtTopGelir;
    private TextView txtTopGider;
    private double grafikToplamGider;
    private double grafikToplamGelir;
    private EditText EdtTxt1;

    private Button btn_gelir,btn_gider,btn_tüm;

    private DataBaseConnection vt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_ozet, container, false);

        txtTopGelir=v.findViewById(R.id.txtTopGelir);
        txtTopGider=v.findViewById(R.id.txtTopGider);
        btn_veri1=v.findViewById(R.id.btn_veri1);
        btn_veri2=v.findViewById(R.id.btn_veri2);
        btn_veri3=v.findViewById(R.id.btn_veri3);
        btn_veri4=v.findViewById(R.id.btn_veri4);
        btn_veri5=v.findViewById(R.id.btn_veri5);
        btn_veri6=v.findViewById(R.id.btn_veri6);
        btn_veri7=v.findViewById(R.id.btn_veri7);

        btn_gelir=v.findViewById(R.id.btn_gelir);
        btn_gider=v.findViewById(R.id.btn_gider);
        btn_tüm=v.findViewById(R.id.btn_tüm);


        vt=new DataBaseConnection(getActivity());
        GelirGiderManager gelirGiderManager=new GelirGiderManager(new SQLiteGelirGiderDao(vt));




        //



        Button btn1 = v.findViewById(R.id.btnNakit);
        btn1.setVisibility(View.INVISIBLE);

        Button btn2=v.findViewById(R.id.btn2);
        btn2.setVisibility(View.INVISIBLE);


        BarChart barChart=v.findViewById(R.id.barChart);

        ArrayList<BarEntry> visitors = new ArrayList<>();


        // Verilerin Barlara Yerleştirilmesi
        int i=0;
        for (GelirGider var: gelirGiderManager.GetAll()) {
            visitors.add(new BarEntry(i+1 , (float) var.getTutar()));
            if(var.getTutar()>0) grafikToplamGelir+= var.getTutar();
            else if(var.getTutar()<0) grafikToplamGider+= var.getTutar();
            switch(i) {
                case 0:
                    btn_veri1.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri1.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri1.setBackgroundColor(Color.rgb(243,83,58));
                    break;

                case 1:
                    btn_veri2.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri2.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri2.setBackgroundColor(Color.rgb(243,83,58));
                    break;

                case 2:
                    btn_veri3.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri3.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri3.setBackgroundColor(Color.rgb(243,83,58));
                    break;

                case 3:
                    btn_veri4.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri4.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri4.setBackgroundColor(Color.rgb(243,83,58));
                    break;

                case 4:
                    btn_veri5.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri5.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri5.setBackgroundColor(Color.rgb(243,83,58));
                    break;
                case 5:
                    btn_veri6.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri6.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri6.setBackgroundColor(Color.rgb(243,83,58));
                    break;
                case 6:
                    btn_veri7.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                    if(var.getTür()==1)btn_veri7.setBackgroundColor(Color.rgb(138,216,121));
                    else btn_veri7.setBackgroundColor(Color.rgb(243,83,58));
                    break;

                default:
                    // code block
            }
            i++;

        }

        btn_gelir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int i=0;
                for (GelirGider var: gelirGiderManager.GetAll()) {

                    if (var.getTür()==1){

                        switch(i) {
                            case 0:
                                btn_veri1.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri1.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri1.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 1:
                                btn_veri2.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri2.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri2.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 2:
                                btn_veri3.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri3.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri3.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 3:
                                btn_veri4.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri4.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri4.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 4:
                                btn_veri5.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri5.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri5.setBackgroundColor(Color.rgb(243,83,58));
                                break;
                            case 5:
                                btn_veri6.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri6.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri6.setBackgroundColor(Color.rgb(243,83,58));
                                break;
                            case 6:
                                btn_veri7.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri7.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri7.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            default:
                                // code block
                        }
                        i++;
                    }
                }

            }
        });
        btn_gider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                for (GelirGider var: gelirGiderManager.GetAll()) {

                    if (var.getTür()==2){

                        switch(i) {
                            case 0:
                                btn_veri1.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri1.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri1.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 1:
                                btn_veri2.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri2.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri2.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 2:
                                btn_veri3.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri3.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri3.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 3:
                                btn_veri4.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri4.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri4.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 4:
                                btn_veri5.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri5.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri5.setBackgroundColor(Color.rgb(243,83,58));
                                break;
                            case 5:
                                btn_veri6.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri6.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri6.setBackgroundColor(Color.rgb(243,83,58));
                                break;
                            case 6:
                                btn_veri7.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri7.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri7.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            default:
                                // code block
                        }
                        i++;



                    }
                }
            }
        });

        btn_tüm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                for (GelirGider var: gelirGiderManager.GetAll()) {

                    if (true){

                        switch(i) {
                            case 0:
                                btn_veri1.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri1.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri1.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 1:
                                btn_veri2.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri2.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri2.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 2:
                                btn_veri3.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri3.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri3.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 3:
                                btn_veri4.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri4.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri4.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            case 4:
                                btn_veri5.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri5.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri5.setBackgroundColor(Color.rgb(243,83,58));
                                break;
                            case 5:
                                btn_veri6.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri6.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri6.setBackgroundColor(Color.rgb(243,83,58));
                                break;
                            case 6:
                                btn_veri7.setText(" Tutar:"+ var.getTutar()+ " \n"+var.getDetay());

                                if(var.getTür()==1)btn_veri7.setBackgroundColor(Color.rgb(138,216,121));
                                else btn_veri7.setBackgroundColor(Color.rgb(243,83,58));
                                break;

                            default:
                                // code block
                        }
                        i++;



                    }
                }
            }
        });


        Log.e("askljdjklas",String.valueOf(gelirGiderManager.GetAll().size()));
        Log.e("dkaskd", String.valueOf(txtTopGider));
        txtTopGider.setText(String.valueOf(grafikToplamGider));
        txtTopGelir.setText(String.valueOf(grafikToplamGelir));


        BarDataSet barDataSet= new BarDataSet(visitors,"Günlük");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData= new BarData(barDataSet);

        barChart.setFitBars(false);
        barChart.setData(barData);
        barChart.getDescription().setText("Günlük İstatikler");
        barChart.animateY(2000);





        return v;

    }
    static ArrayList<GelirGider> YediliAl(int sayı,ArrayList<GelirGider> x){
        ArrayList<GelirGider> _GelirGiders=new ArrayList<>();
        int strt=0;
        int fnhs=0;
        if (x.size()<7){
            strt=0;
            fnhs=sayı;
        }
        else {
            strt=sayı-7;
            fnhs=sayı;}

        for (GelirGider var:x){
            if (strt<=fnhs){
                _GelirGiders.add(var);
            }
        }

        return _GelirGiders;
} }