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

    private static final String SQL =
            "SELECT " +
            "    actor_id, " +
            "    first_name, " +
            "    last_name " +
            "FROM actor " +
            "ORDER BY actor_id " +
            "LIMIT 20";

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
                props.load(input);
            }

            String dbUrl = props.getProperty("db.url");
            String dbUser = props.getProperty("db.user");
            String dbPassword = props.getProperty("db.password");
            String csvPath = props.getProperty("csv.path");

            ArrayList<ActorExport> atores = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL)) {

                while (rs.next()) {
                    int id = rs.getInt("actor_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    atores.add(new ActorExport(id, firstName, lastName));
                }
            }

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
                writer.write("Id,Nome,Sobrenome");
                writer.newLine();
                for (ActorExport ator : atores) {
                    writer.write(ator.toCsvLine());
                    writer.newLine();
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
