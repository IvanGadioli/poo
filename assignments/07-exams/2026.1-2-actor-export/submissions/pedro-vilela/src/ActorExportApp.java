import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class ActorExportApp {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(in);
        }

        String url      = props.getProperty("db.url");
        String user     = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath  = props.getProperty("csv.path");

        List<ActorExport> actors = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                 "SELECT actor_id, first_name, last_name " +
                 "FROM actor ORDER BY actor_id LIMIT 20")) {

            while (rs.next()) {
                actors.add(new ActorExport(
                    rs.getInt("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
                ));
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            for (ActorExport a : actors) {
                writer.write(a.toCsvLine());
                writer.newLine();
            }
        }

        System.out.println("CSV gerado em: " + csvPath + " com " + actors.size() + " registros.");
    }
}