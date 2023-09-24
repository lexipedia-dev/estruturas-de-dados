package listaSimplesEncadeada;

public class No {
    private Object dado;
    private No proximo;

    public No(Object dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public Object getDado() {
        return dado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
