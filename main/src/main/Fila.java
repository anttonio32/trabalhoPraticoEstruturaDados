package main;
import java.util.LinkedList;

public class Fila<T>{
    private LinkedList<T> fila;

    public Fila() {this.fila = new LinkedList<T>();}
    
    //pode utilizar a quick
    public void addFim(T outro){
        this.fila.addLast(outro);
    }
    
    public void addInicio(int i ,T outro){
        this.fila.add(i,outro);
    }
    public void inserirOrdenado(Livro livro){
        if(fila.isEmpty()){
        fila.add((T) livro);
        return;
        }
        
        int i = 0;
        while(i < this.fila.size() && ((Livro)this.fila.get(i)).getNumPag() <= livro.getNumPag()){
            i++;
        }
        this.fila.add(i, (T) livro);
    }
    
    @Override
    public String toString() {
        return this.fila.toString();
    }
    
    public T pega(int i){
        return this.fila.get(i);
    }
    public int tamanho(){
        return this.fila.size();
    }
    
    public boolean vazia(){
        return this.fila.isEmpty();
    }
}
