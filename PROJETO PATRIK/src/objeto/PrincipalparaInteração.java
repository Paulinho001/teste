package objeto;

import java.util.Scanner;

public class PrincipalparaInteração {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);

 
        estacionamento.cadastrarVaga(1, "pequeno");
        estacionamento.cadastrarVaga(2, "médio");
        estacionamento.cadastrarVaga(3, "grande");

        while (true) {
            System.out.println("\n1. Registrar Entrada");
            System.out.println("2. Registrar Saída");
            System.out.println("3. Relatório de Vagas Ocupadas");
            System.out.println("4. Histórico de Veículos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("Placa: ");
                String placa = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Tamanho (pequeno/médio/grande): ");
                String tamanho = scanner.nextLine();
                Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                estacionamento.registrarEntrada(veiculo);
            } else if (opcao == 2) {
                System.out.print("Placa: ");
                String placa = scanner.nextLine();
                Veiculo veiculo = new Veiculo(placa, "", ""); 
                estacionamento.registrarSaida(veiculo);
            } else if (opcao == 3) {
                estacionamento.relatorioVagasOcupadas();
            } else if (opcao == 4) {
                estacionamento.historicoVeiculos();
            } else if (opcao == 5) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}