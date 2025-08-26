import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStreaming {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Midia> midias = new ArrayList<>();
        int opcao;

        do {
            System.out.println("--- MENU STREAMING ---");
            System.out.println("(1) Adicionar novo Filme");
            System.out.println("(2) Adicionar nova Série");
            System.out.println("(3) Listar todas as mídias");
            System.out.println("(4) Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título do filme: ");
                    String tituloFilme = entrada.nextLine();
                    System.out.print("Duração do filme (em minutos): ");
                    long duracaoFilme = entrada.nextLong();
                    entrada.nextLine();

                    Filme filme = new Filme(tituloFilme, duracaoFilme);
                    midias.add(filme);
                    System.out.println("Filme adicionado!");
                    break;

                case 2:
                    System.out.print("Título da série: ");
                    String tituloSerie = entrada.nextLine();
                    Serie serie = new Serie(tituloSerie);

                    // criar temporadas
                    for (int t = 1; t <= 2; t++) {
                        Temporada temporada = new Temporada(t);
                        System.out.println("Criando Temporada " + t);

                        // episódios em cada temporada
                        for (int e = 1; e <= 2; e++) {
                            System.out.print("Título do Episódio " + e + ": ");
                            String tituloEp = entrada.nextLine();
                            System.out.print("Duração do Episódio (min): ");
                            long duracaoEp = entrada.nextLong();
                            entrada.nextLine();

                            temporada.adicionar(new Episodio(tituloEp, duracaoEp));
                        }

                        serie.adicionar(temporada);
                    }

                    midias.add(serie);
                    System.out.println("A Série foi adicionada!");
                    break;

                case 3:
                    System.out.println("\n--- TODAS AS MÍDIAS ---");
                    if (midias.isEmpty()) {
                        System.out.println("Nenhuma mídia foi cadastrada ainda.");
                    } else {
                        for (Midia m : midias) {
                            System.out.println(m.info());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo, adeus.");
                    break;

                default:
                    System.out.println("Opção não aceita!");
            }

        } while (opcao != 4);

        entrada.close();
    }
}
