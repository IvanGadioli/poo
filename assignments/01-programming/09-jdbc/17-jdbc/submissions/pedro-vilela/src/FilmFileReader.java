import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                try {
                    String title = parts[0].trim();
                    int languageId = Integer.parseInt(parts[1].trim());
                    int rentalDuration = Integer.parseInt(parts[2].trim());
                    double rentalRate = Double.parseDouble(parts[3].trim());
                    double replacementCost = Double.parseDouble(parts[4].trim());

                    films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                } catch (NumberFormatException e) {
                    System.out.println("Linha inválida ignorada: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return films;
    }
}