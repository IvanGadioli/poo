import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Main {

   
    private static final String DB_URL  = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:5432/postgres";
    private static final String DB_USER = "postgres.tjfjeahzjlkzrlgsujjj";
    private static final String DB_PASS = "iRnuP#LSsPAX";

    private static final String SQL_INSERT =
            "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE film SET rental_rate = rental_rate * 1.1";

    private static final String SQL_SELECT =
            "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

    // Caminho para o arquivo — ajuste se necessário
    private static final String FILE_PATH = "data/new_films.txt";

    public static void main(String[] args) {

        // 1. Lê os filmes do arquivo
        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.readFilms(FILE_PATH);

        if (films.isEmpty()) {
            System.out.println("Nenhum filme encontrado no arquivo. Encerrando.");
            return;
        }

        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            conn.setAutoCommit(false);

            importFilms(conn, films);
            updateRentalRates(conn);

            conn.commit();
            System.out.println("\nTransação concluída com sucesso.");

            listFilmsByDuration(conn);

        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void importFilms(Connection conn, List<Film> films) throws SQLException {
        System.out.println("\n--- Importando filmes ---");

        try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {
            for (Film film : films) {
                ps.setString(1, film.getTitle());
                ps.setInt(2, film.getLanguageId());
                ps.setInt(3, film.getRentalDuration());
                ps.setDouble(4, film.getRentalRate());
                ps.setDouble(5, film.getReplacementCost());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            System.out.println("Filmes inseridos: " + results.length);
        }
    }

    private static void updateRentalRates(Connection conn) throws SQLException {
        System.out.println("\n--- Atualizando rental_rate (+10%) ---");

        try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
            int rows = ps.executeUpdate();
            System.out.println("Filmes atualizados: " + rows);
        }
    }

    private static void listFilmsByDuration(Connection conn) throws SQLException {
        System.out.println("\n--- Filmes com duração de locação igual a 99 ---");
        System.out.printf("%-60s %s%n", "Título", "Valor de Locação");
        System.out.println("-".repeat(75));

        try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            int count = 0;
            while (rs.next()) {
                String title      = rs.getString("title");
                double rentalRate = rs.getDouble("rental_rate");
                System.out.printf("%-60s R$ %.2f%n", title, rentalRate);
                count++;
            }

            if (count == 0) {
                System.out.println("Nenhum filme encontrado com essa duração.");
            } else {
                System.out.println("-".repeat(75));
                System.out.println("Total: " + count + " filme(s).");
            }
        }
    }
}