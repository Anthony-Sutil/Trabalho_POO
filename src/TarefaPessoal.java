import java.util.Date;

public class TarefaPessoal extends Tarefa {
    public TarefaPessoal(String titulo, String descricao, int nivelImportancia, Date dataFinalizacao) {
        super(titulo, descricao, nivelImportancia, dataFinalizacao);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa Pessoal: " + titulo + " - " + descricao +
                ", Importância: " + nivelImportancia +
                ", Data de Finalização: " + dataFinalizacao);
    }
}
