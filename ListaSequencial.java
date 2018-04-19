/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author ller
 */
public class ListaSequencial {	
    private int dados[];
    private int tamAtual;
    private int tamMax;
    private int i = 0;
    
    public int getcontador(){
        return i;
    }
    
    //metodo construtor;
    public ListaSequencial(int tam){
        tamMax = tam;
        tamAtual = 0;
        dados = new int[tamMax];        
    }
    
    //retorna se a lista está vazia;
    public boolean vazia(){     
        if(tamAtual == 0) return true;
        else return false;
    }
    
    //retorna se a lista está cheia;
    public boolean cheia(){     
        return tamAtual == tamMax;        
    }
    
    //retorna tamanho da lista;
    public int tamanho(){   
        return tamAtual;
    }
    
    //retorna o elemento que pertence a determinada posição;
    public int elemento(int pos)   {      
        int dado;
        
        if( (pos > tamAtual) || (pos <= 0) ){      
            return -1;
        }
        dado = dados[pos -1];
        return dado;        
    }
    //retorna a posição onde o determinado dado se encontra;
    public int posicao(int dado){       
        
        for (int i = 0; i < tamAtual; i++) {
            if(dados[i] == dado){
                return  (i + 1);
            }
        }
        
        return -1;
    }
    //insere um elemento em uma determinada posição;
    public boolean insere(int pos, int dado){
        if( cheia() || (pos <= 0) || (pos > (tamAtual + 1) ) ){
            return false;
        }
        
        for (int i = tamAtual; i >= pos ; i--) {
            dados[i] = dados[i -1];
        }
        
        dados[pos -1] = dado;
        tamAtual++;
        return true;        
    }
    
    //insere um elemento no final;
    public boolean insereFinal(int dado){
        if( cheia() ){
            return false;
        }else{
            dados[tamAtual] = dado;
            tamAtual++;
            System.out.println("tam = " + tamAtual);
            return true;
        }      
    }
    
    //remove o elemento que se encontra em determinada posição;
    public int remove(int pos){
        int dado;
        System.out.println("removeloko");
        if ((pos > tamAtual) || (pos < 1) ) {
            return -1;
        }
        dado = dados[pos-1];
        for (int i = (pos -1); i < tamAtual -1; i++) {
            dados[i] = dados[i+1];
            System.out.println("loopy" + i);
        }
        tamAtual--;
        System.out.println("saiu");
        return dado;
    }
    
    public void ordenar(){
        int valor;
        for(int i = 0; i < tamAtual; i++){
            
            for (int j = (i + 1); j < tamAtual; j++) {
                
                if (dados[i] > dados[j]) {
                    insere(i+2, dados[i]);
                    valor = remove(j+1);
                    insere(i+1, valor);
                }
            }
        }
    }

}