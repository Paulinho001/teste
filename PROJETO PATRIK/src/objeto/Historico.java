package objeto;

import java.time.LocalDateTime;
import java.time.Duration;

public class Historico {
    private String placa;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;

    public Historico(String placa, LocalDateTime horaEntrada, LocalDateTime horaSaida, double valorPago) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        long horas = Duration.between(horaEntrada, horaSaida).toHours();
        return "Placa: " + placa + ", Entrada: " + horaEntrada + ", Saída: " + horaSaida + ", Tempo: " + horas + " horas, Valor Pago: R$ " + valorPago;
    }
}