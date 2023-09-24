package listaDuplamenteEncadeada;

public class No {
    private Object dado;
    private No anterior;
    private No proximo;

    public No(Object dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }

    public Object getDado() {
        return dado;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}