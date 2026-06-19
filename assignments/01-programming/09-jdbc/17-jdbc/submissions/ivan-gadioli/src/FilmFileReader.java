import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            
            for (String line : lines) {
                String[] data = line.split(";");
                
                if (data.length == 5) {
                    Film film = new Film(
                        data[0],                                // title
                        Integer.parseInt(data[1]),              // language_id
                        Integer.parseInt(data[2]),              // rental_duration
                        Double.parseDouble(data[3]),            // rental_rate
                        Double.parseDouble(data[4])             // replacement_cost
                    );
                    films.add(film);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro grave ao tentar ler o arquivo de filmes: " + e.getMessage());
        }
        
        return films;
    }
}
