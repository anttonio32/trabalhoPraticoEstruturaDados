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
    
    @Override
    public String toString() {
        return this.fila.toString();
    }
    
    public T pega(int i){
        return this.fila.get(i);
    }
    
    public boolean vazia(){
        return this.fila.isEmpty();
    }
}
