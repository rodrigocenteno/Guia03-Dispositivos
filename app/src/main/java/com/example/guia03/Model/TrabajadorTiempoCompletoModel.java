package com.example.guia03.Model;

import com.example.guia03.Utils.Constant;

public class TrabajadorTiempoCompletoModel extends TrabajadorModel{

    private float descuentoISSS;
    private float descuentoAFP;

    public TrabajadorTiempoCompletoModel() {
        this.setDescuentoISSS(0);
        this.setDescuentoAFP(0);
    }

    public TrabajadorTiempoCompletoModel(String codigo, String nombre, String apellido, float sm) {
        super(codigo, nombre, apellido);
        super.sueldoMensual = sm;
        calcular();
    }

    public float getDescuentoISSS() {
        return descuentoISSS;
    }

    public void setDescuentoISSS(float descuentoISSS) {
        this.descuentoISSS = descuentoISSS;
    }

    public float getDescuentoAFP() {
        return descuentoAFP;
    }

    public void setDescuentoAFP(float descuentoAFP) {
        this.descuentoAFP = descuentoAFP;
    }

    private void calcular(){
        //ISSS
        if(super.sueldoMensual > 0 && super.sueldoMensual <= 1000){
            this.descuentoISSS = super.sueldoMensual * 0.03f;
        }else{
            this.descuentoISSS = Constant.cotizacion_Limite_ISSS;
        }
        //AFP
        if(super.sueldoMensual > 0 && super.sueldoMensual <= 7045.06){
            this.descuentoAFP = super.sueldoMensual * 0.0725f;
        }else{
            this.descuentoAFP = Constant.cotizacion_Limite_AFP;
        }
        float ri = super.sueldoMensual - (this.descuentoAFP + this.descuentoISSS);
        //ISR
        if(ri > 0 && ri <= 472.0){
            super.descuentoISR = 0;
        }else if(ri >= 472.01 && ri <= 895.24){
            super.descuentoISR = 17.67f + (super.sueldoMensual - 472) * 0.10f;
        }else if(ri >= 895.25 && ri <= 2038.10){
            super.descuentoISR = 60 + (super.sueldoMensual - 895.24f) * 0.20f;
        }else{
            super.descuentoISR = 288.57f + (super.sueldoMensual - 2038.10f) * 0.30f;
        }

        super.totalDescuento = (this.descuentoAFP + this.descuentoISSS + super.descuentoISR);
        float s = super.sueldoMensual - super.totalDescuento;
        super.totalPagar =  Math.round(s*100.0f)/100.0f;
    }
    @Override
    public int getTipoTrabajador() {
        return 2;
    }
    public String toString() {
        return super.getCodigo() + " " + super.getNombre() + " " + super.getApellido() + "\t " +
                "TTC" + "\t $" + super.getTotalPagar();
    }

}
