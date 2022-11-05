package conectaPg.entities;

public class Computador {

    private int codComputador;
    private String Descricao;
    private int Qtd;

    public int getCodComputador() {
        return codComputador;
    }

    public void setCodComputador(int codComputador) {
        this.codComputador = codComputador;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getQtd() {
        return Qtd;
    }

    public void setQtd(int qtd) {
        Qtd = qtd;
    }

}
