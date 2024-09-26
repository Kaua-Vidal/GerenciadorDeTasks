package dcx.ufpb.br.gerenciadorDeTask;

public class TarefaInexistenteException extends Exception{
    public TarefaInexistenteException(String msg){
        super(msg);
    }
}
