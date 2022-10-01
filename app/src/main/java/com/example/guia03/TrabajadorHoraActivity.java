package com.example.guia03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.guia03.MainActivity.trabajadorRepository;

import com.example.guia03.Model.TrabajadorHoraModel;
import com.example.guia03.Model.TrabajadorModel;

public class TrabajadorHoraActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText codigo, nombre, apellido, numHoras, valorHora;
    private Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_hora);

        codigo = findViewById(R.id.edtID);
        nombre = findViewById(R.id.edtNombre);
        apellido = findViewById(R.id.edtApellido);
        numHoras = findViewById(R.id.edtHora);
        valorHora = findViewById(R.id.edtValor);
        agregar = findViewById(R.id.btnAgregarTH);
        agregar.setOnClickListener(this);
    }
    private void agregar(String codigo, String nombre, String apellido, int nh, float vh){
        TrabajadorModel tm = new TrabajadorHoraModel(codigo, nombre, apellido, nh, vh);

        trabajadorRepository.add(tm);

        new AlertDialog.Builder(this)
                .setTitle("¡Confirmación!")
                .setMessage("Registro Exitoso : )")
                .setPositiveButton("Aceptar", (dialog, which) -> finish()).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregarTH:{
                if(validar()){
                    agregar(codigo.getText().toString(), nombre.getText().toString(),
                            apellido.getText().toString(), Integer.parseInt(numHoras.getText().toString()),
                            Float.parseFloat(valorHora.getText().toString()));
                }
                break;
            }
        }
    }
    private Boolean validar(){
        String cod = codigo.getText().toString();
        String n = nombre.getText().toString();
        String a = apellido.getText().toString();
        String nh = numHoras.getText().toString();
        String vh = valorHora.getText().toString();
        Boolean r = true;

        if(cod.isEmpty()){
            r = false;
            codigo.setError("Este es campo es obligatorio");
        }
        if(n.isEmpty()){
            r = false;
            nombre.setError("Este es campo es obligatorio");
        }
        if(a.isEmpty()){
            r = false;
            apellido.setError("Este es campo es obligatorio");
        }
        if(nh.isEmpty()){
            r = false;
            numHoras.setError("Ingrese el número de horas");
        }
        if(vh.isEmpty()){
            r = false;
            valorHora.setError("Ingrese el valor por hora");
        }
        return r;
    }
}