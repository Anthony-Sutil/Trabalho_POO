import java.util.Date;


class TarefaTrabalho extends Tarefa {
    private String projeto;

    public TarefaTrabalho(String titulo, String descricao, Date dataEntrega, String projeto) {
        super(titulo, descricao, dataEntrega);
        this.projeto = projeto;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa de Trabalho: " + titulo + " - " + descricao + " para o projeto " + projeto + " até " + dataEntrega);
    }
}