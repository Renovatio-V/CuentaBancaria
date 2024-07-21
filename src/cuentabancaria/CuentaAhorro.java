
package cuentabancaria;



public class CuentaAhorro extends CuentaBancaria {
    private static int contador;
    private double tasaInteres;

    public CuentaAhorro(String titular, double saldo) {
        super(titular, saldo);
        ajustarInteres();
        ++contador;
    }
    
    public static void mostrarRangosInteres() {        
        System.out.println("Rangos de interés y sus porcentajes:");
        System.out.println("0 - 249,999: 0.01%");
        System.out.println("250,000 - 999,999: 0.03%");
        System.out.println("1,000,000 - 4,999,999: 0.05%");
        System.out.println("5,000,000 - 9,999,999: 0.07%");
        System.out.println("10,000,000 o más: 0.13%");
    }
    
    //Getters and setters!

    public static int getContador() {
        return contador;
    }
    
    
    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }   
    
    @Override
    public void depositar(double cantidad){
        if(cantidad > 0){
            double interes = this.saldo * tasaInteres;
            this.saldo += cantidad + interes;
            ajustarInteres();
            
        } else {
            System.out.println("/Cantidad Invalida");
        }
    }
    
    @Override
    public void retirar(double cantidad){
        if(cantidad <= this.saldo){
            this.saldo -= cantidad;
            ajustarInteres();
        } else {
            System.out.println("/Fondos Insuficientes");
        }
    }
    
    //Ajustar el Interes
    private void ajustarInteres(){
         if (saldo >= 10000000) {
            this.tasaInteres = 0.13;
        } else if (saldo >= 5000000) {
            this.tasaInteres = 0.07;
        } else if (saldo >= 1000000) {
            this.tasaInteres = 0.05;
        } else if (saldo >= 250000) {
            this.tasaInteres = 0.03;
        } else {
            this.tasaInteres = 0.01; 
        }
    };

    @Override
    public String tipoCuenta() {
        return "Cuenta-Ahorros";
    }
    
    

    @Override
    public void mostrarDatos() {
        System.out.println();
        System.out.println("=============================================================================");
        System.out.println("CUENTA DE AHORROS");
        System.out.println("Titular de la cuenta: " + getTitular() + " || Fecha Apertura: " + getFechaApertura());
        System.out.println("Numero de Cuenta: " + getNumeroCuenta());
        System.out.println("Saldo Total: " + getSaldo() + " || Interes Actual: " + this.tasaInteres);
        System.out.println("=============================================================================");
        System.out.println();
    }
    
}
