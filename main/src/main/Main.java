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
                // passar por toda a lista 
                Livro atual = null;
                int j = 0;
                for(int i = 0;i <= lista.tamanho();i++){
                    atual = lista.remove();  //remove item da lista
                    if(f1.vazia()) {
                        f1.addFim(atual);
                    }
                    
                    if(atual.getNumPag() < f1.pega(i).getNumPag()){
                        f1.addInicio(i,atual);
                    }
                    if (atual.getNumPag() > f1.pega(i).getNumPag()){
                        f1.addInicio(i+1,atual);
                    }else if(atual.getNumPag() == f1.pega(i).getNumPag()){
                        f1.addFim(atual);
                    }

                }
                System.out.println(f1.toString());
                num = opcao();
                
            }else if(num == 5){
                
                System.out.println("5");
                
                Lista<Livro>  fila =  new Lista<Livro>();
                 
                // percorre os livros que estão na lista principal
                // O "i" começa em 0 e vai até o tamanho da lista
                // Em cada repetição pegamos um livro da lista e colocamos na fila
                // depois processa e separar por gênero
                for(int i = 0; i < lista.tamanho(); i++){
                    fila.add((Livro)lista.posicao(i));
                }
                Lista<Pilha> pilhas = new Lista<Pilha>();
                
// enquanto a fila n estiver vazia, o programa continua executando
// A cada repetição, remove o primeiro da fila pra analisar
// pega cada livro e verificar se já existe uma pilha
// Se existir, o livro é inserido na pilha.
// se nao cria uma nova pilha 
                
                        while(!fila.vazia()){
                    Livro l = fila.removeFirst();
                    boolean achou = false;  // achou é pra verificar se encontrou a pilha do genero procurado
                
                    //esse for vai procurar a pilha do mesmo genero do livro que foi analisado no while,   
                    //se nao achar ele cria uma nova pilha com o nome do genero
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
                        //esse aq so vai imprimir as pilhas de todos generos 
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
