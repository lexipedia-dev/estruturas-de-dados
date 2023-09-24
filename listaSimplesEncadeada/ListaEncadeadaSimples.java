package listaSimplesEncadeada;

public class ListaEncadeadaSimples {
    private No primeiro;
    private int tamanho;

    public ListaEncadeadaSimples() {
        primeiro = null;
        tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public void insereNoInicio(Object dado) {
        No novoNo = new No(dado);
        novoNo.setProximo(primeiro);
        primeiro = novoNo;
        tamanho++;
    }

    public void insereNoFim(Object dado) {
        No novoNo = new No(dado);
        if (vazia()) {
            primeiro = novoNo;
        } else {
            No atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    public void insereNaPosicao(Object dado, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            insereNoInicio(dado);
        } else if (posicao == tamanho) {
            insereNoFim(dado);
        } else {
            No novoNo = new No(dado);
            No anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            novoNo.setProximo(anterior.getProximo());
            anterior.setProximo(novoNo);
            tamanho++;
        }
    }

    public void removeDoInicio() {
        if (!vazia()) {
            primeiro = primeiro.getProximo();
            tamanho--;
        }
    }

    public void removeDoFim() {
        if (!vazia()) {
            if (tamanho == 1) {
                primeiro = null;
            } else {
                No atual = primeiro;
                No anterior = null;
                while (atual.getProximo() != null) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                anterior.setProximo(null);
            }
            tamanho--;
        }
    }

    public void removeNaPosicao(int posicao) {
        if (vazia()) {
            return;
        }

        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            removeDoInicio();
        } else if (posicao == tamanho - 1) {
            removeDoFim();
        } else {
            No anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            No noRemovido = anterior.getProximo();
            anterior.setProximo(noRemovido.getProximo());
            tamanho--;
        }
    }

    public void imprimeLista() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
