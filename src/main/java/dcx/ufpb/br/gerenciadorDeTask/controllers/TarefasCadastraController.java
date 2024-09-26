package dcx.ufpb.br.gerenciadorDeTask.controllers;

import dcx.ufpb.br.gerenciadorDeTask.SistemaTarefas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarefasCadastraController implements ActionListener {
    private SistemaTarefas tarefa;
    private JFrame janelaPrincipal;

    public TarefasCadastraController(SistemaTarefas tarefa, JFrame janelaPrincipal){
        this.tarefa = tarefa;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String descricao = JOptionPane.showInputDialog(janelaPrincipal,"Qual será a tarefa: ");
        String dataVencimento = JOptionPane.showInputDialog(janelaPrincipal,"Qual a data de vencimento dessa tarefa: ");
        tarefa.cadastraTarefa(descricao, dataVencimento);
        JOptionPane.showMessageDialog(janelaPrincipal, "Tarefa cadastrada com sucesso");
    }
}
