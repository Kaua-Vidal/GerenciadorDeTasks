package dcx.ufpb.br.gerenciadorDeTask;

import dcx.ufpb.br.gerenciadorDeTask.exceptions.TarefaInexistenteException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.TarefaJaExisteException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioJaCadastradoException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioNaoEncontradoException;

/**
 * a interface de Sistema tarefas.
 */
public interface SistemaTarefas {


    /**
     * @param nomeUsuario nome do usuário que será adicionado a tarefa
     * @param tarefa tarafa que será adicionada
     * @throws TarefaJaExisteException caso a tarefa ja exista
     */
    public void cadastraTarefa(String nomeUsuario, Tarefa tarefa) throws TarefaJaExisteException, UsuarioNaoEncontradoException;

    /**
     * @param descricao recebe a descrição da tarefa a ser removida
     * @throws TarefaInexistenteException caso não exista a tarefa a ser removida
     */
    public void removeTarefas(String descricao) throws TarefaInexistenteException;

    /**
     * @param descricao tarefa a ser recebida como parâmetro
     * @throws TarefaInexistenteException caso essa tarefa não exista
     */
    public void tarefaConcluida(String descricao) throws TarefaInexistenteException;


    /**
     * @param usuario recebe um usuario a ser cadastrado
     * @throws UsuarioJaCadastradoException the usuario ja cadastrado exception
     */
    public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastradoException;

    /**
     * @param nomeUsuario o nome do usuário
     * @return retorna um usuario encontrado
     * @throws UsuarioNaoEncontradoException caso o usuario não seja encontrado
     */
    Usuario buscarUsuario(String nomeUsuario) throws UsuarioNaoEncontradoException;

    /**
     *
     * @param nomeUsuario recebe o nome do usuário a ser removido
     * @return retorna se conseguiu remover ou não
     * @throws UsuarioNaoEncontradoException caso o usuário não exista no sistema
     */
    boolean removerUsuario(String nomeUsuario) throws UsuarioNaoEncontradoException;
}
