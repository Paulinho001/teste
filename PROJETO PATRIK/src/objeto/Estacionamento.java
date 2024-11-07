package objeto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas = new ArrayList<>();
    private List<Historico> historico = new ArrayList<>();

    public void cadastrarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public void registrarEntrada(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(veiculo.getTamanho())) {
                vaga.ocupar();
                veiculo.setHoraEntrada(LocalDateTime.now());
                System.out.println("Veículo " + veiculo.getPlaca() + " estacionado na vaga " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Nenhuma vaga disponível para o tamanho do veículo.");
    }

    public void registrarSaida(Veiculo veiculo) {
        veiculo.setHoraSaida(LocalDateTime.now());
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(veiculo.getTamanho())) {
                vaga.liberar();
                double valor = calcularValor(veiculo);
                historico.add(new Historico(veiculo.getPlaca(), veiculo.getHoraEntrada(), veiculo.getHoraSaida(), valor));
                System.out.println("Veículo " + veiculo.getPlaca() + " saiu. Valor a pagar: R$ " + valor);
                return;
            }
        }
    }

    private double calcularValor(Veiculo veiculo) {
        long horas = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida()).toHours();
        if (horas <= 1) {
            return 5.0;
        } else if (horas <= 3) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    public void relatorioVagasOcupadas() {
        System.out.println("Vagas ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println(vaga);
            }
        }
    }

    public void historicoVeiculos() {
        System.out.println("Histórico de permanência:");
        for (Historico h : historico) {
            System.out.println(h);
        }
    }
}