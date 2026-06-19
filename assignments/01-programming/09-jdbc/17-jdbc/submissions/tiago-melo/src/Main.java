import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : FilmFileReader.findDefaultPath();
        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.read(filePath);

        if (films.isEmpty()) {
            System.out.println("Nenhum filme foi lido do arquivo.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            insertFilms(connection, films);
            updateRentalRates(connection);
            listFilmsWithRentalDuration99(connection);
        } catch (SQLException exception) {
            System.out.println("Erro ao acessar o banco de dados: " + exception.getMessage());
        }
    }

    private static void insertFilms(Connection connection, List<Film> films) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Film film : films) {
                statement.setString(1, film.getTitle());
                statement.setInt(2, film.getLanguageId());
                statement.setInt(3, film.getRentalDuration());
                statement.setDouble(4, film.getRentalRate());
                statement.setDouble(5, film.getReplacementCost());
                statement.executeUpdate();
            }
        }

        System.out.println(films.size() + " filmes importados.");
    }

    private static void updateRentalRates(Connection connection) throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int updatedRows = statement.executeUpdate();
            System.out.println(updatedRows + " filmes atualizados com acrescimo de 10% no rental_rate.");
        }
    }

    private static void listFilmsWithRentalDuration99(Connection connection) throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Filmes com duracao de locacao igual a 99:");

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double rentalRate = resultSet.getDouble("rental_rate");
                System.out.printf("%s - %.2f%n", title, rentalRate);
            }
        }
    }
}
