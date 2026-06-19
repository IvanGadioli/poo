import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDPFlixApp {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dvd_rental";
        String user = "postgres";
        String password = "sua_senha";

        List<Film> filmsToImport = FilmFileReader.readFilms("new_films.txt");
        
        if(filmsToImport.isEmpty()) {
            System.out.println("Nenhum filme foi carregado. Verifique o arquivo.");
            return; // Encerra a execução caso o arquivo esteja vazio ou falhe
        }

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            
            System.out.println("Conexão com o banco dvd_rental estabelecida com sucesso!");

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement pstmtInsert = conn.prepareStatement(insertSql)) {
                for (Film film : filmsToImport) {
                    pstmtInsert.setString(1, film.getTitle());
                    pstmtInsert.setInt(2, film.getLanguageId());
                    pstmtInsert.setInt(3, film.getRentalDuration());
                    pstmtInsert.setDouble(4, film.getRentalRate());
                    pstmtInsert.setDouble(5, film.getReplacementCost());
                    
                    pstmtInsert.executeUpdate(); 
                }
                System.out.println("- " + filmsToImport.size() + " filmes importados com sucesso.");
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            
            try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateSql)) {
                int rowsUpdated = pstmtUpdate.executeUpdate();
                System.out.println("- Atualização concluída. Total de filmes reajustados: " + rowsUpdated);
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rent_duration = 99";
            
            try (PreparedStatement pstmtSelect = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmtSelect.executeQuery()) {
                
                System.out.println("\n--- LISTA DE FILMES COM DURAÇÃO 99 ---");
                boolean found = false;
                
                // O método rs.next() move o cursor para cada linha do resultado
                while (rs.next()) {
                    found = true;
                    String title = rs.getString("title");
                    double rate = rs.getDouble("rental_rate");
                    System.out.println(String.format("Título: %s | Valor de Locação: $%.2f", title, rate));
                }
                
                if (!found) {
                    System.out.println("Nenhum filme com duração 99 foi encontrado.");
                }
              }

        } catch (SQLException e) {
            System.err.println("Erro grave de Banco de Dados: " + e.getMessage());
        }
    }
}
