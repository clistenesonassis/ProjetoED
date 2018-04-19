/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteCanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *283
 * @author jpedr
 */
public class Canvas extends java.awt.Canvas{
    
    private ArrayList <Poligono> p = new ArrayList<>();  
    int i=0, xAux = 70, yAux = 70;
    
    //adiciona um elemento a estrutura;
    public void adicionar(Poligono pon){
        p.add(pon);
    }
    /*
    //adiciona um elemento em determinada posição;
    public booblean adicionar(int pos, Poligono pon){
        if()
        
        
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
    */
    //recupera elemento em determinada posição;
    public Poligono getPoligono(int pos){
        return p.get(pos);
    }    
    
    //retorna a quantidade de elementos da estrutura;
    public int Tamanho(){
        return p.size();
    }
    
    //remove o elemento da estrutura;
    public void remover(int indice){
        if(indice < p.size()){
            p.remove(indice);
            i--;    //contador para a seta;
        }
    }
    
    //remove o elemento da estrutura;
    public void removerElem(int pos){
        if(pos < p.size()){
            p.remove(pos);
            for (int i = pos; i < p.size() -1; i++) {
            p.get(pos).coordX = p.get(pos+1).coordX - xAux;
            System.out.println("loopy" + i);
            xAux += 70;
            }
            i--;    //contador para a seta;
        }
    }
    
    //colocar a cor do painel branco;
    public Canvas(){
        this.setBackground(Color.white);
    }
    
    //printa na tela todos os elementos da estrutura Pilha;
    public void paintPilha(Graphics g) {
        super.paint(g);
        for(Poligono p : p){
            p.desenharCanvas(g, p.coordX + 200, p.coordY);
            p.escreverCanvas(g, p.valor, p.coordX + 200, p.coordY);
        }
    }
    
    //printa na tela todos os elementos da estrutura Fila;
    public void paintFila(Graphics g){
        super.paint(g);
        for(Poligono p : p){
            p.desenharCanvas(g, p.coordX, p.coordY);
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
            if(i > 0)
                p.desenharSetas(g, p.coordX, p.coordY + 11);
            i++;
        }
    }     
    //printa na tela todos os elementos da estrutura Lista Simplismente Encadeada;
    void paintLSE(Graphics g) {
        super.paint(g);
        for(Poligono p : p){
            p.desenharCanvas(g, p.coordX, p.coordY);
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
        }
    }
    
    //printa na tela todos os elementos da estrutura Lista Sequencial;
    void paintListaSequencial(Graphics g) {
        super.paint(g);
        for(Poligono p : p){
            p.desenharCanvas(g, p.coordX, p.coordY);
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
            if(i > 0)   //não printar a seta para o primeiro elemento;
                p.desenharSetas(g, p.coordX, p.coordY + 11);
            i++;
            System.out.println("TO AKI RSRS" + i);
        }
    }
    
    //printa na tela todos os elementos da estrutura Lista Sequencial;
    void paintListaSequencial(Graphics g, int indice) {
        super.paint(g);
        for(Poligono p : p){
            p.desenharCanvas(g, p.coordX, p.coordY);
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
            if(i > 0)   //não printar a seta para o primeiro elemento;
                p.desenharSetas(g, p.coordX, p.coordY + 11);
            i++;
            System.out.println("TO AKI RSRS" + i);
        }
    }
    
}