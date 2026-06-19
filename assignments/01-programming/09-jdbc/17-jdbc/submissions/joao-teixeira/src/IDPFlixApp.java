import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class IDPFlixApp {

    public static void main(String[] args) {
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(in);
        } catch (Exception e) {
            System.out.println("Erro ao carregar db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String dataPath = props.getProperty("data.path");

        ArrayList<Film> films = FileReader.readFilms(dataPath);
        System.out.println(films.size() + " filmes lidos do arquivo.");

        Properties connProps = new Properties();
        connProps.setProperty("user", user);
        connProps.setProperty("password", password);
        connProps.setProperty("connectTimeout", "10");
        connProps.setProperty("socketTimeout", "30");

        try (Connection conn = DriverManager.getConnection(url, connProps)) {

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    pstmt.setString(1, film.getTitle());
                    pstmt.setInt(2, film.getLanguageId());
                    pstmt.setInt(3, film.getRentalDuration());
                    pstmt.setDouble(4, film.getRentalRate());
                    pstmt.setDouble(5, film.getReplacementCost());
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }
            System.out.println(films.size() + " filmes importados para o banco.");

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                int updated = pstmt.executeUpdate();
                System.out.println(updated + " filmes atualizados (rental_rate +10%).");
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmt.executeQuery()) {

                System.out.println("\nFilmes com duracao de locacao = 99:");
                System.out.println("-------------------------------------");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("%-40s | R$ %.2f%n", title, rentalRate);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao acessar o banco: " + e.getMessage());
        }
    }
}
