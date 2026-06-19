import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {
    
    public List<Film> readFilmsFromFile(String filePath) {
        List<Film> films = new ArrayList<>();
        
        try {

            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line == null || line.trim().isEmpty()) continue;
                
                String[] data = line.split(";");
                
                String title = data[0];
                int languageId = Integer.parseInt(data[1]);
                int rentalDuration = Integer.parseInt(data[2]);
                double rentalRate = Double.parseDouble(data[3].replace(",", "."));
                double replacementCost = Double.parseDouble(data[4].replace(",", "."));
                
                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de filmes: " + e.getMessage());
        }
        
        return films;
    }
}
