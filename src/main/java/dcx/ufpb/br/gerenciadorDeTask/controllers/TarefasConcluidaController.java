package dcx.ufpb.br.gerenciadorDeTask.controllers;

import dcx.ufpb.br.gerenciadorDeTask.SistemaTarefas;
import dcx.ufpb.br.gerenciadorDeTask.TarefaInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarefasConcluidaController implements ActionListener {
    private SistemaTarefas tarefa;
    private JFrame janelaPrincipal;

    public TarefasConcluidaController(SistemaTarefas tarefa, JFrame janelaPrincipal){
        this.tarefa = tarefa;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dataRemover = JOptionPane.showInputDialog(janelaPrincipal,"Qual a data da tarefa a ser removida: ");
        try {
            tarefa.tarefaConcluida(dataRemover);
            JOptionPane.showMessageDialog(janelaPrincipal, "Tarefa removida e marcada como concluída!");
        } catch (TarefaInexistenteException ex) {
            System.out.println("Tarefa inexistente. Tente novamente!");
        }
    }
}
