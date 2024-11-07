import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Usuario> usuarios = LeitorDeArquivo.carregarUsuarios("usuarios.csv");
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
                return;
            }

            Usuario usuarioAtual = usuarios.get(0);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Menu de Tarefas ---");
                System.out.println("1. Adicionar Tarefa Pessoal");
                System.out.println("2. Adicionar Tarefa de Trabalho");
                System.out.println("3. Listar Tarefas");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarTarefaPessoal(usuarioAtual, scanner);
                        break;
                    case 2:
                        adicionarTarefaTrabalho(usuarioAtual, scanner);
                        break;
                    case 3:
                        usuarioAtual.listarTarefas();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (TarefaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void adicionarTarefaPessoal(Usuario usuario, Scanner scanner) throws TarefaException {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Local: ");
        String local = scanner.nextLine();
        Date dataEntrega = new Date();
        Tarefa tarefa = new TarefaPessoal(titulo, descricao, dataEntrega, local, 10);
        usuario.adicionarTarefa(tarefa);
        System.out.println("Tarefa pessoal adicionada com sucesso.");
    }

    private static void adicionarTarefaTrabalho(Usuario usuario, Scanner scanner) throws TarefaException {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Projeto: ");
        String projeto = scanner.nextLine();
        Date dataEntrega = new Date();
        Tarefa tarefa = new TarefaTrabalho(titulo, descricao, dataEntrega, projeto, 10);
        usuario.adicionarTarefa(tarefa);
        System.out.println("Tarefa de trabalho adicionada com sucesso.");
    }
}