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
                + "2. Para sair."));
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
                while(n != 2){
                    if(n == 1){
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        String genero = JOptionPane.showInputDialog("Digite o gênero do livro:");
                        int numPag = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas:"));
                        Livro livro = new Livro(titulo, genero, numPag);
                        lista.add(livro);
                        n =opcaoLivro();
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
                /*
                // passar por toda a lista 
                int tamanhoInicial = lista.tamanho();  //guardar tamnaho pois vai remover itens dentro do for
                for(int i=0; i<tamanhoInicial; i++){


                    Livro atual = lista.remove();  //remove item da pilha
                    boolean inseriu = false;       // Falg para ver se consegui inserir em uma pilha já existente

                    //passar na lista de pilhas
                    for(int j=0; j<lista.tamanho(); j++){

                        Pilha<Produto> pilhaAtual = lista.get(j);  //pega pilha da lista
                        Produto ProdDaPilha = pilhaAtual.olha();   //pega produto da pilha

                        //produto é desse bairro
                        if(ProdDaPilha.getBairro().equalsIgnoreCase(atual.getBairro())){
                            pilhaAtual.insere(atual);   //Insere na pilha
                            inseriu = true;             //Marca que já inseriu
                            break;
                        }
                    }

                    // nao achou pilha para o bairro
                    if(!inseriu){
                        Pilha<Produto> pilhaNova = new Pilha<Produto>();  //Cria nova pilha
                        pilhaNova.insere(atual);     // Insere o produto
                        lista.add(pilhaNova);        // add na lista de pilhas
                    }
                }*/
                num = opcao();
                
            }else if(num == 5){
                
                System.out.println("5");
                
                Lista<Livro>  fila =  new Lista<Livro>();
                 
                // tive que criar tamanho em lista
                for(int i = 0; i < lista.tamanho(); i++){
                    fila.add((Livro)lista.posicao(i));
                }
                Lista<Pilha> pilhas = new Lista<Pilha>();
                
                while(!fila.vazia()){
                    Livro l = fila.removeFirst();
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
                for(int i = 0; i <pilhas.tamanho(); i++){
                    System.out.println(pilhas.posicao(i));
                }
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
