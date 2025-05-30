
package sistemacontrole;

// Classe abstrata que representa uma movimentação no estoque.
// Pode ser usada como base para classes como Entrada e Saida.
public abstract class MovimentacaoEstoque {
    
    // Quantidade de itens movimentados
    protected int quantidade;

    // Data da movimentação (formato de texto, como "29/05/2025")
    protected String data;

    // Tipo da movimentação ("Entrada" ou "Saida")
    protected String tipo;

    // Construtor que define os atributos principais da movimentação
    public MovimentacaoEstoque(int quantidade, String data, String tipo) {
        this.quantidade = quantidade;
        this.data = data;
        this.tipo = tipo;
    }

    // Retorna a quantidade da movimentação
    public int getQuantidade() {
        return quantidade;
    }

    // Retorna a data da movimentação
    public String getData() {
        return data;
    }

    // Retorna o tipo da movimentação
    public String getTipo() {
        return tipo;
    }

    // Método abstrato que deve ser implementado pelas subclasses
    // Serve para validar se a quantidade da movimentação está correta
    public abstract boolean validarQuantidade();
}

