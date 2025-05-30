
package sistemacontrole;

// Interface que define comportamentos obrigatórios para qualquer movimentação que possa ser processada
public interface Processavel {

    // Método que processa a movimentação (como validação ou execução de lógica de estoque)
    boolean processarMovimentacao();

    // Método que verifica se a movimentação é válida (como regras de negócio)
    boolean validarMovimentacao();
}