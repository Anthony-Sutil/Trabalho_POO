import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private List<Tarefa> tarefas;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void listarTarefas() {
        System.out.println("Tarefas de " + nome + ":");
        for (Tarefa tarefa : tarefas) {
            tarefa.exibirDetalhes();
        }
    }
}
