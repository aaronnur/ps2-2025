public class CriterioPrecoMinimo implements CriterioBusca{
    
    public boolean testar(Produto p, String valor){
        if (p.getPreco() >= Double.valueOf(valor))
            return true;
        return false;
    }

    
}