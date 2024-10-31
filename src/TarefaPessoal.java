import java.util.Date;


class TarefaPessoal extends Tarefa {
    private String local;

    public TarefaPessoal(String titulo, String descricao, Date dataEntrega, String local) {
        super(titulo, descricao, dataEntrega);
        this.local = local;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa Pessoal: " + titulo + " - " + descricao + " em " + local + " até " + dataEntrega);
    }
}