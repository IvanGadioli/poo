import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {

    public static void main(String[] args) {

        ArrayList<ActorExport> atores = new ArrayList<>();
        
        Path propPath = Paths.get("db.properties");

        Properties props = new Properties();
        try (InputStream is = Files.newInputStream(propPath)) {
            props.load(is);
        } catch (IOException e) {
            System.err.println("Erro ao abrir db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPathStr = props.getProperty("csv.path", "actors.csv");
        Path csvPath = Paths.get(csvPathStr);

        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                ActorExport ator = new ActorExport(id, firstName, lastName);
                atores.add(ator);
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(csvPath)) {

            writer.write("Id,Nome,Sobrenome");
            writer.newLine();

            for (ActorExport ator : atores) {
                writer.write(ator.toCsvLine());
                writer.newLine();
            }

            System.out.println("Exportação concluída com sucesso! Arquivo gerado: " + csvPath.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        }
    }
}