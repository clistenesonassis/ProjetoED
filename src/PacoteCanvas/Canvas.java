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
        }
    }
    
    //colocar a cor do painel branco;
    public Canvas(){
        this.setBackground(Color.white);
    }
    
    //printa na tela todos os elementos da estrutura Pilha;
    public void paintPilha(Graphics g) {
        
        //passa o parametro para a classe pai;
        super.paint(g);
        
        //vai ler todo o arraylist;
        for(Poligono p : p){
            
            //desenha o retangulo na tela;
            p.desenharCanvas(g, p.coordX, p.coordY);
            
            //escreve o valor armazenado na tela;
            p.escreverCanvas(g, p.valor, p.coordX + 25, p.coordY + 12);
            
        }
    }
    
    //desenhar filas varendo todo o arraylist de poligonos;
    public void paintFila(Graphics g){
        
        //passa o parametro para a classe pai;
        super.paint(g);
        
        //vai ler todo o arraylist;
        for(Poligono p : p){
            
            //desenha o retangulo na tela;
            p.desenharCanvas(g, p.coordX, p.coordY);
            
            //desenha a seta na tela
            p.desenharSetas(g, p.coordX, p.coordY + 11);
            
            //escreve o valor armazenado na tela;
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
        }
    }     
}