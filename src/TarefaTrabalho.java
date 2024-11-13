public class TarefaTrabalho extends Tarefa {
    public TarefaTrabalho(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa de Trabalho: " + titulo + " - " + descricao);
    }
}
