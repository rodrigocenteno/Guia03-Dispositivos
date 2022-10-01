package com.example.guia03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guia03.Repository.TrabajadorRepository;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TrabajadorRepository trabajadorRepository;
    private Button Agregar, Mostrar, Acerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trabajadorRepository = new TrabajadorRepository();

        Agregar = findViewById(R.id.btnAgregar);
        Agregar.setOnClickListener(this);
        Mostrar = findViewById(R.id.btnMostrar);
        Mostrar.setOnClickListener(this);
        Acerca = findViewById(R.id.btnAcercaDe);
        Acerca.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregar:{
                Intent i1 = new Intent(this, SeleccionarTrabajadorActivity.class);
                startActivity(i1);
                break;
            }
            case R.id.btnMostrar:{
                Intent i2 = new Intent(this, MostrarListaActivity.class);
                startActivity(i2);
                break;
            }
            case R.id.btnAcercaDe:{
                Intent i3 = new Intent(this, DatosActivity.class);
                startActivity(i3);
                break;
            }
        }
    }
}