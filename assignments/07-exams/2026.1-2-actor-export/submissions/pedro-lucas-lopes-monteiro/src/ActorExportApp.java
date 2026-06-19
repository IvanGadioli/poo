import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {

    public static void main(String[] args) {

        Properties properties = new Properties();

        try {

            properties.load(Files.newInputStream(Paths.get("db.properties")));

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            String csvPath = properties.getProperty("csv.path");

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String sql = """
                    SELECT
                        actor_id,
                        first_name,
                        last_name
                    FROM actor
                    ORDER BY actor_id
                    LIMIT 20;
                    """;

            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<ActorExport> actors = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                ActorExport actor = new ActorExport(id, firstName, lastName);

                actors.add(actor);
            }

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath));

            writer.write("Id,Nome,Sobrenome");
            writer.newLine();

            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }

            writer.close();
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Arquivo CSV criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}