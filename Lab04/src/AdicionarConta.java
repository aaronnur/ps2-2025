import java.sql.*;
import java.util.Scanner;
import java.math.BigDecimal;

public class AdicionarConta {
    public static void executar(Connection c, Scanner entrada) throws Exception {
        System.out.print("Número da conta: ");
        long nro = entrada.nextLong();
        System.out.print("Saldo inicial: ");
        BigDecimal saldo = entrada.nextBigDecimal();

        String sql = "INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setLong(1, nro);
        stm.setBigDecimal(2, saldo);
        int linhas = stm.executeUpdate();
        System.out.println("Conta criada. Linhas afetadas: " + linhas);
    }
}
