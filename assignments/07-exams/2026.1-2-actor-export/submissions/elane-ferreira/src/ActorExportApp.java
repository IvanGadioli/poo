import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {
    public static void main(String[] args) throws IOException, SQLException {

        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        String url      = props.getProperty("db.url");
        String user     = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath  = props.getProperty("csv.path");

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = """
                SELECT actor_id, first_name, last_name
                FROM actor
                ORDER BY actor_id
                LIMIT 20;
                """;

        Statement stmt = conn.createStatement();
        ResultSet rs   = stmt.executeQuery(sql);

        ArrayList<ActorExport> atores = new ArrayList<>();
        while (rs.next()) {
            atores.add(new ActorExport(
                rs.getInt("actor_id"),
                rs.getString("first_name"),
                rs.getString("last_name")
            ));
        }

        rs.close();
        stmt.close();
        conn.close();

        var writer = Files.newBufferedWriter(Paths.get(csvPath));
        writer.write("Id,Nome,Sobrenome");
        writer.newLine();
        for (ActorExport ator : atores) {
            writer.write(ator.toCsvLine());
            writer.newLine();
        }
        writer.close();

        System.out.println("CSV gerado em: " + csvPath);
    }
}