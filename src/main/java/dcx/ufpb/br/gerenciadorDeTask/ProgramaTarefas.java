package dcx.ufpb.br.gerenciadorDeTask;

import javax.swing.*;

public class ProgramaTarefas {
    public static void main(String[] args) {
        SistemaTarefas sistema = new GerenciadorDeTarefas();
        String opcao;


        do {
            opcao = JOptionPane.showInputDialog("Digite o número do que deseja fazer:" +
                    "\n\n1. Cadastrar tarefa" +
                    "\n2.Remover tarefa" +
                    "\n3.Marcar tarefa como concluída" +
                    "\n4.Sair");

            switch (opcao) {
                case "1":
                    String descricao = JOptionPane.showInputDialog("Qual será a tarefa: ");
                    String dataVencimento = JOptionPane.showInputDialog("Qual a data de vencimento dessa tarefa: ");
                    sistema.cadastraTarefa(descricao, dataVencimento);
                    JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso");
                    break;
                case "2":
                    String dataRemover = JOptionPane.showInputDialog("Qual a data da tarefa a ser removida: ");
                    try {
                        sistema.removeTarefas(dataRemover);
                        JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
                    } catch (TarefaInexistenteException e) {
                        System.out.println("Tarefa inexistente. Tente novamente!");
                    }
                    break;
                case "3":
                    dataRemover = JOptionPane.showInputDialog("Qual a data da tarefa a ser removida: ");
                    try {
                        sistema.tarefaConcluida(dataRemover);
                        JOptionPane.showMessageDialog(null, "Tarefa removida e marcada como concluída!");
                    } catch (TarefaInexistenteException e) {
                        System.out.println("Tarefa inexistente. Tente novamente!");
                    }
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
            }
        } while (!opcao.equals("4"));
    }
}
