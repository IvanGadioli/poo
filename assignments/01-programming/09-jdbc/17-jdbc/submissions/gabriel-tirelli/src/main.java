import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class main {

    public static void main(String[] args) {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("db.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            System.err.println("File not found: " + ex.getMessage());
        }

        tring URL = prop.getProperty("db.url");
        String USER = prop.getProperty("db.user");
        String PASSWORD = prop.getProperty("db.password");
        
        List<Film> films = FilmFileReader.readFilms("../../../data/new_films.txt");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

            try (PreparedSatement ps = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    ps.setString(1, film.getTitle());
                    ps.setInt(2, film.getLanguageId());
                    ps.setInt(3, film.getRentalDuration());
                    ps.setDouble(4, film.getRentalRate());
                    ps.setDouble(5, film.getReplacementCost());
                    ps.executeUpdate();
                }
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.10";

            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.executeUpdate();
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

            try (PreparedStatement ps = conn.prepareStatement(selectSql);
                ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("title") + " - " + rs.getDouble("rental_rate"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
