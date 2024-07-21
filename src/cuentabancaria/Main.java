
package cuentabancaria;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>(); 
        
        int userInput = 0;
        System.out.println("---BIENVENIDOS/a a la plataforma de acceso, <<BANCO NEXO>>");
        
        do {            
            Menu();
            userInput = Integer.parseInt(scan.nextLine());           
            
            
            switch (userInput) {
            case 1: //Admin 
                  
                do{
                    subMenuAdmin();
                    userInput = Integer.parseInt(scan.nextLine());
                    switch (userInput) {
                    case 1: //Cuentas totales
                        System.out.println("=============================================================================");
                        System.out.println("Cuentas Totales Registradas: " + cuentas.size() + " \nCuentas Ahorro Creadas: " + CuentaAhorro.getContador());
                        System.out.println("Cuentas Corrientes Creadas: " + CuentaCorriente.getContador());
                        System.out.println("\nInfo Cuenta-Ahorro!");
                        CuentaAhorro.mostrarRangosInteres();
                        System.out.println("\nInfo Cuenta-Corriente!");
                        CuentaCorriente.mostrarRangosSobregiro();
                        System.out.println("=============================================================================");
                        System.out.println();
                        break;
                    case 2: //Ver todas las Cuentas
                        if(cuentas.isEmpty()){
                            System.out.println("No hay cuentas disponibles!");
                            break;
                        }
                        System.out.println("\n---Inicio---");
                        for (CuentaBancaria cuenta : cuentas){
                            cuenta.mostrarDatos();
                        }
                        System.out.println("---Fin---\n");
                        break;
                    case 3: //Crear Cuentas
                        System.out.println("\n¿Que tipo de Cuenta desea crear?");
                        System.out.println("1. Ahorros || 2. Corriente");
                        userInput = Integer.parseInt(scan.nextLine());
                        switch (userInput) {
                            case 1: //Ahorros
                                System.out.print("\nNombre del Titular: ");
                                String nombre = scan.nextLine();
                                System.out.print("Deposito Inicial: ");
                                double deposito = Double.parseDouble(scan.nextLine());                                
                                cuentas.add(new CuentaAhorro(nombre, deposito));
                                //Confirmar la Cuenta Agregada!
                                System.out.println("\nCuenta Añadida (+)");
                                cuentas.get(cuentas.size()-1).mostrarDatos();
                                
                                break;
                            case 2: //Corriente
                                System.out.print("Nombre del Titular: ");
                                String nombreC = scan.nextLine();
                                System.out.print("Deposito Inicial: ");
                                double depositoC = Double.parseDouble(scan.nextLine());
                                cuentas.add(new CuentaCorriente(nombreC, depositoC));
                                //Confirmar la Cuenta Agregada!
                                System.out.println("\nCuenta Añadida (+)");
                                cuentas.get(cuentas.size()-1).mostrarDatos();                                
                                
                                break;                           
                            default:
                                System.out.println("Opcion Invalida");
                        }
                        
                        break;
                    case 4: //Modificar Cuenta
                        if(!cuentas.isEmpty()){
                            System.out.print("\nNúmero de Cuenta del Cliente a modificar:");
                            String cuenta = scan.nextLine();
                            int index = -1;
                            for (CuentaBancaria account : cuentas) {
                                if(account.getNumeroCuenta().equals(cuenta)){
                                    index = cuentas.indexOf(account);
                                }
                            }

                            if(index != -1){
                                cuentas.get(index).mostrarDatos();

                                do {
                                    menuModificarCuenta();
                                    userInput = Integer.parseInt(scan.nextLine());

                                    switch (userInput) {
                                    case 1://Modificar TITULAR
                                        System.out.println("Nombre Titular: ");
                                        System.out.print(">>");
                                        String nuevoNombre = scan.nextLine();
                                        cuentas.get(index).setTitular(nuevoNombre);

                                        

                                        break;
                                    case 2://Modificar SALDO
                                        System.out.println("Nuevo Saldo Cuenta: ");
                                        System.out.print(">>");
                                        double nuevoSaldo = Double.parseDouble(scan.nextLine());
                                        cuentas.get(index).setSaldo(nuevoSaldo);
                                        System.out.println("\n/RESULTADO: ");
                                        cuentas.get(index).mostrarDatos();

                                        break;
                                    case 3://Menu ANTERIOR
                                        if(index != -1){
                                            System.out.println("Cambios---");
                                            cuentas.get(index).mostrarDatos();

                                        } else {
                                            System.out.println(">No Modificaciones hechas!");
                                        }
                                        System.out.println("\nSaliendo...");
                                        userInput = 3;
                                        break;
                                    default:
                                        System.out.println("Opcion Invalida");
                                        break;
                                }
                                }while(userInput != 3);



                            } else {
                                System.out.println("\nNúmero de Cuenta Invalido");
                            }
                        } else {
                            System.out.println("No hay Cuentas Regitradas!");
                        }
                        
                        
                        break;
                    case 5: //Eliminar Cuenta
                        if(cuentas.isEmpty()){
                            System.out.println("No hay cuentas registradas!");
                            break;
                        };
                        System.out.print("\nNúmero de Cuenta a modificar: ");
                        String cuentaRemover = scan.nextLine();
                        int indexDel = -1;
                        
                        for (CuentaBancaria account : cuentas) {
                            if(account.getNumeroCuenta().equals(cuentaRemover)){
                                indexDel = cuentas.indexOf(account);
                            }                            
                        }
                        
                        if(indexDel != -1){
                            System.out.println("\n/Elimando Cuenta...");
                            cuentas.get(indexDel).mostrarDatos();
                            cuentas.remove(indexDel);
                            System.out.println("\nCuenta Eliminada (-)");
                        } else {
                            System.out.println("Número de Cuenta Invalido!");
                        }
                        
                        
                        break;
                    case 6: //Menu Anterior
                        System.out.println("Saliendo...");
                        break;
                        
                    default:
                        System.out.println("Opcion Invalida");;
                    }
                }while(userInput != 6);
  
                break;
            case 2: //Usuario
                System.out.print("\nNúmero de Cuenta del Cliente:  ");
                String userAccount = scan.nextLine();
                int indexUser = -1;
                
                for (CuentaBancaria cuenta : cuentas) {
                    if(cuenta.getNumeroCuenta().equals(userAccount)){
                        indexUser = cuentas.indexOf(cuenta);
                        
                    }
                }
                
                if(indexUser != -1) {
                    String message = "\n*****Bienvenido -" + cuentas.get(indexUser).getTitular() + "- a tu " + cuentas.get(indexUser).tipoCuenta() + "*****";
                    System.out.println(message.toUpperCase());
                    do{
                        
                        subMenuUsuario();
                        userInput = Integer.parseInt(scan.nextLine());  
                        switch (userInput) {
                            case 1: //Consultar Saldo
                                System.out.println("\nConsultando Saldo...");
                                double currentSaldo = cuentas.get(indexUser).getSaldo();                              
                                System.out.println("\nEl saldo actual de la cuenta es: $" + currentSaldo );                              
                                
                                
                                break;
                            case 2: //Depositar
                                System.out.println("\nDepositando...");
                                System.out.print("Saldo Actual: $" + cuentas.get(indexUser).getSaldo() + "\nEntre la cantidad a depositar: ");
                                double deposito = Double.parseDouble(scan.nextLine());
                                cuentas.get(indexUser).depositar(deposito);
                                System.out.print("Nuevo Saldo de la Cuenta: " + cuentas.get(indexUser).getSaldo());    
                                System.out.println();

                                break;
                            case 3: //Retirar
                                System.out.println("\nRetirando...");
                                System.out.println("Saldo Actual: $" + cuentas.get(indexUser).getSaldo());
                                System.out.print("\nCantidad a retirar: ");
                                double retiro = Double.parseDouble(scan.nextLine());
                                cuentas.get(indexUser).retirar(retiro);
                                System.out.print("Nuevo Saldo de la Cuenta: " + cuentas.get(indexUser).getSaldo());  
                                System.out.println();

                                break;
                            case 4: //Menu Anterior

                                break;
                            default:
                                System.out.println("Opcion Invalida");
                        }

                    }while(userInput != 4);
                } else {
                    System.out.println("/Número de Cuenta Incorrecto");
                }
                
                
                break;
            case 3: //Salir
                System.exit(0);
                break;
            default: //Repeat
                System.out.println("\nOpcion Invalida");
            }
        } while(userInput != 3);
        
        
    }    

    private static void Menu(){
        
        System.out.println("\n*--------------------------------Menu Principal-----------------------------*");
        System.out.println("1. Administrador Bancario");
        System.out.println("2. Usuario Bancario");
        System.out.println("3. Salir");
        System.out.println();
        System.out.print(">>");
    };

    private static void subMenuAdmin(){
        
        System.out.println("\n*------------------------Menu Administrador Bancario------------------------*");
        System.out.println("1. Meta-Información Banco Nexo");
        System.out.println("2. Ver todas las Cuentas Bancarias");
        System.out.println("3. Crear Nueva Cuenta");
        System.out.println("4. Modificar Cuenta");
        System.out.println("5. Eliminar Cuenta");
        System.out.println("6. Menu Anterior");
        System.out.println();
        System.out.print(">>");
    };

    private static void subMenuUsuario(){
        System.out.println("\n*----------------------------Menu Usuario Bancario-------------------------*");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Menu Anterior");
        System.out.println();
        System.out.print(">>");
    };
    
    private static void menuModificarCuenta(){
        System.out.println("\n*-------------------------Sub_Menu Modificar Cuenta-------------------------*");
        System.out.println("1. Modificar Titular");  
        System.out.println("2. Modificar Saldo");  
        System.out.println("3. Menu Anterior");
        System.out.println();
        System.out.print(">>");
    };
    
    
    
} // End main class

