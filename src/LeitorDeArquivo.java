import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {
    public List<Usuario> carregarUsuarios(String caminhoArquivo) throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    Usuario usuario = new Usuario(dados[0], dados[1]);
                    usuarios.add(usuario);
                }
            }
        }
        return usuarios;
    }
}
