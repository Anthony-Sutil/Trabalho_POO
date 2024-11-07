import java.util.Date;

class TarefaTrabalho extends Tarefa {
    private String projeto;

    public TarefaTrabalho(String titulo, String descricao, Date dataEntrega, String projeto, int prioridade) {
        super(titulo, descricao, dataEntrega, prioridade, "Trabalho");
        this.projeto = projeto;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tarefa de Trabalho: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Projeto: " + projeto);
        System.out.println("Data de Entrega: " + dataEntrega);
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Status: " + (isConcluida() ? "Concluída" : "Pendente"));
        System.out.println("Responsável: " + (getResponsavel().isEmpty() ? "Não atribuído" : getResponsavel()));
    }

    public void alterarProjeto(String novoProjeto) {
        this.projeto = novoProjeto;
    }

    public String getProjeto() {
        return projeto;
    }

    public void atribuirResponsavel(String responsavel) {
        super.atribuirResponsavel(responsavel);
        System.out.println("Responsável " + responsavel + " atribuído à tarefa de trabalho: " + titulo);
    }

    @Override
    public String toString() {
        return "TarefaTrabalho: " + titulo + " (Projeto: " + projeto + ")";
    }
}