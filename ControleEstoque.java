
package sistemacontrole;

// Importa a classe ArrayList para armazenar a lista de movimentações
import java.util.ArrayList;

public class ControleEstoque {
    // Lista que armazena todas as movimentações feitas
    private static ArrayList<MovimentacaoEstoque> historico = new ArrayList<>();

    // Variável que representa o saldo atual do estoque
    private static int saldo = 0;

    // Método para registrar uma nova movimentação no estoque
    public static void registrarMovimentacao(MovimentacaoEstoque mov) {
        // Verifica se a movimentação implementa a interface Processavel
        if (mov instanceof Processavel) {
            Processavel proc = (Processavel) mov;

            // Tenta processar a movimentação (validação ou lógica interna)
            if (proc.processarMovimentacao()) {
                // Se for uma entrada, adiciona a quantidade ao saldo
                if (mov.getTipo().equals("Entrada")) {
                    saldo += mov.getQuantidade();
                } else {
                    // Se for uma saída, subtrai a quantidade do saldo
                    saldo -= mov.getQuantidade();
                }

                // Adiciona a movimentação ao histórico
                historico.add(mov);
                System.out.println("Movimentação registrada com sucesso!");
            } else {
                // Caso o processamento não seja válido
                System.out.println("Movimentação inválida!");
            }
        }
    }

    // Método para exibir todas as movimentações feitas até agora
    public static void getHistorico() {
        System.out.println("Histórico de movimentações:");
        for (MovimentacaoEstoque mov : historico) {
            // Mostra o tipo, quantidade e data de cada movimentação
            System.out.println(mov.getTipo() + " de " + mov.getQuantidade() + " unidades em " + mov.getData());
        }
    }

    // Método para exibir estatísticas gerais do estoque
    public static void getEstatisticas() {
        System.out.println("[ESTATÍSTICAS]");
        System.out.println("Total de Movimentações: " + historico.size());

        // Variáveis para armazenar maior entrada, maior saída e total de movimentações
        int maiorEntrada = 0;
        int maiorSaida = 0;
        int totalMovimentacoes = 0;

        // Percorre o histórico e atualiza as estatísticas
        for (MovimentacaoEstoque mov : historico) {
            int quantidade = mov.getQuantidade();
            totalMovimentacoes += quantidade;

            // Verifica se é entrada ou saída e atualiza os maiores valores
            if (mov.getTipo().equalsIgnoreCase("Entrada")) {
                if (quantidade > maiorEntrada) {
                    maiorEntrada = quantidade;
                }
            } else if (mov.getTipo().equalsIgnoreCase("Saida")) {
                if (quantidade > maiorSaida) {
                    maiorSaida = quantidade;
                }
            }
        }

        // Exibe os resultados calculados
        System.out.println("Maior Entrada: " + maiorEntrada);
        System.out.println("Maior Saída: " + maiorSaida);

        // Calcula e exibe a média de movimentações (se houver dados)
        if (!historico.isEmpty()) {
            float media = (float) totalMovimentacoes / historico.size();
            System.out.println("Média de Movimentações: " + media);
        } else {
            System.out.println("Média de Movimentações: 0.0 (sem movimentações)");
        }

        // Exibe o saldo atual do estoque
        System.out.println("Saldo atual em estoque: " + saldo + " unidades");
    }

 }
