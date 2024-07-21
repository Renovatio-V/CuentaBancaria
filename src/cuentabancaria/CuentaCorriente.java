
package cuentabancaria;


public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    private static int contador;

    public CuentaCorriente(String titular, double saldo) {
        super(titular, saldo);
        ++contador;
        ajustarSobregiro();
    }
    
    //Info general de la cuenta corriente
    public static void mostrarRangosSobregiro() {
        System.out.println("Rangos de sobregiros y sus porcentajes:");
        System.out.println("0 - 499,999: 0%");
        System.out.println("500,000 - 999,999: 3%");
        System.out.println("1,000,000 - 2,499,999: 5%");
        System.out.println("2,500,000 - 4,999,999: 7%");
        System.out.println("5,000,000 o más: 10%");
    }
    
    //Metodo logico para decidir el Sobre-Giro, segun el Balance
     private void ajustarSobregiro() {
        if (saldo >= 5000000) {
            this.limiteSobregiro = saldo * 0.10;
        } else if (saldo >= 2500000) {
            this.limiteSobregiro = saldo * 0.07;
        } else if (saldo >= 1000000) {
            this.limiteSobregiro = saldo * 0.05;
        } else if (saldo >= 500000) {
            this.limiteSobregiro = saldo * 0.03;
        } else {
            this.limiteSobregiro = 0;
        }
    }
    
    //Getters and setters
    public static int getContador() {
        return contador;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }   
    
    //Override Methods

    @Override
    public String tipoCuenta() {
        return "Cuenta-Corriente";
    }    
    
    @Override
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            ajustarSobregiro();
        } else {
            System.out.println("/Cantidad Incorrecta");
        }
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0 && (saldo + limiteSobregiro) >= cantidad) {
            saldo -= cantidad;
            ajustarSobregiro();
        } else {
            System.out.println("/Fondos Insuficientes");
        }
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println();
        System.out.println("=============================================================================");
        System.out.println("CUENTA CORRIENTE");
        System.out.println("Titular de la cuenta: " + getTitular() + " || Fecha Apertura: " + getFechaApertura());
        System.out.println("Número de Cuenta: " + getNumeroCuenta());
        System.out.println("Saldo Total: " + getSaldo());
        System.out.println("=============================================================================");
        System.out.println();
    }
    
    
    
}
