package modelos;
import java.util.ArrayList;

public class Cuenta extends Transaccion{
    private int id;
    private String nombreTitular;
    private Double balance;
    private String reporte;
    public static final String  Retiro = "Retiro";
    public static final String  Deposito = "Deposito";


    public Cuenta(int id, String nombreTitular, Double balance) {
        this.id = id;
        this.nombreTitular = nombreTitular;
        this.balance = balance;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public String generarTransaccion(String tipo, Double monto){
        if(tipo == Retiro){
            System.out.println("Generando transaccion");
            setBalance(accionRetiro(balance, monto));
        }else if(tipo == Deposito){
            setBalance(accionDeposito(balance, monto));
        }
        

        return getFactura();
    }
}