package armazenamentoSequencialEmVetores;

public class Vetor {
    private Aluno[] alunos = new Aluno[100];
    private int tamanho = 0;

    public void insere(Aluno aluno) {
        // Recebe um aluno e insere na próxima posição disponível no vetor.
        if (tamanho < alunos.length) {
            alunos[tamanho] = aluno;
            tamanho++;
        }
    }

    public Aluno pega(int posicao) {
        // Recebe uma posição e devolve o aluno naquela posição.
        if (posicao >= 0 && posicao < tamanho) {
            return alunos[posicao];
        } else {
            throw new IllegalArgumentException("Posição inválida");
        }
    }

    public void remove(int posicao) {
        // Remove o aluno na posição especificada e move os elementos restantes para preencher o espaço.
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < tamanho - 1; i++) {
                alunos[i] = alunos[i + 1];
            }
            alunos[tamanho - 1] = null; // Define o último elemento como null para liberar a referência.
            tamanho--;
        } else {
            throw new IllegalArgumentException("Posição inválida");
        }
    }

    public boolean contem(Aluno aluno) {
        // Descobre se o aluno está ou não na lista.
        for (int i = 0; i < tamanho; i++) {
            if (alunos[i].equals(aluno)) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        // Devolve a quantidade de alunos atualmente no vetor.
        return tamanho;
    }

    @Override
    public String toString() {
        // Retorna uma representação em forma de string do vetor.
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(alunos[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public void insereNaPosicao(Aluno aluno, int posicao) {
        // Insere um aluno em uma posição específica no vetor.
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        // Verifica se o vetor precisa ser redimensionado para acomodar o novo aluno.
        if (tamanho == alunos.length) {
            // Se o vetor estiver cheio, crie um novo vetor com o dobro do tamanho.
            Aluno[] novoVetor = new Aluno[alunos.length * 2];
            // Copie os elementos do vetor antigo para o novo vetor.
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = alunos[i];
            }
            alunos = novoVetor;
        }

        // Desloca os elementos para abrir espaço para o novo aluno.
        for (int i = tamanho; i > posicao; i--) {
            alunos[i] = alunos[i - 1];
        }

        // Insere o novo aluno na posição especificada e atualiza o tamanho.
        alunos[posicao] = aluno;
        tamanho++;
    }

}
