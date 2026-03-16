package main;

import java.util.LinkedList;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;

public class Main {

    public static int opcao(){

        int num = Integer.parseInt(JOptionPane.showInputDialog(
                "Para continuar selecione uma opção: \n"
                        + "1. Incluir livro na LISTA\n"
                        + "2. Deletar livro da LISTA\n"
                        + "3. Mostrar LISTA de livros\n"
                        + "4. Inserir lista de livros em uma FILA\n"
                        + "5. Criar PILHAS de livros do mesmo gênero literário\n"
                        + "6. Inserir lista de livros em ARVORE\n"
                        + "7. Salvar Lista.\n"
                        + "0. Sair sem salvar."
        ));

        return num;
    }

    public static int opcaoLivro(){

        int n = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite:\n"
                        + "1. Para Adicionar um Livro\n"
                        + "2. Para sair."
        ));

        return n;
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Seja Bem vindo! Este é o programa de controle dos livros.");

        Livro livroArquivo = new Livro();

        // LÊ O ARQUIVO AO INICIAR
        Lista<Livro> lista = livroArquivo.ler();

        int num = opcao();

        while(num != 0){

            if(num == 1){

                int n = opcaoLivro();

                while(n != 2){

                    if(n == 1){

                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        String genero = JOptionPane.showInputDialog("Digite o gênero do livro:");
                        int numPag = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas:"));

                        Livro livro = new Livro(titulo, genero, numPag);

                        lista.add(livro);

                        n = opcaoLivro();

                    }else{

                        JOptionPane.showMessageDialog(null, "Numero errado, digite novamente!!");

                        n = opcaoLivro();
                    }
                }

                num = opcao();
            }

            else if(num == 2){

                String titulo = JOptionPane.showInputDialog("Digite o titulo do livro que você quer excluir!");

                Livro teste = lista.removeUtimaOco(titulo);

                System.out.println(teste);

                num = opcao();
            }

            else if(num == 3){

                JOptionPane.showMessageDialog(null, lista.toString());

                num = opcao();
            }

            else if(num == 4){

                PriorityQueue<Livro> fila = new PriorityQueue<>();

                for(int i = 0; i < lista.tamanho(); i++){

                    Livro l = lista.posicao(i);

                    fila.add(l);
                }

                String resultado = "";

                while(!fila.isEmpty()){

                    resultado += fila.poll() + "\n";
                }

                JOptionPane.showMessageDialog(null, resultado);

                num = opcao();
            }

            else if(num == 5){

                Lista<Livro> lista1 = new Lista<>();

                for(int i = 0; i < lista.tamanho(); i++){

                    lista1.add(lista.posicao(i));
                }

                Lista<Pilha> pilhas = new Lista<>();

                while(!lista1.vazia()){

                    Livro l = lista1.removeFirst();

                    boolean achou = false;

                    for(int j = 0; j < pilhas.tamanho(); j++){

                        Pilha p = pilhas.posicao(j);

                        if(p.getGenero().equalsIgnoreCase(l.getGenero())){

                            p.insere(l);

                            achou = true;

                            break;
                        }
                    }

                    if(!achou){

                        Pilha nova = new Pilha(l.getGenero());

                        nova.insere(l);

                        pilhas.add(nova);
                    }
                }

                for(int i = 0; i < pilhas.tamanho(); i++){

                    System.out.println(pilhas.posicao(i));
                }

                num = opcao();
            }

            else if(num == 6){

                Arvore arvore = new Arvore();

                LinkedList<Livro> repetidos = new LinkedList<>();

                for (int i = 0; i < lista.tamanho(); i++) {

                    Livro livro = lista.posicao(i);

                    arvore.inserir(livro, repetidos);
                }

                String resultadoArvore = "Árvore EM ORDEM:\n";

                resultadoArvore += arvore.emOrdem();

                resultadoArvore += "\nÁrvore PRÉ ORDEM:\n";

                resultadoArvore += arvore.preOrdem();

                resultadoArvore += "\nLivros repetidos:\n";

                for (Livro livro : repetidos) {

                    resultadoArvore += livro + "\n";
                }

                JOptionPane.showMessageDialog(null, resultadoArvore);

                num = opcao();
            }

            else if (num == 7){

                if(lista.vazia()){

                    JOptionPane.showMessageDialog(null, "Lista vazia!");

                } else {

                    Livro livro = new Livro();

                    livro.grava(lista);

                    JOptionPane.showMessageDialog(null, "Lista salva com sucesso!");
                }

                num = 0;
            }

            else{

                JOptionPane.showMessageDialog(null, "Número não disponível!!");

                num = opcao();
            }
        }

        JOptionPane.showMessageDialog(null, "Fechado!!");
    }
}