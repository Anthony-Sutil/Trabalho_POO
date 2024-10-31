import java.util.Date;


abstract class Tarefa {
    protected String titulo;
    protected String descricao;
    protected Date dataEntrega;

    public Tarefa(String titulo, String descricao, Date dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
    }

    public abstract void exibirDetalhes();
}