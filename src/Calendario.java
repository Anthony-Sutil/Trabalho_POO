import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


class Calendario {
    private int mes;
    private int ano;
    private List<Evento> eventos;

    public Calendario(int mes, int ano) {
        this.mes = mes;
        this.ano = ano;
        this.eventos = new ArrayList<>();
    }

    // Método 7
    public void adicionarEvento(Evento evento) {
        this.eventos.add(evento);
    }

    // Método 8
    public String exibirEventos() {
        StringBuilder calendarioExibicao = new StringBuilder();
        calendarioExibicao.append("Eventos para o mês ").append(mes).append("/").append(ano).append(":\n");

        // Filtra eventos do mês e ano do calendário
        List<Evento> eventosDoMes = eventos.stream()
                .filter(evento -> evento.getData().getMonth() + 1 == mes &&
                        evento.getData().getYear() + 1900 == ano)
                .collect(Collectors.toList());

        if (eventosDoMes.isEmpty()) {
            calendarioExibicao.append("Nenhum evento para este mês.\n");
        } else {
            for (Evento evento : eventosDoMes) {
                calendarioExibicao.append("- ").append(evento.getTitulo())
                        .append(" em ").append(evento.getData())
                        .append(": ").append(evento.getDescricao()).append("\n");
            }
        }

        return calendarioExibicao.toString();
    }

    // Getters e Setters
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Evento> getEventos() {
        return new ArrayList<>(eventos);
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = new ArrayList<>(eventos);
    }
}