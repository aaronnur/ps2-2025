import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory () {}

    public static Connection getConnection(String url) {
        try {
            Class.forName("org.postgresql.Driver"); // garante que o driver JDBC seja carregado
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do PostgreSQL não encontrado!");
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao obter conexão: " + e.getMessage());
            return null;
        }
    }
}
