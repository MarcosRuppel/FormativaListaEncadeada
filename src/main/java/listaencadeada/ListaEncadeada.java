package listaencadeada;
import java.util.Scanner;

/**
 *
 * @author andrey, Marcos P Ruppel
 */
public class ListaEncadeada {
    private Node Lista;
    public ListaEncadeada(){
        this.Lista = null;
    }

    //Inserindo elementos
    public void inserir (int informacao){
        //Declarando nosso novo nó
        Node no = new Node();
        
        no.setInformacao(informacao);
        if(Lista == null){
            Lista=no;
        }
        else{
           //Aqui se cria um apontador para a lista.
        Node atual = Lista;
        while(atual.getProximo()!=null){
            atual = atual.getProximo();
        }
        atual.setProximo(no);
        }
    }

    //Removendo elementos
    public void remover(int index) {
        if (Lista == null) {
            System.out.println("Lista vazia! Não há elementos para remover.");
            return;
        }
        // Caso o índice seja 0, remover o primeiro elemento
        if (index == 0) {
            Lista = Lista.getProximo();  // O segundo nó se torna a nova cabeça
            return;
        }

        Node atual = Lista;
        Node anterior = null;

        int contador = 0;
        // Percorrer a lista até encontrar o índice desejado
        while (atual != null && contador < index) {
            anterior = atual;
            atual = atual.getProximo();
            contador++;
        }
        // Verifica se o nó foi encontrado
        if (atual == null) {
            System.out.println("Índice fora dos limites da lista!");
            return;
        }
        // O nó anterior aponta para o próximo do nó atual, removendo o nó atual da lista
        assert anterior != null;
        anterior.setProximo(atual.getProximo());
    }


    
    //Imprimindo elementos 
    public void imprime(){
        Node atual = Lista;
        while (atual != null) {
            System.out.print(atual.getInformacao()+ " -> ");
            atual= atual.getProximo();
        }
        System.out.println("Acabou");
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();
        boolean continuar = true;
        while(continuar){
            System.out.println("Escolha uma opcao: ");
            System.out.println("1 - inserir");
            System.out.println("2 - Excluir");
            System.out.println("0 - Parar");
            int opcao = scanner.nextInt();
            switch(opcao){
                case 0:
                    continuar = false;
                    System.out.println("Lista Final:");
                    lista.imprime();
                    break;
                case 1:
                    System.out.println("Digite os itens da lista (digite '0' para parar):");
                    int item;
                    while (true) {
                        item = scanner.nextInt();
                        if (item == 0) {
                            break;
                        }
                        lista.inserir(item);
                        System.out.println("Lista Atual:");
                        lista.imprime();
                    } break;
                case 2:
                    System.out.println("Informe o indice do node a ser excluido: ");
                    int index = scanner.nextInt();
                    lista.remover(index);
                    System.out.println("Lista Atual:");
                    lista.imprime();
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!");
                    break;
            }
        }
    }
    
}