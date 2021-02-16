package modelos;

import java.time.LocalDate;

public class ReporteObj {
    private String transaccion;
    private String tipo;
    private Double monto;
    private String banco = "BANCO SIN NOMBRE";
    private LocalDate fecha;

    public ReporteObj(String transaccion, String tipo, Double monto, String banco, LocalDate fecha) {
	}
}