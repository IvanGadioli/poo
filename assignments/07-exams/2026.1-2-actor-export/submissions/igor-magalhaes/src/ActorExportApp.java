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

        try {
            InputStream input = Files.newInputStream(Paths.get("db.properties"));
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            String csvPath = props.getProperty("csv.path");

            ArrayList<ActorExport> actors = new ArrayList<>();

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            String sql =
                    "SELECT actor_id, first_name, last_name " +
                    "FROM actor " +
                    "ORDER BY actor_id " +
                    "LIMIT 20";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                actors.add(new ActorExport(id, firstName, lastName));
            }

            BufferedWriter writer =
                    Files.newBufferedWriter(Path.of(csvPath));

            writer.write("Id,Nome,Sobrenome");
            writer.newLine();

            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }

            writer.close();
            rs.close();
            stmt.close();
            conn.close();

            System.out.println("CSV gerado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}