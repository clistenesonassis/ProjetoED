/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteCanvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *283
 * @author jpedr
 */
public class Canvas extends java.awt.Canvas{
    
    //ArrayList Principal;
    private ArrayList <Poligono> p = new ArrayList<>();  
    
    //ArrayList para representação da Fila;
    private ArrayList <Poligono> pf = new ArrayList<>();
    
    //Variáveis;
    int i=0, xAux = 150, yAux = 150;
    
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
    
    //remove FIlA:.
    /**
     * Ajeita a fila do canvas voltando a distancia entre os elementos;
     * x = x - 70;
     */
    public void RemoveFilaCanvas(){
        for(int i = 0; i < p.size(); i++){
            p.get(i).coordX = p.get(i).coordX - 70;
        }
    }
    
    /**
     * visualização em fila;     * 
     */
    public void AddRepresentaFila(Poligono pon){
        pf.add(pon);
    }
    
    /**
     * pinta todos os retangulos de representação na tela;
     */
    public void PintaRepresentaFila(Graphics g){
        for(int i = pf.size() - 1; i >= 0; i--){
            
            //desenha o quadrado na tela (funçao desenhaCanvas);
            g.setColor(Color.RED);
            g.fillRect(xAux, yAux, 100, 100);
            xAux -= 10;
            yAux += 10;
            //escreve na tela; (desenha valor);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial Bold", Font.BOLD, 15));
            g.drawString("" + pf.get(i).valor, pf.get(i).coordX , pf.get(i).coordY);
            
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