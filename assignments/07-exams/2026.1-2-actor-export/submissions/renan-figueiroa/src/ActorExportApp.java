import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;




public class ActorExportApp {

public static Path criarArquivoCsv() throws IOException {
        
        Path caminho = Path.of("actor.csv");
        
        if (Files.notExists(caminho)) {
            Files.createFile(caminho);
        }
        return caminho;
    }

    public static void gravarCsv(Path caminho, List<ActorExport> atores) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(caminho, StandardCharsets.UTF_8)) {

            writer.write("Id,Nome,Sobrenome");
            writer.newLine();

            
            for (ActorExport ator : atores) {
                writer.write(ator.toCsvLine());
                writer.newLine();
            }
        }
    }
    public static void main(String[] args) {
        Properties props = new Properties();
        ArrayList<ActorExport> actorList = new ArrayList<ActorExport>();

        try (InputStream input = Files.newInputStream(Path.of("db.properties"))) {

            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
        conn.setAutoCommit(false);
                       
            try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT actor_id,first_name,last_name FROM actor ORDER BY actor_id LIMIT 20;")) {
                
                while (rs.next()){

                    ActorExport actor = new ActorExport(rs.getInt("actor_id"), 
                    rs.getString("first_name"), 
                    rs.getString("last_name"));

                    actorList.add(actor);

                }
                
                Path caminhoCsv = criarArquivoCsv();
                gravarCsv(caminhoCsv, actorList);
          
            }

        }  catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e.getMessage());
        } catch (IOException e) { 

            System.out.println("Erro ao gerar ou salvar o arquivo CSV: " + e.getMessage());
        }
        
        

    }
}
