import java.sql.*;

public class ListarContas {
    public static void executar(Connection c) throws Exception {
        String sql = "SELECT * FROM contas";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while (resultado.next()) {
            long nro = resultado.getLong("nro_conta");
            java.math.BigDecimal saldo = resultado.getBigDecimal("saldo");
            System.out.println("Número: " + nro + " - R$ " + saldo);
        }
    }
}
