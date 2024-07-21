package cuentabancaria;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CuentaBancaria {    
    private int contador = 1000;
    protected double saldo;
    private String numeroCuenta;
    protected String fechaApertura;
    protected String titular;
    final Date thisDate = new Date();
    final SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YY - HH:mm:ss");

    public CuentaBancaria(String titular, double saldo) {
        this.numeroCuenta = generarCuenta("5050");
        this.titular = titular;
        this.saldo = saldo;
        this.fechaApertura = String.valueOf(dateForm.format(thisDate));             
    }
    
    //Static method, para generar numeros de cuenta unicos
    private String generarCuenta(String num){
        String cuenta = num + "0000" + String.valueOf(++contador) ;        
        return cuenta;
    };
    
    //Métodos comunes para todas las cuentas
    public void depositar(double cantidad){
        this.saldo += cantidad;        
    };
    
    
    public void retirar(double cantidad){
        if(cantidad <= this.saldo){
            this.saldo -= cantidad;
        } else {
            System.out.println("Fondos insuficientes");
        }
    };    
    
    //Getters and Setters

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }    
    

    //Método Abstracto.
    public abstract String tipoCuenta();
    
    public abstract void mostrarDatos();
    
}