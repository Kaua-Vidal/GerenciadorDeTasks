package dcx.ufpb.br.gerenciadorDeTask;

public class Tarefa{
    private String descricao;
    private String dataVencimento;
    private boolean concluida;

    public Tarefa (String descricao, String dataVencimento, boolean concluida){
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.concluida = concluida;
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
}
