
package sistemacontrole;

// A classe Entrada representa uma movimentação de entrada no estoque.
// Ela herda de MovimentacaoEstoque e implementa a interface Processavel.
public class Entrada extends MovimentacaoEstoque implements Processavel {

    // Construtor: define a quantidade, data e tipo ("Entrada")
    public Entrada(int quantidade, String data) {
        super(quantidade, data, "Entrada");
    }

    // Verifica se a quantidade da entrada é válida:
    // precisa ser maior que 0 e menor ou igual a 999
    @Override
    public boolean validarQuantidade() {
        return quantidade > 0 && quantidade <= 999;
    }

    // Processa a movimentação chamando o método de validação
    @Override
    public boolean processarMovimentacao() {
        return validarMovimentacao();
    }

    // Valida a movimentação: precisa ter uma quantidade positiva
    @Override
    public boolean validarMovimentacao() {
        return quantidade > 0;
    }
}

