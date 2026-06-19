import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {
    public static void main(String[] args) {
        //carregar o db.properties para obter as informações de conexão
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")){
            props.load(fis);
        }catch(IOException e){
            System.out.println("Erro ao ler db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("url");
        String usuario = props.getProperty("user");
        String senha = props.getProperty("password");
        String csvPath = props.getProperty("csv.path");

        //conectar ao banco de dados e exportar os atores para um arquivo CSV
        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conexão estabelecida com sucesso!");
            
            String sqlSelect = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20";

            try (PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
                ResultSet rs = pstmt.executeQuery()) {

                ArrayList<ActorExport> actors = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("actor_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");

                    ActorExport actorExport = new ActorExport(id, firstName, lastName);
                    actors.add(actorExport);
                }

                // Exportar para CSV
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath))) {
                    for (ActorExport actor : actors) {
                        writer.write(actor.toCsvLine());
                        writer.newLine();
                    }
                    System.out.println("Atores exportados para " + csvPath);
                } catch (IOException e) {
                    System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
                }

            } catch (SQLException e) {
                System.out.println("Erro ao executar a consulta: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

}
