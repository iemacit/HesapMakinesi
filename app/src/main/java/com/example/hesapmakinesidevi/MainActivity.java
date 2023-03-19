package com.example.hesapmakinesidevi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText text;
    TextView islemAdi;
    
    double sayi1,sayi2,sonuc;
    String islem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        final Button carp=findViewById(R.id.buttonCarp);
        final Button bolme=findViewById(R.id.buttonBolme);
        final Button topla=findViewById(R.id.buttonTopla);
        final Button cikar=findViewById(R.id.buttonCikar);
        final Button esittir=findViewById(R.id.buttonSonuc);
        islemAdi=findViewById(R.id.textView2);
        text = findViewById(R.id.text);
        text.setShowSoftInputOnFocus(false);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.temp).equals(text.getText().toString())) {
                    text.setText("");
                }
            }
        });
        topla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayi1=Double.parseDouble(text.getText().toString());
                islem="+";
                islemAdi.setText("Şuanda Toplama islemi yapıyorsunuz");
                text.setText("");

        }
        });
        cikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi1=Double.parseDouble(text.getText().toString());
                islem="-";
                islemAdi.setText("Şuanda Çıkarma islemi yapıyorsunuz");
                text.setText("");
            }
        });
        bolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi1=Double.parseDouble(text.getText().toString());
                islem="/";
                islemAdi.setText("Şuanda Bölme islemi yapıyorsunuz");
                text.setText("");
            }
        });
        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi1=Double.parseDouble(text.getText().toString());
                islem="*";
                islemAdi.setText("Şuanda Çarpma islemi yapıyorsunuz");
                text.setText("");

            }
        });
        esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi2=Integer.parseInt(text.getText().toString());
                switch (islem){
                    case "+":
                        sonuc=sayi1+sayi2;
                        break;
                    case "-":
                        sonuc=sayi1-sayi2;
                        break;
                    case "*":
                        sonuc=sayi1*sayi2;
                        break;
                    case "/":
                        sonuc=sayi1/sayi2;
                        break;
                }
                text.setText(""+sonuc);
                islemAdi.setText("İşlem Yapmaya Devam Etmek için yeni bir sembol Seçiniz");
            }
        });
    }


    public void onClickbutton(View view) {
        switch (view.getId()) {
            case R.id.button0:
                updateDisplay("0");
                break;
            case R.id.button1:
                updateDisplay("1");
                break;
            case R.id.button2:
                updateDisplay("2");
                break;
            case R.id.button3:
                updateDisplay("3");
                break;
            case R.id.button4:
                updateDisplay("4");
                break;
            case R.id.button5:
                updateDisplay("5");
                break;
            case R.id.button6:
                updateDisplay("6");
                break;
            case R.id.button7:
                updateDisplay("7");
                break;
            case R.id.button8:
                updateDisplay("8");
                break;
            case R.id.button9:
                updateDisplay("9");
                break;
            case R.id.Temizle:
                text.setText("");
                break;

            case R.id.backSpace:
                backSpace();
                break;
        }
        islemAdi.setText("");
    }

    private void updateDisplay(String addChar) {
        int cursurPos = text.getSelectionStart();
        if (getString(R.string.temp).equals(text.getText().toString())) {
            text.setText(addChar);
        } else {
            String oldTest = text.getText().toString();
            String leftSideofText = oldTest.substring(0, cursurPos);
            String rightSideText = oldTest.substring(cursurPos);
            String newTest = leftSideofText + addChar + rightSideText;
            text.setText(newTest);
            ;
        }
        text.setSelection(cursurPos + 1);
    }

    private void backSpace() {
        int cursurPos = text.getSelectionStart();
        if (cursurPos > 0) {
            String oldTest = text.getText().toString();
            String leftSideofText = oldTest.substring(0, cursurPos - 1);
            String rightSideText = oldTest.substring(cursurPos);
            String newTest = leftSideofText + rightSideText;
            text.setText(newTest);
            text.setSelection(cursurPos - 1);

        }
    }

    private void calculateResult() {
/*
        String textDisplay = text.getText().toString();

        Expression ifade = new Expression(textDisplay);


        String result = String.valueOf(ifade.calculate()).toString();
        if (!result.equals("NaN")) {
            text.setText(result);
            text.setSelection(result.length());
        }*/

    }




}