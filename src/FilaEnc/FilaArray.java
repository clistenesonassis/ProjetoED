package FilaEnc;

/**
 *
 * @author aluno
 */
public class FilaArray {
       
    private int conteudo[];
    private int inicio, aux = inicio;
    private int fim, nElementos, cu = 0;

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getFim() {
        return fim;
    }
    
    public void setInicio(int valor){
        inicio = valor;
    }
    
    public int getInicio(){
        return inicio;
    }

    //instancia a fila; construtor;
    public FilaArray(){
        int tam = 9999;
        conteudo = new int[tam];
        fim = -1;
    }
    
    //verifica se a fila está vazia;
    public boolean vazio(){
        if(nElementos == 0)
            return true;
        else
            return false;
    }
    
    //obter o tamanho da fila;
    public int tamanhoFila(){
        return nElementos;
    }
    //consultar elemento do topo;
    public int consultaElem(){
        return conteudo[fim];
    }
    
    public int consultarElem(){
        return conteudo[aux];
    }
    
    //inserir um novo elemento no topo da lista;
    public boolean insereElem(int elemento){
        
            conteudo[++fim] = elemento;    //insere elemento;
            nElementos++;
            return true;        
    }
    
    //remover elemento;
    public int removeElem(){
        if(vazio()) //se a fila estiver vazio será lançado uma excessão;
            return -1;
        else
            nElementos--;
            aux++;
            return conteudo[cu++];    //remove o elemento do inicio;
    }  
}