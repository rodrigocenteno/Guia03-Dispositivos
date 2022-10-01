package com.example.guia03.Repository;

import com.example.guia03.Model.TrabajadorModel;

import java.util.ArrayList;
import java.util.List;

public class TrabajadorRepository {

    public static List<TrabajadorModel> lstTrabajador;

    public TrabajadorRepository(){
        this.lstTrabajador = new ArrayList<>();
    }

    public void add(TrabajadorModel trabajadorModel){
        this.lstTrabajador.add(trabajadorModel);
    }

    public List<TrabajadorModel> getAll(){
        return this.lstTrabajador;
    }
}
