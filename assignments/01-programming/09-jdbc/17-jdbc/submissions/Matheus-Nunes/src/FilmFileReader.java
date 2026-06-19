import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FilmFileReader {

    public List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                line = line.trim();

                
                if (line.isEmpty() || line.startsWith("title")) {
                    continue;
                }

                String[] parts = line.split(";");

                if (parts.length != 5) {
                    System.err.println("Linha ignorada (formato inválido): " + line);
                    continue;
                }

                String title           = parts[0].trim();
                int    languageId      = Integer.parseInt(parts[1].trim());
                int    rentalDuration  = Integer.parseInt(parts[2].trim());
                double rentalRate      = Double.parseDouble(parts[3].trim());
                double replacementCost = Double.parseDouble(parts[4].trim());

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }

            System.out.println("Arquivo lido com sucesso. Filmes encontrados: " + films.size());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter dados do arquivo: " + e.getMessage());
        }

        return films;
    }
}