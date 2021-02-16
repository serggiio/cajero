import java.util.Scanner;

import modelos.Cuenta;

public class App {
    public static Cuenta cuenta = new Cuenta(00001, "Juan Perez", 10.00);
    public static double balance;

    public static void main(String[] args) throws Exception {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        int salir = 4;
        balance = cuenta.getBalance();
        do{
            System.out.println("::::::::::: Bienvenido al Cajero, ahora con que me vas a salir?::::::::::::::::");
            System.out.println("1. Retiro.");
            System.out.println("2. Deposito.");
            System.out.println("3. Reporte.");
            System.out.println("4. Salir.");

            Scanner res = new Scanner(System.in);
                int respuesta = Integer.valueOf(res.nextLine());
            
                switch (respuesta) {
                    case 1:
                        accionRetiro();
                        break;
                    case 2:
                        accionDeposito();
                        break;
                    case 3:
                        accionReporte();
                        break;
                    case 4:
                        System.out.println("NO VUELVAS");
                        salir = 4;
                        break;

                    default:
                        System.out.println("");
                        System.out.println("WAAAA QUE TE PASA OPCION INVALIDA");
                        System.out.println("");
                }
        }while (salir != 4);
    }

    private static void accionRetiro() {
        if(balance > 0.00){
            System.out.println("Balance actual de la cuenta: "+ balance);
            System.out.println("Indique el monto a retirar: ");
            Scanner monto = new Scanner(System.in);
            double respuesta1 = Double.valueOf(monto.nextLine());
            if(respuesta1 > balance){
                System.out.println("----------------------------------------");
                System.out.println("No puedes retirar mas de lo que tienes no seas boludo");
                System.out.println("----------------------------------------");
                accionRetiro();
            }else{
                System.out.println("Dinero a retirar: "+respuesta1);
                String respuestaTransaccion = cuenta.generarTransaccion(Cuenta.Retiro, respuesta1);
                System.out.println(respuestaTransaccion);
                mostrarMenu();
            }
        }else{
            System.out.println("No tienes suficiente dinero no puedes hacer lo que quieras");
            mostrarMenu();
        }
    }

    private static void accionDeposito() {
        if(balance > 0.00){
            System.out.println("Balance actual de la cuenta: "+ balance);
            System.out.println("Indique el monto a abonar: ");
            Scanner monto = new Scanner(System.in);
            double respuesta1 = Double.valueOf(monto.nextLine());
            if(respuesta1 < 0.00){
                System.out.println("----------------------------------------");
                System.out.println("No puedes depositar un monto menor a 0 no seas boludo");
                System.out.println("----------------------------------------");
                accionRetiro();
            }else{
                System.out.println("Dinero a depositar: "+respuesta1);
                String respuestaTransaccion = cuenta.generarTransaccion(Cuenta.Deposito, respuesta1);
                System.out.println(respuestaTransaccion);
                mostrarMenu();
            }
        }else{
            System.out.println("No tienes suficiente dinero no puedes hacer lo que quieras");
            mostrarMenu();
        }
    }

    private static void accionReporte(){
        System.out.println(cuenta.generarReporte(balance));
        System.out.println(":::::::::::FIN REPORTE TRANSACCIONES::::::::::::::::");
        mostrarMenu();
    }
}

