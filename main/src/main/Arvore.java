package main;

import java.util.LinkedList;

public class Arvore {
    private Livro livro;
    private Arvore esquerda;
    private Arvore direita;

    public boolean inserir(Livro novo, LinkedList<Livro> repetidos) {
        if (this.livro == null) {
            this.livro = novo;
            return true;
        }
        
        if (novo.getTitulo().equalsIgnoreCase(this.livro.getTitulo())) {
            repetidos.add(novo);
            return false;
        }

        if (novo.compareTo(this.livro) < 0) {
            if (this.esquerda == null) {
                this.esquerda = new Arvore();
            }
            return this.esquerda.inserir(novo, repetidos);
        }else{
            if(this.direita == null) {
                this.direita = new Arvore();
            }
            return this.direita.inserir(novo, repetidos);
        }
    }

    public String emOrdem() {
        String resultado = "";
        if (this.esquerda != null) {
            resultado += this.esquerda.emOrdem();
        }
        resultado += this.livro + "\n";
        if (this.direita != null) {
            resultado += this.direita.emOrdem();
        }
        return resultado;
    }
    
    public String preOrdem() {
        String resultado = this.livro + "\n";
        if (this.esquerda != null) {
            resultado += this.esquerda.preOrdem();
        }
        if (this.direita != null) {
            resultado += this.direita.preOrdem();
        }
        return resultado;
    }
    
}
