package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import modelos.ReporteObj;

public class Transaccion extends Reporte{
    
    private LocalDate fecha = java.time.LocalDate.now();
    private String factura;
    //Reporte report = new Reporte();
    ArrayList<Reporte> listaReporte = new ArrayList();

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFactura() {
        return factura;
    }

    public Double accionRetiro(Double balance, Double monto) {
        setTransaccion("000001");
        setTipo("Retiro");
        setMonto(monto);
        setFecha(fecha);
        listaReporte.add(new Reporte(getTransaccion(), getTipo(), getMonto(), getBanco(), getFecha()));
        setFactura(generarFactura());
        Double result = balance - monto;
        return result;
    }

    public Double accionDeposito(Double balance, Double monto) {
        setTransaccion("000002");
        setTipo("Deposito");
        setMonto(monto);
        setFecha(fecha);
        listaReporte.add(new Reporte(getTransaccion(), getTipo(), getMonto(), getBanco(), getFecha()));
        setFactura(generarFactura());
        Double result = balance + monto;
        return result;
    }

    public String generarReporte(Double balance1) {
        return formatoReporte(listaReporte, balance1);
    }


}