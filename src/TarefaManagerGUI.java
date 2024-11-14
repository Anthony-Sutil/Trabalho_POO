import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TarefaManagerGUI extends JFrame {
    private JTextArea areaTarefas;
    private JTextField campoTitulo;
    private JTextField campoDescricao;
    private JTextField campoNivelImportancia;
    private JTextField campoDataFinalizacao;
    private JComboBox<String> comboBoxResponsavel;

    public TarefaManagerGUI() {
        setTitle("Gerenciador de Tarefas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTarefas = new JTextArea(10, 30);
        areaTarefas.setEditable(false);
        areaTarefas.setLineWrap(true);
        areaTarefas.setWrapStyleWord(true);
        areaTarefas.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        areaTarefas.setBackground(new Color(245, 245, 245));
        JScrollPane scrollPane = new JScrollPane(areaTarefas);

        // Campos de entrada
        campoTitulo = new JTextField(15);
        campoDescricao = new JTextField(15);
        campoNivelImportancia = new JTextField(5);
        campoDataFinalizacao = new JTextField(10);
        comboBoxResponsavel = new JComboBox<>(); // Inicializando o JComboBox

        carregarUsuariosNoComboBox();

        JButton botaoAdicionar = new JButton("Adicionar Tarefa");
        botaoAdicionar.setBackground(new Color(70, 130, 180));
        botaoAdicionar.setForeground(Color.WHITE);
        botaoAdicionar.setFocusPainted(false);
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });

        JPanel painelInput = new JPanel();
        painelInput.setLayout(new GridBagLayout());
        painelInput.setBorder(BorderFactory.createTitledBorder("Nova Tarefa"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelInput.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        painelInput.add(campoTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelInput.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        painelInput.add(campoDescricao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelInput.add(new JLabel("Nível de Importância:"), gbc);
        gbc.gridx = 1;
        painelInput.add(campoNivelImportancia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelInput.add(new JLabel("Data de Finalização (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1;
        painelInput.add(campoDataFinalizacao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painelInput.add(new JLabel("Responsável:"), gbc);
        gbc.gridx = 1;
        painelInput.add(comboBoxResponsavel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        painelInput.add(botaoAdicionar, gbc);

        // Layout principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);
        painelPrincipal.add(painelInput, BorderLayout.SOUTH);
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setBackground(new Color(230, 230, 250));
        painelPrincipal.setBackground(new Color(230, 230, 250));
        painelInput.setBackground(new Color(255, 255, 255));

        add(painelPrincipal);
    }

    private void carregarUsuariosNoComboBox() {
        LeitorDeArquivo leitor = new LeitorDeArquivo();
        try {
            List<Usuario> usuarios = leitor.carregarUsuarios("usuarios.csv");
            for (Usuario usuario : usuarios) {
                comboBoxResponsavel.addItem(usuario.getNome());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar usuários: " + e.getMessage());
        }
    }

    private void adicionarTarefa() {
        String titulo = campoTitulo.getText();
        String descricao = campoDescricao.getText();
        int nivelImportancia;
        String responsavel = (String) comboBoxResponsavel.getSelectedItem();

        try {
            nivelImportancia = Integer.parseInt(campoNivelImportancia.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nível de importância deve ser um número.");
            return;
        }

        Date dataFinalizacao;
        try {
            dataFinalizacao = new SimpleDateFormat("dd/MM/yyyy").parse(campoDataFinalizacao.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/MM/yyyy.");
            return;
        }

        Tarefa tarefa = new TarefaPessoal(titulo, descricao, nivelImportancia, dataFinalizacao);
        tarefa.exibirDetalhes();

        areaTarefas.append("Título: " + titulo + "\n" +
                "Descrição: " + descricao + "\n" +
                "Nível de Importância: " + nivelImportancia + "\n" +
                "Data de Finalização: " + new SimpleDateFormat("dd/MM/yyyy").format(dataFinalizacao) + "\n" +
                "Responsável: " + responsavel + "\n" +
                "-----------------------------\n");

        campoTitulo.setText("");
        campoDescricao.setText("");
        campoNivelImportancia.setText("");
        campoDataFinalizacao.setText("");
        comboBoxResponsavel.setSelectedIndex(-1); // Limpar seleção do comboBox
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TarefaManagerGUI().setVisible(true);
            }
        });
    }
}
