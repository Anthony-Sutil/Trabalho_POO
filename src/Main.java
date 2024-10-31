import java.util.Date;
import java.util.List;

public class SistemaOrganizacao {
    public static void main(String[] args) {
        try {
            List<Usuario> usuarios = LeitorDeArquivo.carregarUsuarios("usuarios.txt");


            Date dataEntrega = new Date();
            Tarefa tarefa1 = new TarefaPessoal("Academia", "Treino de musculação", dataEntrega, "Gym");
            Tarefa tarefa2 = new TarefaTrabalho("Projeto X", "Reunião de planejamento", dataEntrega, "Projeto X");


            if (!usuarios.isEmpty()) {
                usuarios.get(0).adicionarTarefa(tarefa1);
                usuarios.get(0).adicionarTarefa(tarefa2);
                usuarios.get(0).listarTarefas();
            }
        } catch (TarefaException e) {
            System.out.println(e.getMessage());
        }
    }
}