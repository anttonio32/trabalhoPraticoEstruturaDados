package main;
import java.io.*;

public class Livro implements Comparable<Livro>{
    private String titulo;
    private String genero;
    private int numPag;

    public Livro(String titulo, String genero, int numPag) {
        this.titulo = titulo;
        this.genero = genero;
        this.numPag = numPag;
    }

    public Livro() {}

    @Override
    public int compareTo(Livro o) {
        if(this.numPag < o.getNumPag())
            return -1;
        if(this.numPag > o.getNumPag())
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

    // GRAVAR LISTA NO ARQUIVO
    public void grava(Lista<Livro> lista) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("arquivo.txt"));
            for (int i = 0; i < lista.tamanho(); i++) {
                Livro l = lista.posicao(i);
                writer.write(l.getTitulo() + ";" + l.getGenero() + ";" + l.getNumPag());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // LER ARQUIVO
    public Lista<Livro> ler() {
        Lista<Livro> lista = new Lista<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty())//.trim() e um metodo da classe String que remove espacos em branco. Ex:" ". Neste caso o programa ignora listas vazias.
                    continue;//continua execuntando o codigo

                String[] partes = linha.split(";");
                if (partes.length < 3)
                    continue;
                
                String titulo = partes[0];
                String genero = partes[1];

                try {
                    int paginas = Integer.parseInt(partes[2].trim());
                    Livro livro = new Livro(titulo, genero, paginas);
                    lista.add(livro);
                } catch (NumberFormatException e) {
                    System.out.println("Linha ignorada no arquivo: " + linha);
                }
            }
            reader.close();
        } catch (FileNotFoundException  e) {
            System.out.println("Arquivo ainda não existe.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " / Genero: " + genero + " / Paginas:" + numPag + "\n";
    }

}


