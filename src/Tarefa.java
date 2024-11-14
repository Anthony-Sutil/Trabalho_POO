import java.util.Date;

public abstract class Tarefa {
    protected String titulo;
    protected String descricao;
    protected int nivelImportancia;
    protected Date dataFinalizacao;

    public Tarefa(String titulo, String descricao, int nivelImportancia, Date dataFinalizacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivelImportancia = nivelImportancia;
        this.dataFinalizacao = dataFinalizacao;
    }

    public abstract void exibirDetalhes();

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNivelImportancia() {
        return nivelImportancia;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }
}
