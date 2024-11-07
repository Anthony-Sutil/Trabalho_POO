import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class TarefaException extends Exception {
    public TarefaException(String mensagem) {
        super(mensagem);
    }

    public TarefaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public TarefaException(Throwable causa) {
        super(causa);
    }

    @Override
    public String toString() {
        return "TarefaException: " + getMessage();
    }

    private void registrarErro(String mensagemErro) {
        String caminhoArquivoLog = "erros.log";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataHoraAtual = dateFormat.format(new Date());

        try (FileWriter fw = new FileWriter(caminhoArquivoLog, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("Data/Hora: " + dataHoraAtual);
            pw.println("Erro: " + mensagemErro);
            pw.println("-----------------------------------");

        } catch (IOException e) {
            System.err.println("Não foi possível registrar o erro no arquivo de log: " + e.getMessage());
        }
    }
}