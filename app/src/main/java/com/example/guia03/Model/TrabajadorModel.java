package com.example.guia03.Model;

public abstract class TrabajadorModel extends PersonaModel {
    protected float sueldoMensual;
    protected float descuentoISR;
    protected float totalDescuento;
    protected float totalPagar;

    public TrabajadorModel() {
        this.sueldoMensual = 0;
        this.descuentoISR = 0;
        this.totalDescuento = 0;
        this.totalPagar = 0;
    }

    public TrabajadorModel(String codigo, String nombre, String apellido) {
        super(codigo, nombre, apellido);
        this.sueldoMensual = 0;
        this.descuentoISR = 0;
        this.totalDescuento = 0;
        this.totalPagar = 0;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public float getDescuentoISR() {
        return descuentoISR;
    }

    public void setDescuentoISR(float descuentoISR) {
        this.descuentoISR = descuentoISR;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }
    public abstract int getTipoTrabajador();
}

