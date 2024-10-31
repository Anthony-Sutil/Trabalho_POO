import java.util.ArrayList;
import java.util.List;

// Classe Usuario
class Usuario {
    private String nome;
    private List<Tarefa> tarefas;

    public Usuario(String nome) {
        this.nome = nome;
        this.tarefas = new ArrayList<>();
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
