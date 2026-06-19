import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class IDPFlix {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        String filePath = "data/new_films.txt";
        List<Film> films = FilmFileReader.readFilms(filePath);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // 1. Inserir filmes
            String insertSQL = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                for (Film film : films) {
                    ps.setString(1, film.getTitle());
                    ps.setInt(2, film.getLanguageId());
                    ps.setInt(3, film.getRentalDuration());
                    ps.setDouble(4, film.getRentalRate());
                    ps.setDouble(5, film.getReplacementCost());
                    ps.executeUpdate();
                }
                System.out.println("Filmes importados com sucesso.");
            }

            // 2. Atualizar rental_rate em 10%
            String updateSQL = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement ps = conn.prepareStatement(updateSQL)) {
                int rows = ps.executeUpdate();
                System.out.println("Filmes atualizados: " + rows);
            }

            // 3. Listar filmes com rent_duration = 99
            String selectSQL = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement ps = conn.prepareStatement(selectSQL);
                 ResultSet rs = ps.executeQuery()) {
                System.out.println("\nFilmes com duração de locação 99:");
                while (rs.next()) {
                    System.out.println(rs.getString("title") + " - R$ " + rs.getDouble("rental_rate"));
                }
            }

        } catch (Exception e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}