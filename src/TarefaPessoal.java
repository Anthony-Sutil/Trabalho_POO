public class TarefaPessoal extends Tarefa {
    public TarefaPessoal(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa Pessoal: " + titulo + " - " + descricao);
    }
}
