package dcx.ufpb.br.gerenciadorDeTask.GUI;

import dcx.ufpb.br.gerenciadorDeTask.GerenciadorDeTarefas;
import dcx.ufpb.br.gerenciadorDeTask.SistemaTarefas;
import dcx.ufpb.br.gerenciadorDeTask.controllers.TarefasCadastraController;
import dcx.ufpb.br.gerenciadorDeTask.controllers.TarefasConcluidaController;
import dcx.ufpb.br.gerenciadorDeTask.controllers.TarefasRemoveController;

import javax.swing.*;
import java.awt.*;

public class TarefasGUI extends JFrame {
    SistemaTarefas tarefa = new GerenciadorDeTarefas();
    JMenuBar barraDeMenu = new JMenuBar();

    public TarefasGUI() {
        setTitle("Gerenciador de tarefas");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre a janela em tela cheia

        // Fundo da janela
        JPanel fundoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fundo = new ImageIcon("./Imagens/TaskFundo.jpg");
                g.drawImage(fundo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        fundoPanel.setLayout(new BorderLayout());

        // Criar um painel para o título e o ícone
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tituloPanel.setOpaque(false); // Permite que o fundo da imagem apareça

        // Configurando o ícone
        ImageIcon icone = new ImageIcon("./Imagens/iconTask.png");
        Image iconeRedimensionada = icone.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Tamanho desejado
        icone = new ImageIcon(iconeRedimensionada);
        JLabel iconeLabel = new JLabel(icone);

        // Configurando o título
        JLabel linha1 = new JLabel("Minhas tarefas", JLabel.CENTER);
        linha1.setForeground(Color.decode("#E53935")); // Vermelho suave
        linha1.setFont(new Font("Roboto", Font.BOLD, 48)); // Fonte moderna
        linha1.setOpaque(true);
        linha1.setBackground(new Color(0, 0, 0, 200)); // Fundo branco semi-transparente
        linha1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens no título

        // Adiciona ícone e título ao painel
        tituloPanel.add(iconeLabel);
        tituloPanel.add(linha1);

        // Adiciona o painel de título ao fundo
        fundoPanel.add(tituloPanel, BorderLayout.NORTH);

        // Configurando os menus
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarTarefa = new JMenuItem("Cadastrar tarefa");
        menuCadastrar.add(menuCadastrarTarefa);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverTarefa = new JMenuItem("Remover tarefa");
        menuRemover.add(menuRemoverTarefa);

        JMenu menuConcluida = new JMenu("Concluida");
        JMenuItem menuConcluidaTarefa = new JMenuItem("Marcar tarefa como concluída");
        menuConcluida.add(menuConcluidaTarefa);

        // Adicionando ações aos itens dos menus
        menuRemoverTarefa.addActionListener(new TarefasRemoveController(tarefa, this));
        menuCadastrarTarefa.addActionListener(new TarefasCadastraController(tarefa, this));
        menuConcluidaTarefa.addActionListener(new TarefasConcluidaController(tarefa, this));

        // Configurando a barra de menu
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuConcluida);
        setJMenuBar(barraDeMenu);

        // Adiciona o painel de fundo ao JFrame
        add(fundoPanel);
    }

    public static void main(String[] args) {
            TarefasGUI janela = new TarefasGUI();
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        };
    }
