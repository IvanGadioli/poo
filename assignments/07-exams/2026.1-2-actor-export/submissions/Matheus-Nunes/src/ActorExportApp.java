import java.io.BufferedWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class ActorExportApp {
    public static void main(String[] args){
        Properties props = new Properties();
        try (InputStream input = Files.newInputStream(Path.of("db.properties"))) {
            props.load(input);
        } catch (Exception e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        List<ActorExport> actors = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;")) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                actors.add(new ActorExport(id, firstName, lastName));
            }
        } catch (Exception e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(csvPath))) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
                
            }
            System.out.println("Exportação concluída com sucesso para o arquivo: " + csvPath);
        } catch (Exception e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
    
}
