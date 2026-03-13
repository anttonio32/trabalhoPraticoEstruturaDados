package main;
import java.util.LinkedList;

public class Lista<T>{
    private LinkedList<T> lista;

    public Lista() {this.lista = new LinkedList<T>();}
    
    public void add(T t){
        this.lista.add(t);
    }
    public void addPos(int i, T t){
        this.lista.add(i, t);
    }
    public T removeUtimaOco(String t){
        for (int i = lista.size() -1; i >= 0; i--) {//executa do final da lista
            Livro livro = (Livro) lista.get(i); //forca o objeto da lista a ser um livro
            if(livro.getTitulo().equalsIgnoreCase(t)){
                return lista.remove(i);
            }
        }
        return null;
    }
    
    public T removeFirst(){
        return this.lista.removeFirst();
    }
    
    public T remove(){
        return this.lista.remove();
    }
    
    public T posicao(int i){
        return this.lista.get(i);
    }
    
    public boolean vazia(){
        return this.lista.isEmpty();
    }
    
    public int tamanho(){
        return this.lista.size()-1;
    }
    
    @Override
    public String toString(){
       return this.lista.toString();
    }
}


