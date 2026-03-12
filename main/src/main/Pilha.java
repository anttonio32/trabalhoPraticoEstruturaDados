
package main;
import java.util.Stack;
public class Pilha {
    private String genero;
    private Stack <Livro>pilha;

    public Pilha(String genero) {
        this.genero = genero;
        this.pilha = new Stack<>();
    }
    
    public void insere(Livro l){
        pilha.push(l);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Genero: " + genero + "\nLivros: " + pilha + "\n" ;
    }
    
    
}