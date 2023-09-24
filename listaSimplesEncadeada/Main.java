package listaSimplesEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples lista = new ListaEncadeadaSimples();

        // Inserindo elementos no início da lista
        lista.insereNoInicio("Elemento 1");
        lista.insereNoInicio("Elemento 2");
        lista.insereNoInicio("Elemento 3");

        // Inserindo elementos no fim da lista
        lista.insereNoFim("Elemento 4");
        lista.insereNoFim("Elemento 5");

        // Inserindo elementos em posições específicas
        lista.insereNaPosicao("Elemento X", 2);
        lista.insereNaPosicao("Elemento Y", 4);

        // Imprimindo a lista
        System.out.println("Lista encadeada:");
        lista.imprimeLista();

        // Removendo elementos
        lista.removeDoInicio();
        lista.removeDoFim();
        lista.removeNaPosicao(2);

        // Imprimindo a lista após as remoções
        System.out.println("\nLista após remoções:");
        lista.imprimeLista();

        // Verificando tamanho e se a lista está vazia
        System.out.println("\nTamanho da lista: " + lista.tamanho());
        System.out.println("A lista está vazia? " + lista.vazia());
    }
}
