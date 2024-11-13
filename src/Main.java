import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Tentativa de carregar usuários a partir de um arquivo CSV (opcional)
        try {
            LeitorDeArquivo leitor = new LeitorDeArquivo();
            leitor.carregarUsuarios("usuarios.csv"); // Modifique para o caminho correto do arquivo
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo de usuários: " + e.getMessage());
        }

        // Exemplo de uso da nova herança
        Evento evento = new Evento(new Date(), "Reunião de Projeto");
        evento.exibirEvento();

        // Inicializando a interface gráfica
        SwingUtilities.invokeLater(() -> {
            TarefaManagerGUI gui = new TarefaManagerGUI();
            gui.setVisible(true);
        });
    }
}
/*
 * Número de Classes:
 * - O projeto contém 10 classes:
 *   1. Calendario
 *   2. Evento
 *   3. LeitorDeArquivo
 *   4. Main
 *   5. Tarefa
 *   6. TarefaPessoal
 *   7. TarefaTrabalho
 *   8. TarefaException
 *   9. TarefaManagerGUI
 *   10. Usuario
 *
 *
 * Métodos por classe:
 *   1. Calendario: 2 métodos (`getData()`, `exibirData()`)
 *   2. Evento: 2 métodos (`exibirEvento()`)
 *   3. LeitorDeArquivo: 1 método (`carregarUsuarios()`)
 *   4. Main: 1 método (`main()`)
 *   5. Tarefa: 1 método abstrato (`exibirDetalhes()`)
 *   6. TarefaPessoal: 1 método (`exibirDetalhes()`)
 *   7. TarefaTrabalho: 1 método (`exibirDetalhes()`)
 *   8. TarefaException: 1 método (`TarefaException()`)
 *   9. TarefaManagerGUI: 2 métodos (`adicionarTarefa()`, `main()`)
 *   10. Usuario: 2 métodos (`adicionarTarefa()`, `listarTarefas()`)
 *
 * Encapsulamento:
 * - O encapsulamento está presente em várias classes, onde os dados são privados e os métodos públicos fornecem acesso a esses dados.
 * - Exemplos de encapsulamento:
 *   1. **Calendario**: A data (`data`) é protegida (protected), e o acesso é feito através do método público `getData()` e `exibirData()`.
 *   2. **Tarefa**: O título e a descrição da tarefa são privados, e os métodos públicos `getTitulo()` e `getDescricao()` fornecem acesso a essas variáveis.
 *   3. **Usuario**: O nome, e-mail e tarefas são privados, com os métodos `adicionarTarefa()` e `listarTarefas()` permitindo interagir com esses dados.
 *   4. **Evento**: A descrição do evento é privada e é acessada através de um método público.
 *
 * Relações de Herança:
 * - O projeto possui 2 relações de herança:
 *   1. **Calendario -> Evento**: A classe `Evento` herda de `Calendario`, o que permite que `Evento` use a data de `Calendario` e adicione a funcionalidade de descrição de evento.
 *   2. **Tarefa -> TarefaPessoal / TarefaTrabalho**: A classe `Tarefa` é uma classe abstrata, e `TarefaPessoal` e `TarefaTrabalho` são suas subclasses que implementam o método abstrato `exibirDetalhes()`.
 */
