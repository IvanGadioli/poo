import java.util.ArrayList;
import java.util.Properties;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ActorExportApp {

    public static void main(String[] args) {

        Properties prop = new Properties();
        ArrayList<ActorExport> actors = new ArrayList<>();

        try (InputStream input = new FileInputStream("db.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            System.err.println("File not found: " + ex.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(
            prop.getProperty("db.url"),
            prop.getProperty("db.user"),
            prop.getProperty("db.password")
        )){

            String selectSql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

            try (PreparedStatement ps = conn.prepareStatement(selectSql);
                ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    actors.add(new ActorExport(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        var lines = new ArrayList<String>();

        for (int i = 0; i < actors.size(); i++) {
            lines.add(actors.get(i).toCsvLine());
        }

        File file = new File(prop.getProperty("csv.path"));
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write("id,firstName,LastName");
            bw.newLine();
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
    }

}
