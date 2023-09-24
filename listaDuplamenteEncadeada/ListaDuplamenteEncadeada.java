package listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        primeiro = null;
        ultimo = null;
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
        if (vazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.setProximo(primeiro);
            primeiro.setAnterior(novoNo);
            primeiro = novoNo;
        }
        tamanho++;
    }

    public void insereNoFim(Object dado) {
        No novoNo = new No(dado);
        if (vazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.setAnterior(ultimo);
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
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
            No atual = primeiro;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
            novoNo.setAnterior(atual.getAnterior());
            novoNo.setProximo(atual);
            atual.getAnterior().setProximo(novoNo);
            atual.setAnterior(novoNo);
            tamanho++;
        }
    }

    public Object buscaNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual.getDado();
    }

    public void removeDoInicio() {
        if (!vazia()) {
            primeiro = primeiro.getProximo();
            if (primeiro != null) {
                primeiro.setAnterior(null);
            } else {
                ultimo = null; // Se não houver mais elementos na lista.
            }
            tamanho--;
        }
    }
    public void removeNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            removeDoInicio();
        } else if (posicao == tamanho - 1) {
            removeDoFim();
        } else {
            No atual = primeiro;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
            atual.getAnterior().setProximo(atual.getProximo());
            atual.getProximo().setAnterior(atual.getAnterior());
            tamanho--;
        }
    }

    public void removeDoFim() {
        if (!vazia()) {
            ultimo = ultimo.getAnterior();
            if (ultimo != null) {
                ultimo.setProximo(null);
            } else {
                primeiro = null; // Se não houver mais elementos na lista.
            }
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