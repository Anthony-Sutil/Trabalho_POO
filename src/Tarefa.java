import java.util.Calendar;
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
    protected int prioridade; //vai de 1 a 5
    protected List<String> etiquetas;
    protected String responsavel;

    public Tarefa(String titulo, String descricao, Date dataEntrega, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.dataCriacao = new Date();
        this.dataUltimaModificacao = new Date();
        this.concluida = false;
        this.prioridade = prioridade;
        this.etiquetas = new ArrayList<>();
        this.responsavel = "";
    }

    //1 metodo
    public String gerarResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Resumo da Tarefa:\n");
        resumo.append("Título: ").append(titulo).append("\n");
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

    //metodo abstrato
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

    //2 metodo
    public long diasAteEntrega() {
        long diff = dataEntrega.getTime() - new Date().getTime();
        return diff / (24 * 60 * 60 * 1000);
    }


    //3 Metodo (os dois contam como 1)
    public void aumentarPrioridade() {
        if (prioridade < 5) {
            prioridade++;
            dataUltimaModificacao = new Date();
        } else {
            System.out.println("A prioridade já está no valor máximo (5).");
        }
    }

    public void reduzirPrioridade() {
        if (prioridade > 1) {
            prioridade--;
            dataUltimaModificacao = new Date();
        } else {
            System.out.println("A prioridade já está no valor mínimo (1).");
        }
    }

    //4 Metodo
    public void reagendarEntrega(int diasExtras) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEntrega);
        calendar.add(Calendar.DAY_OF_YEAR, diasExtras);
        dataEntrega = calendar.getTime();
        dataUltimaModificacao = new Date();
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


    public String getResponsavel() {
        return responsavel;
    }
}