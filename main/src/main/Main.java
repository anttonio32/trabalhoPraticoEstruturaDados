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

    public static void main(String[] args) {
        Livro livro = new Livro("Narnia","Aventura",300);
        Lista<Livro> lista = new Lista<Livro>();
        JOptionPane.showMessageDialog(null, "Seja Bem vindo! Este é o programa de controle dos livros.");
        int num = opcao();
        
        while(num != 7){
            if(num == 1){
                System.out.println("1");
                lista.add(livro);
                num = opcao();
            }else if(num == 2){
                System.out.println("2");
                String titulo = JOptionPane.showInputDialog("Digite o titulo do livro que você quer excluir!");
                lista.removeUtimaOco(titulo);
                num = opcao();
            }else if(num == 3){
                System.out.println("3");
                JOptionPane.showMessageDialog(null, "lista.toString()");
                num = opcao();
            }else if(num == 4){
                System.out.println("4");
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
