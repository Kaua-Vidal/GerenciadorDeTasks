package dcx.ufpb.br.gerenciadorDeTask.controllers;

import dcx.ufpb.br.gerenciadorDeTask.SistemaTarefas;
import dcx.ufpb.br.gerenciadorDeTask.Usuario;
import dcx.ufpb.br.gerenciadorDeTask.exceptions.UsuarioJaCadastradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastraUsuarioController implements ActionListener {
    private SistemaTarefas sistema;
    private JFrame janelaPrincipal;

    public CadastraUsuarioController(SistemaTarefas sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do usuario");
        Usuario novoUsuario = new Usuario(nome);
        try {
            sistema.cadastrarUsuario(novoUsuario);
            JOptionPane.showMessageDialog(janelaPrincipal, "Novo usuario cadastrado com sucesso");
        } catch (UsuarioJaCadastradoException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        }
    }
}
