package sistemacontrole;

import java.util.Scanner;

public class TesteControle {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Loop principal do menu
        while (true) {
            // Exibe o menu de opções
            System.out.println("\n=== Controle de estoque ===");
            System.out.println("1. Registrar movimentação");
            System.out.println("2. Ver histórico");
            System.out.println("3. Ver estatísticas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção escolhida pelo usuário
            int opcao = scanner.nextInt();

            // Escolhe o que fazer com base na opção
            switch (opcao) {
                case 1:
                    // Registrar uma movimentação
                    System.out.print("Digite a quantidade (+ para entrada / - para saída): ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Digite a data (ex: 27/05/2025): ");
                    String data = scanner.next();

                    // Se for positiva, registra como entrada
                    if (quantidade > 0) {
                        ControleEstoque.registrarMovimentacao(new Entrada(quantidade, data));
                    } else {
                        // Se for negativa, registra como saída (inverte o sinal)
                        ControleEstoque.registrarMovimentacao(new Saida(-quantidade, data));
                    }
                    break;

                case 2:
                    // Exibe o histórico de movimentações
                    ControleEstoque.getHistorico();
                    break;

                case 3:
                    // Exibe as estatísticas do estoque
                    ControleEstoque.getEstatisticas();
                    break;

                case 4:
                    // Encerra o programa
                    System.out.println("Programa Finalizado!");
                    scanner.close(); // Fecha o scanner
                    return;

                default:
                    // Caso o usuário digite uma opção inválida
                    System.out.println("Opção inválida.");
            }
        }
    }
}

