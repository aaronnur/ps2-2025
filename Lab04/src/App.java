import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.lbzasioqvshncenahcrw&password=Mack123.";
        Connection c = DriverManager.getConnection(url);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Listar contas");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Alterar conta");
            System.out.println("4 - Remover conta");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = entrada.nextInt();

            if (op == 0) break;
            if (op == 1) ListarContas.executar(c);
            if (op == 2) AdicionarConta.executar(c, entrada);
            if (op == 3) AlterarConta.executar(c, entrada);
            if (op == 4) RemoverConta.executar(c, entrada);
        }

        c.close();
        entrada.close();
        System.out.println("Conexão encerrada.");
    }
}
