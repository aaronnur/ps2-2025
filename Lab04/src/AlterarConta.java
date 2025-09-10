import java.sql.*;
import java.util.Scanner;
import java.math.BigDecimal;

public class AlterarConta {
    public static void executar(Connection c, Scanner entrada) throws Exception {
        System.out.print("Número da conta a alterar: ");
        long nro = entrada.nextLong();
        System.out.print("Novo saldo: ");
        BigDecimal saldo = entrada.nextBigDecimal();

        String sql = "UPDATE contas SET saldo = ? WHERE nro_conta = ?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setBigDecimal(1, saldo);
        stm.setLong(2, nro);
        int linhas = stm.executeUpdate();
        System.out.println("Conta alterada. Linhas afetadas: " + linhas);
    }
}
