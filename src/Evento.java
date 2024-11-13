import java.util.Date;

public class Evento extends Calendario {
    private String descricaoEvento;

    public Evento(Date data, String descricaoEvento) {
        super(data);
        this.descricaoEvento = descricaoEvento;
    }

    public void exibirEvento() {
        System.out.println("Evento em " + data + ": " + descricaoEvento);
    }
}
