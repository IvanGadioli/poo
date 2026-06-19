import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class IDPFlix {

    private static final String URL      = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "postgres";

    private static final String SQL_INSERT =
            "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE film SET rental_rate = rental_rate * 1.1";

    private static final String SQL_SELECT =
            "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

    public static void main(String[] args) {
        String filePath = "data/new_films.txt";

        List<Film> films = FilmFileReader.readFilms(filePath);
        System.out.println(films.size() + " filme(s) lidos do arquivo.");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Importar filmes do arquivo para o banco
            System.out.println("\nImportando filmes para o banco de dados...");
            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {
                for (Film film : films) {
                    ps.setString(1, film.getTitle());
                    ps.setInt(2, film.getLanguageId());
                    ps.setInt(3, film.getRentalDuration());
                    ps.setDouble(4, film.getRentalRate());
                    ps.setDouble(5, film.getReplacementCost());
                    ps.executeUpdate();
                }
            }
            System.out.println("Filmes importados com sucesso.");

            // Atualizar em 10% o valor de locação de todos os filmes
            System.out.println("\nAtualizando rental_rate em 10%...");
            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
                int linhasAfetadas = ps.executeUpdate();
                System.out.println(linhasAfetadas + " filme(s) atualizado(s).");
            }

            // Listar filmes com duração de locação igual a 99
            System.out.println("\nFilmes com rental_duration = 99:");
            System.out.printf("%-50s %s%n", "Título", "Valor de Locação");
            System.out.println("-".repeat(65));
            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("%-50s %.2f%n", title, rentalRate);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }
}
