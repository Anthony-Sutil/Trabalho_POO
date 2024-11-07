import java.util.Date;

class TarefaPessoal extends Tarefa {
    private String local;

    public TarefaPessoal(String titulo, String descricao, Date dataEntrega, String local, int prioridade) {
        super(titulo, descricao, dataEntrega, prioridade, "Pessoal");
        this.local = local;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa Pessoal: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Local: " + local);
        System.out.println("Data de Entrega: " + dataEntrega);
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Status: " + (isConcluida() ? "Concluída" : "Pendente"));
    }

    public void alterarLocal(String novoLocal) {
        this.local = novoLocal;
    }

    public String getLocal() {
        return local;
    }

    @Override
    public String toString() {
        return "TarefaPessoal: " + titulo + " (Local: " + local + ")";
    }
}