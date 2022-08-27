package com.example.FinanceMobileApp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.ArrayList;

import com.example.FinanceMobileApp.Business.Concretes.GelirGiderManager;
import com.example.FinanceMobileApp.DataAccess.Abstracts.IGelirGiderDao;
import com.example.FinanceMobileApp.DataAccess.Concretes.MainMemory.GelirGiderDao;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

public class Home extends Fragment {

    private  PieChart pieChart;
    private ImageButton btnEkle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v =inflater.inflate(R.layout.fragment_home, container, false);



        pieChart=v.findViewById(R.id.pieChart);
        loadPieChartData();
        setupPieChart();

        btnEkle=v.findViewById(R.id.btnEkle);



        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GelirGiderKoy.class);
                startActivity(intent);
            }
        });
        IGelirGiderDao gelirGİderDao=new GelirGiderDao();
        GelirGiderManager gelirGiderManager=new GelirGiderManager(gelirGİderDao);

        return v;
    }
    private void setupPieChart(){

        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setCenterText("5000");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);
        pieChart.setHoleRadius(50);
        pieChart.setCenterTextRadiusPercent(500);



        Legend l=pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
        l.setForm(Legend.LegendForm.CIRCLE);
    }


    private void loadPieChartData(){
        ArrayList<PieEntry> entries= new ArrayList<>();
        entries.add(new PieEntry(0.5f,"Gider"));
        entries.add(new PieEntry(0.15f,"Mevcut para"));




        ArrayList<Integer> colors=new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS){
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet dataSet=new PieDataSet(entries,"Cüzdan");
        dataSet.setColors(colors);

        PieData data =new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();


        pieChart.animateY(1400, Easing.EaseInOutQuad);

    }
}