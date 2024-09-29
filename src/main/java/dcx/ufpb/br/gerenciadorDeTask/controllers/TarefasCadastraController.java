package dcx.ufpb.br.gerenciadorDeTask.controllers;

import dcx.ufpb.br.gerenciadorDeTask.SistemaTarefas;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.CamposVaziosException;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.TarefaJaExisteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarefasCadastraController implements ActionListener {
    private SistemaTarefas tarefa;
    private JFrame janelaPrincipal;

    public TarefasCadastraController(SistemaTarefas tarefa, JFrame janelaPrincipal) {
        this.tarefa = tarefa;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String descricao = JOptionPane.showInputDialog(janelaPrincipal, "Qual será a tarefa: ");
            String dataVencimento = JOptionPane.showInputDialog(janelaPrincipal, "Qual a data de vencimento dessa tarefa: ");

            if (descricao.trim().isEmpty() || dataVencimento.trim().isEmpty()) {
                throw new CamposVaziosException("Não pode haver campos vazios");
            }
            tarefa.cadastraTarefa(descricao, dataVencimento);
            JOptionPane.showMessageDialog(janelaPrincipal, "Tarefa cadastrada com sucesso");
        } catch (TarefaJaExisteException | CamposVaziosException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());

        }
    }
}