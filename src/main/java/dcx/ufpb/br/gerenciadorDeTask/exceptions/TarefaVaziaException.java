package dcx.ufpb.br.gerenciadorDeTask.exceptions;

public class TarefaVaziaException extends Exception{
    public TarefaVaziaException (String msg) {
        super("Essa tarefa está vazia");
    }
}
