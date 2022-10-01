package com.example.guia03;

import static com.example.guia03.Repository.TrabajadorRepository.lstTrabajador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guia03.Model.TrabajadorTiempoCompletoModel;

public class TrabajadorTiempoCompletoActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText id, nombre, apellido, salario;
    private Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_tiempo_completo);

        id = findViewById(R.id.edtIDTC);
        nombre = findViewById(R.id.edtNombreTC);
        apellido = findViewById(R.id.edtApellidoTC);
        salario = findViewById(R.id.edtSalario);
        agregar = findViewById(R.id.btnAgregarTC);
        agregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAgregarTC:{
                if(validar()){
                    agregar(id.getText().toString(), nombre.getText().toString(),
                            apellido.getText().toString(), Float.parseFloat(salario.getText().toString()));
                }
                break;
            }
        }
    }
    private void agregar(String idPersona, String nombre, String apellido, float salario){
        TrabajadorTiempoCompletoModel p = new TrabajadorTiempoCompletoModel(idPersona, nombre, apellido, salario);

        lstTrabajador.add(p);

        new AlertDialog.Builder(this)
                .setTitle("¡Confirmación!")
                .setMessage("Registro Exitoso : )")
                .setPositiveButton("Aceptar", (dialog, which) -> finish()).show();
    }
    private Boolean validar(){
        String cod = id.getText().toString();
        String n = nombre.getText().toString();
        String a = apellido.getText().toString();
        String s = salario.getText().toString();
        Boolean r = true;
        if(cod.isEmpty()){
            r = false;
            id.setError("Este es campo es obligatorio");
        }
        if(n.isEmpty()){
            r = false;
            nombre.setError("Este es campo es obligatorio");
        }
        if(a.isEmpty()){
            r = false;
            apellido.setError("Este es campo es obligatorio");
        }
        if(s.isEmpty()){
            r = false;
            salario.setError("Ingrese su salario mensual");
        }
        return r;
    }

}