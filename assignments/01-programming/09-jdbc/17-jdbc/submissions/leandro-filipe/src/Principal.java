import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;

// Classe principal para execução
public class Principal {
    public static void main(String[] args) {
        // Exemplo de uso:
        try {
            FilmDAO dao = new FilmDAO();
            dao.insertFilm("O Código Java", "Um filme sobre JDBC");
            System.out.println("Operação realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Classe de Conexão
class DB {
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        return DriverManager.getConnection(props.getProperty("db.url"), props);
    }
}

// Classe de Auditoria
class AuditLogger {
    public static void log(String msg) {
        try {
            String entry = LocalDateTime.now() + " - " + msg + System.lineSeparator();
            Files.write(Paths.get("audit.log"), entry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) { e.printStackTrace(); }
    }
}

// Classe de CRUD (DAO)
class FilmDAO {
    public void insertFilm(String title, String desc) throws SQLException, IOException {
        String sql = "INSERT INTO film (title, description) VALUES (?, ?)";
        try (Connection conn = DB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.executeUpdate();
            AuditLogger.log("Inserido: " + title);
        }
    }
    // Adicione os outros métodos aqui...
}