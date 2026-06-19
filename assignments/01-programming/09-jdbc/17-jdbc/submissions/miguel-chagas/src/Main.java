import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        List<Film> films = FileReaderUtil.readFilms("../../data/new_films.txt");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    pstmt.setString(1, film.getTitle());
                    pstmt.setInt(2, film.getLanguageId());
                    pstmt.setInt(3, film.getRentalDuration());
                    pstmt.setDouble(4, film.getRentalRate());
                    pstmt.setDouble(5, film.getReplacementCost());
                    pstmt.executeUpdate();
                }
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.executeUpdate();
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("title") + " - " + rs.getDouble("rental_rate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
