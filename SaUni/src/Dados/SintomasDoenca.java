package Dados;

public class SintomasDoenca {

    private int idSintomasDoenca;
    private int idDoenca;  //Chave estrangeira de doença
    private int idSintoma;  //Chave estrangeira de sintoma

    public SintomasDoenca() {

    }

    public int getIdSintomasDoenca() {
        return idSintomasDoenca;
    }

    public void setIdSintomasDoenca(int idSintomasDoenca) {
        this.idSintomasDoenca = idSintomasDoenca;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public int getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }
}
