package main;
import java.util.LinkedList;

public class Fila<T extends Comparable>{
    private LinkedList<T> fila;

    public Fila() {this.fila = new LinkedList<T>();}
    
    public void addOrdemPrioridade(T outro){
        for(int i = 0;i < fila.size(); i++){
            if (outro.compareTo(fila.get(i)) == -1){
                fila.add(i,outro);
            }else if(outro.compareTo(fila.get(i)) == 1){
                fila.addLast(outro);
            }else {
                fila.addLast(outro);
            }
        }
    }
    
    public void imprimirFila() {
        for (T item : fila) {
            System.out.println(item);
        }
    }
}
