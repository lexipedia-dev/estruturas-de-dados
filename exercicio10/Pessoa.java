import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + "-" + idade;
    }
}

class ListaDuplamenteEncadeada {
    private Pessoa pessoa;
    private ListaDuplamenteEncadeada proximo;
    private ListaDuplamenteEncadeada anterior;

    public ListaDuplamenteEncadeada(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.proximo = null;
        this.anterior = null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public ListaDuplamenteEncadeada getProximo() {
        return proximo;
    }

    public void setProximo(ListaDuplamenteEncadeada proximo) {
        this.proximo = proximo;
    }

    public ListaDuplamenteEncadeada getAnterior() {
        return anterior;
    }

    public void setAnterior(ListaDuplamenteEncadeada anterior) {
        this.anterior = anterior;
    }
}

 class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar vetores de listas para cada letra do alfabeto
        ListaDuplamenteEncadeada[] listas = new ListaDuplamenteEncadeada[26];
        for (int i = 0; i < listas.length; i++) {
            listas[i] = null;
        }

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir nova pessoa");
            System.out.println("2. Imprimir lista de uma letra");
            System.out.println("3. Consultar idade de uma pessoa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o nome da pessoa: ");
                String nome = scanner.next();
                System.out.print("Digite a idade da pessoa: ");
                int idade = scanner.nextInt();

                Pessoa novaPessoa = new Pessoa(nome, idade);

                // Encontrar a letra inicial do nome
                char primeiraLetra = Character.toUpperCase(nome.charAt(0));
                int indice = primeiraLetra - 'A';

                // Inserir a pessoa na lista correspondente
                ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada(novaPessoa);
                if (listas[indice] == null) {
                    listas[indice] = novaLista;
                } else {
                    ListaDuplamenteEncadeada atual = listas[indice];
                    while (atual.getProximo() != null) {
                        atual = atual.getProximo();
                    }
                    atual.setProximo(novaLista);
                    novaLista.setAnterior(atual);
                }

                System.out.println("Pessoa inserida com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Digite a letra inicial (A-Z): ");
                char letra = scanner.next().charAt(0);
                int indice = letra - 'A';

                if (indice >= 0 && indice < 26 && listas[indice] != null) {
                    ListaDuplamenteEncadeada atual = listas[indice];
                    System.out.println("Lista de pessoas com a letra " + letra + ":");
                    while (atual != null) {
                        System.out.println(atual.getPessoa());
                        atual = atual.getProximo();
                    }
                } else {
                    System.out.println("Lista vazia ou letra inválida.");
                }
            } else if (opcao == 3) {
                System.out.print("Digite o nome da pessoa para consultar a idade: ");
                String nome = scanner.next();

                // Encontrar a letra inicial do nome
                char primeiraLetra = Character.toUpperCase(nome.charAt(0));
                int indice = primeiraLetra - 'A';

                if (indice >= 0 && indice < 26 && listas[indice] != null) {
                    ListaDuplamenteEncadeada atual = listas[indice];
                    while (atual != null) {
                        if (atual.getPessoa().getNome().equalsIgnoreCase(nome)) {
                            System.out.println("Idade de " + nome + ": " + atual.getPessoa().getIdade());
                            break;
                        }
                        atual = atual.getProximo();
                    }
                    if (atual == null) {
                        System.out.println("Pessoa não encontrada.");
                    }
                } else {
                    System.out.println("Lista vazia ou letra inválida.");
                }
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
