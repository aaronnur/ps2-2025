import java.sql.*;
import java.util.Scanner;

public class RemoverConta {
    public static void executar(Connection c, Scanner entrada) throws Exception {
        System.out.print("Número da conta a remover: ");
        long nro = entrada.nextLong();

        String sql = "DELETE FROM contas WHERE nro_conta = ?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setLong(1, nro);
        int linhas = stm.executeUpdate();
        System.out.println("Conta removida. Linhas afetadas: " + linhas);
    }
}
