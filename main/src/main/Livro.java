package main;

public class Livro{
    private String titulo;
    private String genero;
    private int numPag;

    public Livro(String titulo, String genero, int numPag) {
        this.titulo = titulo;
        this.genero = genero;
        this.numPag = numPag;
    }

    public Livro() {}
    
    
    
    public int compare(Livro outro){
        if(this.numPag < outro.getNumPag())
            return -1;
        if(this.numPag > outro.getNumPag())
            return 1;
        return 0;  
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public String toString() {
        return "Livro: titulo=" + titulo + ", genero=" + genero + ", numPag=" + numPag + '.';
    }
    
    
}
