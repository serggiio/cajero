package modelos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reporte {
    private String transaccion;
    private String tipo;
    private Double monto;
    private String banco = "BANCO SIN NOMBRE";
    private LocalDate fecha;

    public Reporte(){

    }

	public Reporte(String transaccion, String tipo, Double monto, String banco, LocalDate fecha) {
        this.transaccion = transaccion;
        this.tipo = tipo;
        this.monto = monto;
        this.banco = banco;
        this.fecha = fecha;
    }   

	public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTransaccion() {
        return transaccion;
    }
    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }


    public String getBanco() {
        return banco;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalDate getFecha() {
        return fecha;
    }

    public String generarFactura() {

        //listaReporte.add(null);
        return  
	"\n :::::::::: " + getBanco() + "::::::::::"+
	"\n Numero de transaccion: "  + getTransaccion() + 
	"\n Fecha: " + getFecha() + 
	"\n Tipo: " + getTipo() +
	"\n Monto: " + getMonto()  ;
    }

    public String formatoReporte(ArrayList<Reporte> data, Double amount){
        String reportResult = "";
        reportResult += "\n:::::::::::Reporte Banco "+ getBanco() + "::::::::::::::::";
        for (int i = 0; i < data.size(); i++) {
            int numero = i+1;
            reportResult += "\n" + numero + ". "+ "Numero de transaccion: " + data.get(i).getTransaccion() + " Tipo de transaccion: " + data.get(i).getTipo() + " Monto: " + getMonto() + " bs.";
        }
        reportResult += "\n Dinero disponible " + amount;
        return reportResult;
    }

    public void vaciarObj(){
        setMonto(null);
        setTipo(null);
        setTransaccion(null);
        setFecha(null);
    }

    
}