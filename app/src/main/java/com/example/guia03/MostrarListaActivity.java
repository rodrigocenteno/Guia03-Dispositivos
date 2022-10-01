package com.example.guia03;

import static com.example.guia03.Repository.TrabajadorRepository.lstTrabajador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MostrarListaActivity extends AppCompatActivity {

    private ListView lstVistaTrabajador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        lstVistaTrabajador = findViewById(R.id.lsvTrabajadores);
        if(lstTrabajador.isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("¡Aviso!")
                    .setMessage("Lista Vacía")
                    .setPositiveButton("Aceptar", (dialog, which) -> finish()).show();
        }else{
            lstVistaTrabajador.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lstTrabajador));
        }
    }
}