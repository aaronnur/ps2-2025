import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.lbzasioqvshncenahcrw&password=Mack10417095.";

        // abre conexão e instancia DAO
        Connection conexao = ConnectionFactory.getConnection(url);
        ContaDao dao = new ContaDao(conexao);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta específica pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar o saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(0) Sair");
            System.out.print("Opção: ");
            int op = entrada.nextInt();

            if (op == 0) break;

            if (op == 1) {
                List<Conta> contas = dao.lerTodas();
                if (contas.isEmpty()) {
                    System.out.println("Nenhuma conta encontrada.");
                } else {
                    for (Conta c : contas) {
                        System.out.println("Conta: " + c.getNumero() + " | Saldo: " + c.getSaldo());
                    }
                }
            }

            if (op == 2) {
                System.out.print("Número da conta: ");
                long nro = entrada.nextLong();
                Conta conta = dao.buscarPeloNumero(nro);
                if (conta != null) {
                    System.out.println("Conta encontrada -> Número: " + conta.getNumero() + " | Saldo: " + conta.getSaldo());
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }

            if (op == 3) {
                System.out.print("Número da conta: ");
                long nro = entrada.nextLong();
                System.out.print("Saldo inicial: ");
                BigDecimal saldo = entrada.nextBigDecimal();

                Conta nova = new Conta(nro, saldo);
                if (dao.criar(nova)) {
                    System.out.println("Conta criada com sucesso!");
                } else {
                    System.out.println("Erro ao criar conta.");
                }
            }

            if (op == 4) {
                System.out.print("Número da conta: ");
                long nro = entrada.nextLong();
                Conta conta = dao.buscarPeloNumero(nro);
                if (conta != null) {
                    System.out.print("Novo saldo: ");
                    BigDecimal novoSaldo = entrada.nextBigDecimal();
                    conta.setSaldo(novoSaldo);
                    if (dao.atualizar(conta)) {
                        System.out.println("Saldo atualizado com sucesso!");
                    } else {
                        System.out.println("Erro ao atualizar saldo.");
                    }
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }

            if (op == 5) {
                System.out.print("Número da conta: ");
                long nro = entrada.nextLong();
                Conta conta = dao.buscarPeloNumero(nro);
                if (conta != null) {
                    if (dao.apagar(conta)) {
                        System.out.println("Conta apagada com sucesso!");
                    } else {
                        System.out.println("Erro ao apagar conta.");
                    }
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }
        }

        conexao.close();
        entrada.close();
        System.out.println("Programa encerrado.");
    }
}
