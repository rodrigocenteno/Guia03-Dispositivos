package com.example.guia03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SeleccionarTrabajadorActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rbTH, rbTC;
    private Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_trabajador);

        rbTC = findViewById(R.id.rbTrabCompleto);
        rbTC.setOnClickListener(this);
        rbTH = findViewById(R.id.rbTrabHora);
        rbTH.setOnClickListener(this);
        siguiente = findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSiguiente: {
                if (rbTH.isChecked()) {
                    Intent i1 = new Intent(this, TrabajadorHoraActivity.class);
                    startActivity(i1);
                } else if (rbTC.isChecked()) {
                    Intent i2 = new Intent(this, TrabajadorTiempoCompletoActivity.class);
                    startActivity(i2);
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("¡Aviso!")
                            .setMessage("Selecciona una opción")
                            .setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }
                break;

            }
        }

    }
    private Boolean validar(){
        Boolean r = false;
        if(rbTC.isChecked()){
            r = true;
        }
        if(rbTH.isChecked()){
            r = true;
        }
        return r;
    }
}