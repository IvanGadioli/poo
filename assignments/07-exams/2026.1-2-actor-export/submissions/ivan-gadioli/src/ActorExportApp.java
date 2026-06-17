import java.io.BufferedWriter;
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
  public static void main(String[] args) {
    Properties props = new Properties();
    Path propsPath = Path.of("db.properties");

    // Carregar o arquivo de prop
    try (InputStream in = Files.newInputStream(propsPath)) {
      props.load(in);
    } catch (Exception e) {
      System.err.println("Erro ao ler o arquivo db.properties: " + e.getMessage());
      return;
    }

    // Credenciais SQL
    String url = props.getProperty("db.url");
    if (url == null || url.isBlank()) {
      System.err.println("Erro Critico: A propriedade 'url' não foi encontrada no db.properties.");
    }
    String user = props.getProperty("db.user");
    if (user == null || user.isBlank()) {
      System.err.println("Erro Critico: A propriedade 'user' não foi encontrada no db.properties.");
    }
    String password = props.getProperty("db.password");
    if (password == null || password.isBlank()) {
      System.err.println("Erro Critico: A propriedade 'password' não foi encontrada no db.properties.");
    }
    String csvPathStr = props.getProperty("csv.path");
    if (csvPathStr == null || csvPathStr.isBlank()) {
      System.err.println("Erro Critico: A propriedade 'csv.path' não foi encontrada no db.properties.");
    }

    List<ActorExport> actors = new ArrayList<>();

    // Connection JDBC
    String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

    try (
        Connection conn = DriverManager.getConnection(url, user, password); // Abrindo Connection
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);) {
      while (rs.next()) {
        int id = rs.getInt("actor_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        actors.add(new ActorExport(id, firstName, lastName));
      }
      System.out.println("Dados carregados com sucesso. Total de atores: " + actors.size());
    } catch (Exception e) {
      System.err.println("Erro de banco de dados: " + e.getMessage());
      e.printStackTrace();
      return;
    }

    // Grava~çao do Arquivo csv
    Path csvPath = Path.of(csvPathStr);

    try (BufferedWriter writer = Files.newBufferedWriter(csvPath)) {
      writer.write("ID, Nome, Sobrenome");
      writer.newLine(); // Quebra de linha

      for (ActorExport actor : actors) {
        writer.write(actor.toCsvLine());
        writer.newLine();
      }
      System.out.println("Arquivo CSV ggerado com sucesso em: " + csvPath.toAbsolutePath());

    } catch (Exception e) {
      System.err.println("Erro na escrita do arquivo CSV: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
