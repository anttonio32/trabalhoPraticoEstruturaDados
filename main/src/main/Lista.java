package main;
import java.util.LinkedList;

public class Lista<T> {
    private LinkedList<T> lista;

    public Lista() {this.lista = new LinkedList<T>();}
    
    public void add(T t){
        this.lista.add(t);
    }
    public boolean removeUtimaOco(String t){
        return this.lista.removeLastOccurrence(t);
    }
    @Override
    public String toString(){
       return this.lista.toString();
    }
}
