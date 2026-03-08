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
        JOptionPane.showMessageDialog(null, "Seja Bem vindo! Este é o programa de controle dos livros.");
        int num = opcao();
        
        if(num == 1){
            System.out.println("1");
        }else if(num == 2){
            System.out.println("2");
        }else if(num == 3){
            System.out.println("3");
        }else if(num == 4){
            System.out.println("4");
        }else if(num == 5){
            System.out.println("5");
        }else if(num == 6){
            System.out.println("6");
        }else{
           System.out.println("7"); 
        }
        
    }
    
}
