package dcx.ufpb.br.gerenciadorDeTask;

/**
 * The interface Sistema tarefas.
 */
public interface SistemaTarefas {


    /**
     * Sistema de gerenciar as tarefas
     * Cadastra uma tarefa no map
     * @param descricao
     * @param dataVencimento
     */
    public void cadastraTarefa(String descricao, String dataVencimento);

    /**
     * Remove tarefas.
     * Remove as tarefas do map
     * @param dataVencimento
     * @throws TarefaInexistenteException Caso não existe a tarefa
     */
    public void removeTarefas(String dataVencimento) throws TarefaInexistenteException;

    /**
     * Tarefa concluida.
     * Coloca a tarefa como concluída
     * @param dataVencimento
     * @throws TarefaInexistenteException Caso não existe a tarefa
     */
    public void tarefaConcluida(String dataVencimento) throws TarefaInexistenteException;
}
