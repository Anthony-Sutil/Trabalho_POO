import java.util.Date;

public class Calendario {
    protected Date data;

    public Calendario(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void exibirData() {
        System.out.println("Data do Calendário: " + data);
    }
}
