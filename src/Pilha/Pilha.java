package Pilha;

public class Pilha {
   
    private int conteudo[];
    private int topo;
    private int tamMax = 0;
    
    public void setTopo(int valor){
        topo = valor;
    }
    
    public int getTopo(){
        return topo;
    }
    
    public void setTamMax(int valor){
        tamMax = valor;
    }
    
    public int getTamMax(){
        return tamMax;
    }
    
    
    //instancia a pilha; construtor;
    public Pilha(int tam){
        tamMax = tam;
        conteudo = new int[tamMax];
        topo = -1;
    }
    
    //verifica se a pilha está vazia;
    public boolean vazio(){
        return topo == -1;
    }
    
    //verificar se a pilha está cheia;
    public boolean cheia(){
        return topo == (tamMax - 1);
    }
    
    //obter o tamanho da pilha;
    public int tamanhoPilha(){
        return topo + 1;
    }
    //consultar elemento do topo;
    public String consultaElem(){
        if(topo == -1)
            return null;
        else
            return String.valueOf( conteudo[topo] );
    }
    
    //inserir um novo elemento no topo da lista;
    public boolean insereElem(int elemento){
        if(cheia()){       //se a pilha estiver cheia;
            return false;
        }
        else{
            conteudo[++topo] = elemento;    //insere elemento;
            return true;
        }
    }
    
    //remover elemento;
    public int removeElem(){
        if(vazio()) //se a pilha estiver vazio será lançado uma excessão;
            return -1;
        else
            return conteudo[topo--];    //remove o elemento do topo;
    }    
}