import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDPFlixApp {


    private static final String DB_URL = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:5432/postgres";
    private static final String DB_USER = "postgres.tjfjeahzjlkzrlgsujjj";
    private static final String DB_PASSWORD = "iRnuP#LSsPAX";
    
    private static final String FILE_PATH = "./data/new_films.txt";

    public static void main(String[] args) {
    
        
        FilmReader reader = new FilmReader();
        List<Film> filmsToImport = reader.readFilmsFromFile(FILE_PATH);

        if (filmsToImport.isEmpty()) {
            System.out.println("Nenhum filme encontrado para importar.");
            return;
        }

       
        String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
       
        String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            PreparedStatement selectStmt = conn.prepareStatement(selectSql)
        ) {
            System.out.println("Conexão com o banco estabelecida com sucesso.");

            for (Film film : filmsToImport) {
                insertStmt.setString(1, film.getTitle());
                insertStmt.setInt(2, film.getLanguageId());
                insertStmt.setInt(3, film.getRentalDuration());
                insertStmt.setDouble(4, film.getRentalRate());
                insertStmt.setDouble(5, film.getReplacementCost());
                
                insertStmt.executeUpdate(); 
            }
            System.out.println(filmsToImport.size() + " filmes inseridos com sucesso!");

    
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println("Valores de locação atualizados! Total de registros afetados: " + rowsUpdated);

            System.out.println("\n--- Filmes com duração de locação igual a 99 ---");
            try (ResultSet rs = selectStmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("Título: %s | Valor de Locação: %.2f%n", title, rentalRate);
                }
                if (!found) {
                    System.out.println("Nenhum filme com duração igual a 99 foi encontrado.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro na comunicação com o banco de dados: " + e.getMessage());
        }
    }
}