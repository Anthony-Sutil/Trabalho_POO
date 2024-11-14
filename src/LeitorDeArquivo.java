import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {
    public List<Usuario> carregarUsuarios(String caminhoArquivo) throws IOException {
        List<Usuario> usuarios = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(caminhoArquivo);

        if (inputStream == null) {
            throw new IOException("Arquivo não encontrado: " + caminhoArquivo);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Usuario usuario = new Usuario(linha.trim(), ""); // Email vazio
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
}
