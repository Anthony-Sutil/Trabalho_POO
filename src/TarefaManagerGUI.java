import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarefaManagerGUI extends JFrame {
    private JTextArea areaTarefas;
    private JTextField campoTitulo;
    private JTextField campoDescricao;

    public TarefaManagerGUI() {
        setTitle("Gerenciador de Tarefas");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTarefas = new JTextArea();
        areaTarefas.setEditable(false);
        campoTitulo = new JTextField(20);
        campoDescricao = new JTextField(20);

        JButton botaoAdicionar = new JButton("Adicionar Tarefa");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.add(new JScrollPane(areaTarefas), BorderLayout.CENTER);

        JPanel painelInput = new JPanel();
        painelInput.add(new JLabel("Título:"));
        painelInput.add(campoTitulo);
        painelInput.add(new JLabel("Descrição:"));
        painelInput.add(campoDescricao);
        painelInput.add(botaoAdicionar);

        painel.add(painelInput, BorderLayout.SOUTH);
        add(painel);
    }

    private void adicionarTarefa() {
        String titulo = campoTitulo.getText();
        String descricao = campoDescricao.getText();
        Tarefa tarefa = new TarefaPessoal(titulo, descricao);
        tarefa.exibirDetalhes();
        areaTarefas.append("Título: " + titulo + ", Descrição: " + descricao + "\n");
        campoTitulo.setText("");
        campoDescricao.setText("");
    }
}
