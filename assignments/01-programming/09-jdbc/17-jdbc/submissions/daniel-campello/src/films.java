import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class films {
    public static void main(String[] args) {
        Properties props = new Properties();
        
        // Verifica se o arquivo properties existe
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }
        
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Desativa o commit automático para controlar a transação manualmente
            conn.setAutoCommit(false); 

            System.out.println("=== Filmes no Catálogo ===");
            // CORREÇÃO: Ajustada a query para selecionar rental_duration e corrigida a ordem/tipos no printf
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT title, rental_rate, rental_duration FROM film WHERE rental_duration = 99")) {
                while (rs.next()) {
                    System.out.printf("Título: %s | Taxa: %.2f | Duração: %d%n",
                            rs.getString("title"),
                            rs.getDouble("rental_rate"),
                            rs.getInt("rental_duration"));
                }
            }

            System.out.println("\n=== Buscar ator pelo sobrenome ===");
            String sobrenome = "Chase";
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?")) {
                ps.setString(1, sobrenome);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.printf("Ator: %s %s (ID: %d)%n",
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getInt("actor_id"));
                    }
                }
            }

            System.out.println("\n=== Inserir Filmes no Banco de Dados ===");
            // CORREÇÃO: Preenchidos todos os 5 parâmetros obrigatórios definidos no INSERT
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, "TEMP_MOVIE");
                ps.setInt(2, 1);          
                ps.setInt(3, 3);          
                ps.setDouble(4, 4.99);     
                ps.setDouble(5, 19.99);    
                
                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    try (ResultSet keys = ps.getGeneratedKeys()) {
                        if (keys.next()) {
                            int newId = keys.getInt(1);
                            System.out.println("Filme inserido com ID: " + newId);
                        }
                    }
                }
            }

            System.out.println("\n=== Atualizar Catálogo de filmes ===");
            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement psUpdate = conn.prepareStatement(updateSql)) {
                psUpdate.setDouble(1, 1.10);
                psUpdate.setInt(2, 5);       

                int rowsUpdated = psUpdate.executeUpdate();
                System.out.println("Linhas atualizadas: " + rowsUpdated);
            }

            conn.commit(); System.out.println("\nTransação efetivada com sucesso!");
            
            conn.rollback();
            System.out.println("\nRollback executado. Nenhuma alteração foi salva permanentemente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
