package com.example.FinanceMobileApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import org.mariuszgromada.math.mxparser.*;  // eşittir  çin bu kütüphanyi projects de lib e import ettik


public class HesapMakinesi extends Fragment {
    EditText display;
    Button clear,brackets,square,slash,seven,eight,nine,carpı,four,five,six,negative,one,two,three,positive,tZero,zero,nokta,equals;
    private View view;
    ImageButton backspace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_hesap_makinesi, container, false);

        clear=v.findViewById(R.id.clear);
        brackets=v.findViewById(R.id.brackets);
        square=v.findViewById(R.id.square);
        slash=v.findViewById(R.id.slash);
        seven=v.findViewById(R.id.seven);
        eight=v.findViewById(R.id.eight);
        nine=v.findViewById(R.id.nine);
        carpı=v.findViewById(R.id.carpı);
        four=v.findViewById(R.id.four);
        five=v.findViewById(R.id.five);
        six=v.findViewById(R.id.six);
        negative=v.findViewById(R.id.negative);
        one=v.findViewById(R.id.one);
        two=v.findViewById(R.id.two);
        three=v.findViewById(R.id.three);
        positive=v.findViewById(R.id.positive);
        tZero=v.findViewById(R.id.tZero);
        zero=v.findViewById(R.id.zero);
        nokta=v.findViewById(R.id.nokta);
        equals=v.findViewById(R.id.equals);
        backspace=v.findViewById(R.id.backspace);



        // klavyenin çıkmasını engel olmak için
        display = v.findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false); // artık klavye gelmiyor




        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( "tap here".equals(display.getText().toString())){
                    display.setText("");
                }
            }


        });


    seven.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            anyButton(v);
        }
    });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });
        brackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });
        slash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });carpı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });tZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });nokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anyButton(v);
            }
        });





        return v;
    }
    //butona tıklayınca olan şeyler
    public void anyButton(View view) {

        switch (view.getId()) {
            case R.id.clear:
                display.setText("");
                break;
            case R.id.brackets:
                addBrackets();
                break;

            case R.id.square: updateDisplay("^"); break;

            case R.id.slash: updateDisplay("÷"); break;
            case R.id.seven: updateDisplay("7"); break;
            case R.id.eight: updateDisplay("8"); break;
            case R.id.nine: updateDisplay("9"); break;
            case R.id.carpı: updateDisplay("x"); break;  //cross
            case R.id.four: updateDisplay("4"); break;
            case R.id.five: updateDisplay("5"); break;
            case R.id.six: updateDisplay("6"); break;
            case R.id.negative: updateDisplay("-"); break; //minus
            case R.id.one: updateDisplay("1"); break;
            case R.id.two: updateDisplay("2"); break;
            case R.id.three: updateDisplay("3"); break;
            case R.id.positive: updateDisplay("+"); break; //plus
            case R.id.tZero: updateDisplayTwoZero(); break;
            case R.id.zero: updateDisplay("0"); break;
            case R.id.nokta: updateDisplay("."); break;  //dot
            case R.id.equals: calculateTheResult(); break;
            case R.id.backspace: backSpace(); break;



        }

    }



    private void backSpace() {
        int cursorPos=display.getSelectionStart();
        if(cursorPos>0) {
            String oldDisplay=display.getText().toString();
            String liftSideOfDisplay = oldDisplay.substring(0,cursorPos-1);
            String rightSideOfDisplay= oldDisplay.substring(cursorPos);
            String newText=liftSideOfDisplay+rightSideOfDisplay;
            display.setText(newText);
            display.setSelection(cursorPos-1);

        }


    }


    private void calculateTheResult() { // eşittir

        // displaydekini gönderip eşitin karşılığını alıcaz
        String textDisplay= display.getText().toString(); // ekrandakini aldım
        String reTextDisplay= textDisplay.replaceAll("÷","/");  // bütün bölüleri / e çevirdik
        reTextDisplay=textDisplay.replaceAll("x","*");
        Expression ifade= new Expression(reTextDisplay); //ifade nesnesi oluşturuldu veri olarakta reTextDisplay gönderildi
        String result =String.valueOf(ifade.calculate()).toString(); // stringe çevrildi
        if(!result.equals("Nan")){ // doğruysa eşitle
            display.setText(result);
            display.setSelection(result.length());
        } else{

        }
    }


    private void updateDisplayTwoZero() {

        int cursorPos= display.getSelectionStart();
        if(getString(R.string.tap_here).equals(display.getText().toString())){
            display.setText("00");
        }else{
            String oldDisplay=display.getText().toString();
            String liftSideOfDisplay = oldDisplay.substring(0,cursorPos);
            String rightSideOfDisplay= oldDisplay.substring(cursorPos);
            String newText=liftSideOfDisplay+"00"+rightSideOfDisplay;
            display.setText(newText);
        }
        display.setSelection(cursorPos+2);

    }




    private void updateDisplay(String s) {

        int cursorPos= display.getSelectionStart();
        if(getString(R.string.tap_here).equals(display.getText().toString())){
            display.setText(s);
        }else{
            String oldDisplay=display.getText().toString();
            String liftSideOfDisplay = oldDisplay.substring(0,cursorPos);
            String rightSideOfDisplay= oldDisplay.substring(cursorPos);
            String newText=liftSideOfDisplay+s+rightSideOfDisplay;
            display.setText(newText);
        }
        display.setSelection(cursorPos+1);
    }


    private void addBrackets() {
        String textDisplay=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        int countBrackets=0;
        for (int i=0; i<textDisplay.length();i++){
            if(textDisplay.substring(i,i+1).equalsIgnoreCase("(")) countBrackets++;
            if(textDisplay.substring(i,i+1).equalsIgnoreCase(")")) countBrackets--;

        }
        String lastCharOfTextDisplay = textDisplay.substring(textDisplay.length()-1);
        if(countBrackets==0 || lastCharOfTextDisplay.equals("(")) updateDisplay("(");
        else if(countBrackets>0 && !lastCharOfTextDisplay.equals(")")) updateDisplay(")");
    }






}