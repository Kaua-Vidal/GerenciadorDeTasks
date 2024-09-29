package dcx.ufpb.br.gerenciadorDeTask;

import dcx.ufpb.br.gerenciadorDeTask.exceptions.TarefaInexistenteException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.TarefaJaExisteException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioJaCadastradoException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeTarefas implements SistemaTarefas{

    private Map<String, Tarefa> tarefas = new HashMap<>();
    private Map<String, Usuario> usuarios = new HashMap<>();

    @Override
    public void cadastraTarefa(String descricao, String dataVencimento) throws TarefaJaExisteException {
        Tarefa t1 = new Tarefa(descricao, dataVencimento, false);
        tarefas.put(dataVencimento, t1);
        if (tarefas.containsKey(descricao)){
            throw new TarefaJaExisteException("Essa tarefa já existe");
        }
    }

    @Override
    public void removeTarefas(String descricao) throws TarefaInexistenteException {
        for (Tarefa t : tarefas.values()){
            if (descricao.equals(t.getDescricao())){
                tarefas.values().remove(t);
                return;
            }
        }
        throw new TarefaInexistenteException("Tarefa inexistente");
    }

    @Override
    public void tarefaConcluida(String descricao) throws TarefaInexistenteException{
        for (Tarefa t:tarefas.values()){
            if (descricao.equals(t.getDescricao())){
                tarefas.values().remove(t);
                t.setConcluida(true);
                return;
            }
        }
        throw new TarefaInexistenteException("Tarefa inexistente");
    }

    //OPERAÇÕES DO USUARIO:

    @Override
    public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastradoException {
        if (!usuarios.containsKey(usuario.getNome())) {
            usuarios.put(usuario.getNome(), usuario);
        }
        throw new UsuarioJaCadastradoException("Usuario já cadastrado.");
    }

    @Override
    public Usuario buscarUsuario(String nomeUsuario) throws UsuarioNaoEncontradoException {
        if (usuarios.containsKey(nomeUsuario)){
            return usuarios.get(nomeUsuario);
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado.");
        }
    }

    @Override
    public boolean removerUsuario(String nomeUsuario) throws UsuarioNaoEncontradoException {
        if (usuarios.containsKey(nomeUsuario)){
            usuarios.remove(nomeUsuario);
            return true;
        }
        throw new UsuarioNaoEncontradoException("Usuario não encontrado");
    }
}
