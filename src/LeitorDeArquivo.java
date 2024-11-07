import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LeitorDeArquivo {
    //metodo 5
    public static List<Usuario> carregarUsuarios(String caminhoArquivo) throws TarefaException {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length < 1) throw new TarefaException("Erro no formato do arquivo.");
                Usuario usuario = new Usuario(dados[0]);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            throw new TarefaException("Erro ao ler o arquivo: " + e.getMessage());
        }
        return usuarios;
    }

    //metodo 6
    public static boolean verificarUsuarioExistente(String caminhoArquivo, String nomeUsuario) throws TarefaException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length < 1) throw new TarefaException("Erro no formato do arquivo.");

                if (dados[0].equalsIgnoreCase(nomeUsuario)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new TarefaException("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }
}
