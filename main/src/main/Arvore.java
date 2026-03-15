package main;

import java.util.LinkedList;

public class Arvore {

    // objeto Livro armazenado no nó da árvore
    Livro livro;

    // referência para o filho da esquerda
    Arvore esquerda;

    // referência para o filho da direita
    Arvore direita;

    // método responsável por inserir um livro na árvore
    public boolean inserir(Livro novo, LinkedList<Livro> repetidos) {

        // se o nó atual estiver vazio
        if (livro == null) {

            // o novo livro passa a ocupar esse nó
            livro = novo;

            // retorna true indicando que inseriu
            return true;
        }

        // verifica se o título já existe na árvore
        if (novo.getTitulo().equalsIgnoreCase(livro.getTitulo())) {

            // adiciona o livro na lista de repetidos
            repetidos.add(novo);

            // retorna false pois não foi inserido na árvore
            return false;
        }

        // usa o compareTo da classe Livro
        // para comparar o número de páginas
        if (novo.compareTo(livro) < 0) {

            // se for menor, vai para o lado esquerdo da árvore

            if (esquerda == null) {

                // se não existir nó à esquerda
                // cria um novo nó
                esquerda = new Arvore();
            }

            // chama recursivamente o método inserir
            return esquerda.inserir(novo, repetidos);

        } else {

            // se for maior ou igual vai para direita

            if (direita == null) {

                // cria novo nó à direita
                direita = new Arvore();
            }

            // chamada recursiva para inserir no lado direito
            return direita.inserir(novo, repetidos);
        }
    }

    // método que percorre a árvore em ordem
    public String emOrdem() {

        // variável que armazenará o resultado
        String resultado = "";

        // primeiro percorre a subárvore esquerda
        if (esquerda != null) {
            resultado += esquerda.emOrdem();
        }

        // depois mostra o nó atual
        resultado += livro + "\n";

        // depois percorre a subárvore direita
        if (direita != null) {
            resultado += direita.emOrdem();
        }

        // retorna o resultado
        return resultado;
    }

    // método que percorre a árvore em pré-ordem
    public String preOrdem() {

        // primeiro mostra o nó atual
        String resultado = livro + "\n";

        // depois percorre a esquerda
        if (esquerda != null) {
            resultado += esquerda.preOrdem();
        }

        // depois percorre a direita
        if (direita != null) {
            resultado += direita.preOrdem();
        }

        // retorna o resultado
        return resultado;
    }
    
}
