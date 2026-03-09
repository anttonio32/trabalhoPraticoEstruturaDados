package main;

import javax.swing.JOptionPane;

public class Main {
    
    public static int opcao(){
        int num = Integer.parseInt(JOptionPane.showInputDialog("Para continuar selecione uma opção: \n"
            +"1. Incluir livro na LISTA\n" +
            "2. Deletar livro da LISTA\n" +
            "3. Mostrar LISTA de livros\n" +
            "4. Inserir lista de livros em uma FILA\n" +
            "5. Criar PILHAS de livros do mesmo gênero literário\n" +
            "6. Inserir lista de livros em ARVORE\n" +
            "7. Salvar Lista."
        ));
        return num;
    }
    
    public static int opcaoLivro(){
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
                + "1. Para Adicionar um Livro\n"
                + "2. Para Adicionar uma Lista Vazia\n"
                + "3. Para sair."));
        return n;
    }

    public static void main(String[] args) {
        /*Livro livro = new Livro("Narnia","Aventura",300);
        Livro livro2 = new Livro("harry","Aventura",100);
        Livro livro3 = new Livro("Narcos","Aventura",300);
        Livro livro4 = new Livro("Narcos2","Aventura",800);
        Livro livro5 = new Livro("matheus","Aventura",500);*/
        JOptionPane.showMessageDialog(null, "Seja Bem vindo! Este é o programa de controle dos livros.");
        Lista<Livro> lista = new Lista<Livro>();
        int num = opcao();
        
        while(num != 7){
            if(num == 1){
                System.out.println("1");
                int n = opcaoLivro();
                while(n != 3){
                    if(n == 1){
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        String genero = JOptionPane.showInputDialog("Digite o gênero do livro:");
                        int numPag = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas:"));
                        Livro livro = new Livro(titulo, genero, numPag);
                        lista.add(livro);
                        n =opcaoLivro();
                    }else if(n == 2){
                        Lista<Livro> lista2 = new Lista<Livro>();
                        n=opcaoLivro();
                    }else{
                        JOptionPane.showMessageDialog(null, "Numero errado, digite novamente!!");
                        n=opcaoLivro();
                    }
                }
                num = opcao();
            }else if(num == 2){
                System.out.println("2");
                String titulo = JOptionPane.showInputDialog("Digite o titulo do livro que você quer excluir!");
                Livro teste = lista.removeUtimaOco(titulo);
                System.out.println(teste);
                num = opcao();
            }else if(num == 3){
                System.out.println("3");
                JOptionPane.showMessageDialog(null, lista.toString());
                num = opcao();
            }else if(num == 4){
                System.out.println("4");
                Fila<Livro> f1 =new Fila<Livro>();
                f1.imprimirFila();
                num = opcao();
            }else if(num == 5){
                System.out.println("5");
                num = opcao();
            }else if(num == 6){
                System.out.println("6");
                num = opcao();
            }else{
                JOptionPane.showMessageDialog(null, "Número não disponível!!");
                num = opcao();
            }
        }
        JOptionPane.showMessageDialog(null, "Lista salva com sucesso!");
    }
    
}
