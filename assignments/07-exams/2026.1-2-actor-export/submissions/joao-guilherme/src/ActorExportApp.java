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
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("db.url");
        String user =  props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20";

        ArrayList<ActorExport> atores = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                atores.add (new ActorExport(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                ));
            }
        }

        Path out = Paths.get(csvPath);
        try (BufferedWriter writer = Files.newBufferedWriter(out)) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            for (ActorExport a : atores) {
                writer.write(a.toCsvLine());
                writer.newLine();
            }
        }
        System.out.println("CSV gerado em: " + out.toAbsolutePath());
        System.out.println(atores.size() + " atores exportados");
    }
}