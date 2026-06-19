import java.io.BufferedWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {

    public static void main(String[] args) {
        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";
        
        ArrayList<ActorExport> actors = new ArrayList<>();
        Properties props = new Properties();
        Path propsPath = Paths.get("db.properties");

        try (InputStream input = Files.newInputStream(propsPath)) {
            props.load(input);
        } catch (Exception e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            return;
        }

        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPass = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                actors.add(new ActorExport(id, firstName, lastName));
            }
            
            System.out.println("Dados extraídos do banco de dados com sucesso. Total: " + actors.size());

        } catch (Exception e) {
            System.err.println("Erro ao conectar ou consultar o banco de dados: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            
            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }
            
            System.out.println("Arquivo CSV gerado com sucesso em: " + csvPath);

        } catch (Exception e) {
            System.err.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        }
    }
}