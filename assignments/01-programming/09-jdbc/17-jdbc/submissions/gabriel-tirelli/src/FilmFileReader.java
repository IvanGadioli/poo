import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 1; i < lines.size(); i++) {

                String line = lines.get(i);

                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(";");
                
                String title = parts[0];
                int languageId = Integer.parseInt(parts[1]);
                int rentalDuration = Integer.parseInt(parts[2]);
                double rentalRate = Double.parseDouble(parts[3]);
                double replacementCost = Double.parseDouble(parts[4]);

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return films;
    }
}
