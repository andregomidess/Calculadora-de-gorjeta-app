package com.cursoandroid.calculadoradegorjetaprogresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textViewGorjeta, textViewTotal, textViewPorc;
    private TextInputEditText valor;
    private SeekBar seekBarPorc;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewPorc = findViewById(R.id.textViewPorc);
        valor = findViewById(R.id.inputTextValor);
        seekBarPorc = findViewById(R.id.seekBarPorc);

        seekBarPorc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                textViewPorc.setText(Math.round(porcentagem) + "%");
                calculaGorjeta();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calculaGorjeta(){

        String valorRecuperado = valor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro!", Toast.LENGTH_LONG).show();
        }else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = (double) valorDigitado * (porcentagem/100);
            double valorTotal = gorjeta + valorDigitado;
            textViewGorjeta.setText("R$ " + String.valueOf(Math.round(gorjeta)));
            textViewTotal.setText("R$ " + String.valueOf(valorTotal));

        }

    }


}