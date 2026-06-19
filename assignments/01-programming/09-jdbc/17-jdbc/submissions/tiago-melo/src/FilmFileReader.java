import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {
    public List<Film> read(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] fields = line.split(";");
                if (fields.length != 5) {
                    System.out.println("Linha ignorada: " + line);
                    continue;
                }

                try {
                    String title = fields[0].trim();
                    int languageId = Integer.parseInt(fields[1].trim());
                    int rentalDuration = Integer.parseInt(fields[2].trim());
                    double rentalRate = Double.parseDouble(fields[3].trim());
                    double replacementCost = Double.parseDouble(fields[4].trim());

                    films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                } catch (NumberFormatException exception) {
                    System.out.println("Linha ignorada por conter numero invalido: " + line);
                }
            }
        } catch (IOException exception) {
            System.out.println("Erro ao ler o arquivo " + filePath + ": " + exception.getMessage());
        }

        return films;
    }

    public static String findDefaultPath() {
        String[] paths = {
                "data/new_films.txt",
                "../../../data/new_films.txt"
        };

        for (String path : paths) {
            Path candidate = Paths.get(path);
            if (Files.exists(candidate)) {
                return path;
            }
        }

        return paths[0];
    }
}
