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
public class LSE {
    private int conteudo[];
    private int nElementos,inicio;
    
    public LSE(int tamMax){
        nElementos=0;
        conteudo = new int[tamMax];
        inicio=0;
    }
    public void setInicio(int i){
        this.inicio=i;
    }
    public void setnElem(int n){
        this.nElementos=n;
    }
    public int getnElem(){
        return this.nElementos;
    }
    public int getInicio(){
        return this.inicio;
    }
    public int tamanho(){
        return nElementos;
    }
    public boolean vazia(){
        return (nElementos==0);
    }
    public boolean adicionar(int d){
        this.conteudo[nElementos++] = d;
        nElementos++;
        return true;
    }
    public int remover(){
        if(vazia()){
            return -1;
        }else{
            int aux = conteudo[nElementos];
            nElementos--;
            return aux;
        }
    }
    public int getElemento(int d){
        return conteudo[d];
    }
    public int getFim(){
        return nElementos;
    }
    public int consultaElem(){
        return conteudo[inicio];
    }
    public int consultaElemf(){
        return conteudo[nElementos];
    }
    
}