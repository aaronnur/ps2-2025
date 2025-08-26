import java.util.List;
import java.util.ArrayList;

public class Serie extends Midia {
    private List<Temporada> temporadas;

    public Serie(String titulo) {
        super(titulo);
        temporadas = new ArrayList<>();
    }

    public void adicionar(Temporada temporada) {
        temporadas.add(temporada);
    }

    @Override
    public long getDuracao() {
        long duracao = 0;
        for (int i = 0; i < temporadas.size(); i++) {
            duracao += temporadas.get(i).getDuracao();
        }
        return duracao;
    }

    @Override
    public String info() {
        return "Série: " + super.info() + "; Duração total: " + getDuracao();
    }
}
