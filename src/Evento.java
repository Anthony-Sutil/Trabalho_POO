import java.util.Calendar;
import java.util.Date;

public class Evento {
    private String titulo;
    private Date data;
    private String descricao;

    public Evento(String titulo, Date data, String descricao) {
        this.titulo = titulo;
        this.data = data;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método 9
    public boolean isHoje() {
        Calendar hoje = Calendar.getInstance();
        Calendar dataEvento = Calendar.getInstance();
        dataEvento.setTime(this.data);

        return hoje.get(Calendar.YEAR) == dataEvento.get(Calendar.YEAR) &&
                hoje.get(Calendar.MONTH) == dataEvento.get(Calendar.MONTH) &&
                hoje.get(Calendar.DAY_OF_MONTH) == dataEvento.get(Calendar.DAY_OF_MONTH);
    }
}
