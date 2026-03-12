package main;
import java.util.LinkedList;

public class Fila<T>{
    private LinkedList<T> fila;

    public Fila() {this.fila = new LinkedList<T>();}
    
    //pode utilizar a quick
    public void addOrdemPrioridade(T outro){
        this.fila.add(outro);
    }
    
    @Override
    public String toString() {
        return this.fila.toString();
    }
    
    public T pega(int i){
        return this.fila.get(i);
    }
}
