import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {
    public static void main(String[] args) throws Exception {
        // 1. Carrega db.properties
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        // 2. Abre conexão JDBC
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // 3. Executa consulta com Statement
            String sql = """
                SELECT actor_id, first_name, last_name
                FROM actor
                ORDER BY actor_id
                LIMIT 20;
            """;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // 4. Armazena resultados em ArrayList
                ArrayList<ActorExport> actors = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("actor_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    actors.add(new ActorExport(id, firstName, lastName));
                }

                // 5. Grava CSV
                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
                    writer.write("Id,Nome,Sobrenome");
                    writer.newLine();
                    for (ActorExport actor : actors) {
                        writer.write(actor.toCsvLine());
                        writer.newLine();
                    }
                }
            }
        }

        System.out.println("CSV gerado em: " + csvPath);
    }
}
