package dcx.ufpb.br.gerenciadorDeTask;

import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nome;
    private List<Tarefa> tarefasDoUsuario;

    public Usuario(String nome){
        this.nome = nome;
        this.tarefasDoUsuario = new ArrayList<>();
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tarefa> getTarefasDoUsuario() {
        return tarefasDoUsuario;
    }

    public void setTarefasDoUsuario(List<Tarefa> tarefasDoUsuario) {
        this.tarefasDoUsuario = tarefasDoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    public String listarTarefas(){

        StringBuilder sb = new StringBuilder();
        for (Tarefa t : this.tarefasDoUsuario){
            sb.append(t.toString()).append("\n");
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return "Usuario de nome: " + this.nome + "\n" +
                "TarefasDoUsuario: " + this.listarTarefas();
    }
}
