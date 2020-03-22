package com.example.descontoscalcandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Pricetag;
    TextView Output;
    RadioButton Disc1;
    RadioButton Disc2 ;
    RadioButton Disc3 ;
    RadioButton Disc4 ;
    Double Disc1Percent = 5.0;
    Double Disc2Percent = 10.0;
    Double Disc3Percent = 20.0;
    Double Disc4Percent = 50.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pricetag = (EditText)findViewById(R.id.PriceTag);
        Output = (TextView)findViewById(R.id.Output);
        Disc1 = (RadioButton)findViewById(R.id.Discount1);
        Disc2 = (RadioButton)findViewById(R.id.Discount2);
        Disc3 = (RadioButton)findViewById(R.id.Discount3);
        Disc4 = (RadioButton)findViewById(R.id.Discount4);
        Pricetag.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
        Disc1.setText(getResources().getString(R.string.Discount1, Disc1Percent.toString()));
        Disc2.setText(getResources().getString(R.string.Discount2, Disc2Percent.toString()));
        Disc3.setText(getResources().getString(R.string.Discount3, Disc3Percent.toString()));
        Disc4.setText(getResources().getString(R.string.Discount4, Disc4Percent.toString()));
    }
    public void CalcularDisconto(View view)
    {
        try {
            Double preco = Double.parseDouble(Pricetag.getText().toString());
            if (Disc1.isChecked()) {
                preco = preco * (1 - Disc1Percent / 100);
                Output.setText(getResources().getString(R.string.Result) + "" + preco.toString());
            } else if (Disc2.isChecked()) {
                preco = preco * (1 - Disc2Percent / 100);
                Output.setText(getResources().getString(R.string.Result) + "" + preco.toString());
            } else if (Disc3.isChecked()) {
                preco = preco * (1 - Disc3Percent / 100);
                Output.setText(getResources().getString(R.string.Result) + "" + preco.toString());
            } else if (Disc4.isChecked()) {
                preco = preco * (1 - Disc4Percent / 100);
                Output.setText(getResources().getString(R.string.Result) + "" + preco.toString());
            } else {
                Output.setText(getResources().getString(R.string.NoBtnSellected));
            }
        }
        catch (NumberFormatException e)
        {
            Output.setText(getResources().getString(R.string.NaN));
        }
    }
}
