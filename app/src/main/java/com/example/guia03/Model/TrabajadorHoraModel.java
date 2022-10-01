package com.example.guia03.Model;

public class TrabajadorHoraModel extends TrabajadorModel{
    private int numHoras;
    private float valorHora;

    public TrabajadorHoraModel(){
        this.setNumHoras(0);
        this.setValorHora(0);
    }

    public TrabajadorHoraModel(String codigo, String nombre, String apellido, int nh, float vh) {
        super(codigo, nombre, apellido);
        this.setNumHoras(nh);
        this.setValorHora(vh);
        super.sueldoMensual = this.getNumHoras() * this.getValorHora();
        super.descuentoISR = super.sueldoMensual * 0.1f;
        super.totalDescuento = super.descuentoISR;
        float s = super.sueldoMensual - super.totalDescuento;
        super.totalPagar =  Math.round(s*100.0f)/100.0f;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public int getTipoTrabajador() {
        return 1;
    }

    @Override
    public String toString() {
        return super.getCodigo() + " " + super.getNombre() + " " + super.getApellido() + "\t " +
                "TH" + "\t $" + super.getTotalPagar();
    }
}