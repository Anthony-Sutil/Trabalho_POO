import java.util.Date;

public class TarefaTrabalho extends Tarefa {
    public TarefaTrabalho(String titulo, String descricao, int nivelImportancia, Date dataFinalizacao) {
        super(titulo, descricao, nivelImportancia, dataFinalizacao);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa de Trabalho: " + titulo + " - " + descricao +
                ", Importância: " + nivelImportancia +
                ", Data de Finalização: " + dataFinalizacao);
    }
}
