
package sistemacontrole;

// A classe Saida representa uma movimentação de saída de produtos do estoque.
// Ela herda de MovimentacaoEstoque e implementa a interface Processavel.
public class Saida extends MovimentacaoEstoque implements Processavel {

    // Construtor da classe Saida
    // Recebe a quantidade e a data da saída, e define o tipo como "Saída"
    public Saida(int quantidade, String data) {
        super(quantidade, data, "Saída");
    }

    // Valida se a quantidade está dentro dos limites permitidos
    // Deve ser maior que 0 e no máximo 999
    @Override
    public boolean validarQuantidade() {
        return quantidade > 0 && quantidade <= 999;
    }

    // Método que processa a movimentação chamando a validação completa
    @Override
    public boolean processarMovimentacao() {
        return validarMovimentacao();
    }

    // Validação principal da movimentação
    // Aqui, apenas verifica se a quantidade é positiva
    @Override
    public boolean validarMovimentacao() {
        return quantidade > 0;
    }
}

