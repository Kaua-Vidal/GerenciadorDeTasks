package dcx.ufpb.br.gerenciadorDeTask;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeTarefas implements SistemaTarefas{

    private Map<String, Tarefa> tarefas = new HashMap<>();

    public void cadastraTarefa(String descricao, String dataVencimento){
        Tarefa t1 = new Tarefa(descricao, dataVencimento, false);
        tarefas.put(dataVencimento, t1);
    }

    public void removeTarefas(String dataVencimento) throws TarefaInexistenteException{
        for (Tarefa t : tarefas.values()){
            if (dataVencimento.equals(t.getDataVencimento())){
                tarefas.values().remove(t);
                return;
            }
        }
        throw new TarefaInexistenteException("Tarefa inexistente");
    }

    public void tarefaConcluida(String dataVencimento) throws TarefaInexistenteException{
        for (Tarefa t:tarefas.values()){
            if (dataVencimento.equals(t.getDataVencimento())){
                tarefas.values().remove(t);
                t.setConcluida(true);
                return;
            }
        }
        throw new TarefaInexistenteException("Tarefa inexistente");
    }
}
