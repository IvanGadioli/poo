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
        Properties props = new Properties();
        Path propsPath = Paths.get("db.properties");

        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        } catch (Exception e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            return;
        }

        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPass = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        ArrayList<ActorExport> actorsList = new ArrayList<>();

        String sql = "SELECT\n" +
                     "    actor_id,\n" +
                     "    first_name,\n" +
                     "    last_name\n" +
                     "FROM actor\n" +
                     "ORDER BY actor_id\n" +
                     "LIMIT 20;";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                
                actorsList.add(new ActorExport(id, firstName, lastName));
            }

        } catch (Exception e) {
            System.err.println("Erro ao conectar ou consultar o banco de dados: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
  
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();

            for (ActorExport actor : actorsList) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }

            System.out.println("Arquivo CSV gerado com sucesso em: " + csvPath);

        } catch (Exception e) {
            System.err.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        }
    }
}
