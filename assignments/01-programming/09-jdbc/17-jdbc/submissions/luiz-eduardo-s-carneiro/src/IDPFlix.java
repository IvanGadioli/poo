import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;


public class IDPFlix{
    public static void main(String[] args){
        Properties props = new Properties();

        try (InputStream input = Files.newInputStream(Path.of("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try(Connection conn = DriverManager.getConnection(url, user, password)){

            conn.setAutoCommit(false); 

            List<Film> movies = FilmReader.readFilms("data/new_films.txt");
            
            for(Film movie : movies){           
                try(PreparedStatement ps = conn.prepareStatement("INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)")){
                    ps.setString(1, movie.getTitle());
                    ps.setInt(2, movie.getLanguageId());
                    ps.setInt(3, movie.getRentalDurantion());
                    ps.setDouble(4, movie.getRentalRate());
                    ps.setDouble(5, movie.getReplacementCost());
                    ps.executeUpdate();
                }
            }

            try(PreparedStatement ps2 = conn.prepareStatement("UPDATE film SET rental_rate = rental_rate * 1.1")){
                ps2.executeUpdate();
            }

            try(PreparedStatement ps3 = conn.prepareStatement("SELECT title, rental_rate FROM film WHERE rental_duration = 99"); 
                ResultSet rs = ps3.executeQuery()){
                
                while(rs.next()){
                    System.out.printf("%s - %.2f\n", rs.getString("title"), rs.getDouble("rental_rate"));
                }

            }

            conn.commit();

        }  catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e);
        }
    }

}