import java.io.BufferedWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {

    public static void main(String[] args) {
        Properties props = new Properties();
        
        // 1. Carregar o arquivo db.properties
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);
        } catch (Exception e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            return; // Encerra a aplicação se não encontrar o arquivo
        }

        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPass = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        ArrayList<ActorExport> actors = new ArrayList<>();
        
        // Consulta SQL obrigatória
        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

        // 2. Conectar ao banco e executar a consulta
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // 3. Iterar sobre o ResultSet e armazenar na coleção
            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                
                ActorExport actor = new ActorExport(id, firstName, lastName);
                actors.add(actor);
            }

        } catch (Exception e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
            return;
        }

        // 4. Gravar o arquivo CSV
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            // Cabeçalho
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            
            // Dados
            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }
            System.out.println("Exportação concluída. Arquivo gerado em: " + csvPath);
        } catch (Exception e) {
            System.err.println("Erro ao escrever o arquivo CSV: " + e.getMessage());
        }
    }
}