package dcx.ufpb.br.gerenciadorDeTask.controllers;

import dcx.ufpb.br.gerenciadorDeTask.SistemaTarefas;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioNaoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUsuarioController implements ActionListener {
    private SistemaTarefas sistema;
    private JFrame janelaPrincipal;

    public RemoveUsuarioController(SistemaTarefas sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do usuario que deseja remover");
        try {
            sistema.removerUsuario(nome);
            JOptionPane.showMessageDialog(janelaPrincipal, "Usuario removido com sucesso");
        } catch (UsuarioNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        }
    }
}