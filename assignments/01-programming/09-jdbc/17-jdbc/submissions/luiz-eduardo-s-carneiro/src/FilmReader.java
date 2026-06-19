import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilmReader{
    public static List<Film> readFilms(String caminho){
        
        List<Film> movies = new ArrayList<>();

        try{
            List<String> linhas = Files.readAllLines(Path.of(caminho));
            
            boolean primeiraLinha = true;

            for(String linha : linhas){
                if(primeiraLinha){
                    primeiraLinha = false;
                    continue;
                }
                String[] campo = linha.split(";");
                if(campo.length < 5) continue;
                movies.add(new Film(campo[0], Integer.parseInt(campo[1]), Integer.parseInt(campo[2]),
                        Double.parseDouble(campo[3]), Double.parseDouble(campo[4])));
            }

        } catch(IOException e){
            System.out.print("Arquivo não encontrado");
        }

        return movies;
    }
}