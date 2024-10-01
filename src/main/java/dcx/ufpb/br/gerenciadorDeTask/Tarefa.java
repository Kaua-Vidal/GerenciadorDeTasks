package dcx.ufpb.br.gerenciadorDeTask;

import java.util.ArrayList;
import java.util.List;

public class Tarefa{
    private String descricao;
    private String dataVencimento;
    private boolean concluida;
    private List<Tarefa> tarefas;

    public Tarefa (String descricao, String dataVencimento, boolean concluida){
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.concluida = concluida;
        this.tarefas = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return "Tarefa" + "\n" +
                "Descricao: " + descricao + '\n' +
                "DataVencimento: " + dataVencimento + '\n' +
                "Concluida: " + concluida + "\n";
    }
}
