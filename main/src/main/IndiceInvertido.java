package main;

public class IndiceInvertido {

    private String titulo;
    private int ocorrencias;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(int ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public IndiceInvertido(String titulo, int ocorrencias) {
        this.titulo = titulo;
        this.ocorrencias = ocorrencias;
    }

    @Override
    public String toString() {
        return titulo + " - " + ocorrencias;
    }

}
