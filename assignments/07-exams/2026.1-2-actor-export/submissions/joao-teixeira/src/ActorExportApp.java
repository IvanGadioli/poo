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

        try (InputStream in = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(in);
        } catch (Exception e) {
            System.out.println("Erro ao carregar db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

        ArrayList<ActorExport> atores = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                atores.add(new ActorExport(id, firstName, lastName));
            }

            System.out.println(atores.size() + " atores carregados do banco.");

        } catch (Exception e) {
            System.out.println("Erro ao acessar o banco: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();

            for (ActorExport ator : atores) {
                writer.write(ator.toCsvLine());
                writer.newLine();
            }

            System.out.println("Arquivo CSV gerado em: " + csvPath);

        } catch (Exception e) {
            System.out.println("Erro ao gravar CSV: " + e.getMessage());
        }
    }
}
