import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
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
    public static void main(String[] args) {
        Properties properties = new Properties();
        String propertiesFilePath = "db.properties";

        try(InputStream is = Files.newInputStream(Paths.get(propertiesFilePath))) {
            properties.load(is);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo db.properties: " + e.getMessage());
            return;
        }

        String dbUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");
        String csvPath = properties.getProperty("csv.path");

        String query = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id";

        ArrayList<ActorExport> actors = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                ActorExport actor = new ActorExport(id, firstName, lastName);
                actors.add(actor);
            }

            System.out.println("Dados consultados com sucesso. Total de registros: " + actors.size());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados ou executar a consulta: " + e.getMessage());
            return;
        }

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("ID,Nome,Sobrenome");
            writer.newLine();

            for(ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }
            System.out.println("Arquivo CSV gerado com sucesso em: " + csvPath);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
