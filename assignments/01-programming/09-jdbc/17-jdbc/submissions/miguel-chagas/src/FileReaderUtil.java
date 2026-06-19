import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<Film> readFilms(String path) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(";");
                films.add(new Film(
                    parts[0],
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]),
                    Double.parseDouble(parts[3]),
                    Double.parseDouble(parts[4])
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return films;
    }
}
