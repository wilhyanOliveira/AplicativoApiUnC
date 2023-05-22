package Data.repository;

import Data.Resultado;
import br.unc.appapiunc.conectaApi.AssertConecta;
import br.unc.appapiunc.conectaApi.conexao;

public class repository {
    private static volatile repository  instance;

    private final AssertConecta dataSource;

    private conexao currentAdvice;

    public repository(AssertConecta dataSource) {
        this.dataSource = dataSource;
    }

    public static repository getInstance(AssertConecta dataSource) {
        if(instance == null){
            instance = new repository(dataSource);
        }

        return instance;
    }

    public void setAdvice(conexao advice){ this.currentAdvice = advice;}

    public Resultado<conexao> getAdvice() {
        Resultado<conexao> result = new Resultado<>();
        if(result instanceof  Resultado.Success){
            setAdvice(((Resultado.Success<conexao>) result).getData());
        }
        return result;
    }
}
