import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ActorExportApp {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        try (InputStream entrada = Files.newInputStream(Path.of("db.properties"))) {
            props.load(entrada);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

        List<ActorExport> actors = new ArrayList<>();

        try (Connection conexao = DriverManager.getConnection(url, user, password);
             Statement stmt = conexao.createStatement();
             ResultSet resultado = stmt.executeQuery(sql)) {

            while (resultado.next()) {
                int id = resultado.getInt("actor_id");
                String firstName = resultado.getString("first_name");
                String lastName = resultado.getString("last_name");
                actors.add(new ActorExport(id, firstName, lastName));
            }
        }

        try (var escritor = Files.newBufferedWriter(Path.of(csvPath))) {
            escritor.write("Id,Nome,Sobrenome");
            escritor.newLine();
            for (ActorExport actor : actors) {
                escritor.write(actor.toCsvLine());
                escritor.newLine();
            }
        }

        System.out.println("CSV gerado em: " + csvPath);
    }
}
