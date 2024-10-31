import java.util.Date;
import java.util.ArrayList;
import java.util.List;

abstract class Tarefa {
    protected String titulo;
    protected String descricao;
    protected Date dataEntrega;
    protected Date dataCriacao;
    protected Date dataUltimaModificacao;
    protected boolean concluida;
    protected int prioridade; // 1 (baixa) a 5 (alta)
    protected List<String> etiquetas;
    protected String categoria;
    protected String responsavel;

    public Tarefa(String titulo, String descricao, Date dataEntrega, int prioridade, String categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.dataCriacao = new Date();
        this.dataUltimaModificacao = new Date();
        this.concluida = false;
        this.prioridade = prioridade;
        this.etiquetas = new ArrayList<>();
        this.categoria = categoria;
        this.responsavel = "";
    }

    public String gerarResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Resumo da Tarefa:\n");
        resumo.append("Título: ").append(titulo).append("\n");
        resumo.append("Categoria: ").append(categoria).append("\n");
        resumo.append("Prioridade: ").append(prioridade).append("\n");
        resumo.append("Status: ").append(concluida ? "Concluída" : "Pendente").append("\n");
        resumo.append("Data de Entrega: ").append(dataEntrega).append("\n");
        resumo.append("Dias até a entrega: ").append(diasAteEntrega()).append("\n");
        resumo.append("Responsável: ").append(responsavel.isEmpty() ? "Não atribuído" : responsavel).append("\n");
        resumo.append("Etiquetas: ").append(String.join(", ", etiquetas)).append("\n");

        if (estaAtrasada()) {
            resumo.append("ATENÇÃO: Esta tarefa está atrasada!\n");
        }

        return resumo.toString();
    }


    public abstract void exibirDetalhes();

    public void marcarComoConcluida() {
        this.concluida = true;
        this.dataUltimaModificacao = new Date();
    }

    public void desmarcarComoConcluida() {
        this.concluida = false;
        this.dataUltimaModificacao = new Date();
    }

    public void adicionarEtiqueta(String etiqueta) {
        this.etiquetas.add(etiqueta);
        this.dataUltimaModificacao = new Date();
    }

    public void removerEtiqueta(String etiqueta) {
        this.etiquetas.remove(etiqueta);
        this.dataUltimaModificacao = new Date();
    }

    public void atualizarPrioridade(int novaPrioridade) {
        if (novaPrioridade >= 1 && novaPrioridade <= 5) {
            this.prioridade = novaPrioridade;
            this.dataUltimaModificacao = new Date();
        } else {
            throw new IllegalArgumentException("Prioridade deve ser entre 1 e 5");
        }
    }

    public void atribuirResponsavel(String responsavel) {
        this.responsavel = responsavel;
        this.dataUltimaModificacao = new Date();
    }

    public void atualizarDataEntrega(Date novaDataEntrega) {
        this.dataEntrega = novaDataEntrega;
        this.dataUltimaModificacao = new Date();
    }

    public boolean estaAtrasada() {
        return !concluida && new Date().after(dataEntrega);
    }

    public long diasAteEntrega() {
        long diff = dataEntrega.getTime() - new Date().getTime();
        return diff / (24 * 60 * 60 * 1000);
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.dataUltimaModificacao = new Date();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        this.dataUltimaModificacao = new Date();
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataUltimaModificacao() {
        return dataUltimaModificacao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public List<String> getEtiquetas() {
        return new ArrayList<>(etiquetas);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        this.dataUltimaModificacao = new Date();
    }

    public String getResponsavel() {
        return responsavel;
    }
}