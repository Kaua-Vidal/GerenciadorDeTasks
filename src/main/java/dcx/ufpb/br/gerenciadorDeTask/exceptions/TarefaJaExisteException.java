package dcx.ufpb.br.gerenciadorDeTask.exceptions;

public class TarefaJaExisteException extends Exception{
    public TarefaJaExisteException (String msg){
        super(msg);
    }
}
