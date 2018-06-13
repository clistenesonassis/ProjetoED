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
import javax.swing.JOptionPane;

/**
 *283
 * @author jpedr
 */
public class Canvas extends java.awt.Canvas{
    
    //ArrayList Principal;
    public ArrayList<Poligono> p = new ArrayList<>();  
    
    //ArrayList para representação da Fila;
    public ArrayList <Poligono> pf = new ArrayList<>();
    
    //Variáveis;
    int i=0, xAux = 150, yAux = 150;
    
    //adiciona um elemento a estrutura;
    public void adicionar(Poligono pon){
        p.add(pon);
    }
    
    /**
     * adiciona um elemento a estrutura;
     * @param pon
     * @return 
     */
    public boolean adicionarLSEnoInicio(Poligono pon){
        
        //caso em que ainda nao existe elementos.
        if(p.isEmpty()){
            p.add(pon);
            return true;
        }else{
            pon.coordX = p.get(0).coordX;
            pon.coordY = p.get(0).coordY;
            
            //adiciona o elemento no inicio;
            p.add(0, pon);
            
            //adiciona todos os elementos em um arraylist auxiliar;
            for(int i = 1; i < p.size(); i++){
                p.get(i).coordX = p.get(i).coordX + 70;
            }
            return true;                
        }
    }
    
    /**
     * Adiciona o elemento no meio da lista.
     * @param pon 
     * @param index 
     */
    public void adicionarLSEnoMeio(Poligono pon, int pos){
        
        //insere o elemento no indice correto.
        pon.coordX = p.get(pos - 1).coordX;
        pon.coordY = p.get(pos - 1).coordY;
        p.add(pos - 1, pon);
        
        //move os elementos para a direita.
        for (int i = pos; i < p.size(); i++) {
            p.get(i).coordX = p.get(i).coordX + 70;
        }
    }
    
    /**
     * adiciona elemento na lista.
     * @param pon 
     */
    public boolean adicionarLSE(Poligono pon, int pos){
        
        //se a lista estiver vazia e o indice for diferente que 1;
        if(p.isEmpty() && pos != 1){
            return false;
        }
        
        //se o indice for igual a 1 adiciona no inicio da lista;
        else if(pos == 1){
            adicionarLSEnoInicio(pon);
            return true;
        }
        
        //se o indice for igual ao tamanho da lista mais um adiciona no final da lista;
        else if(pos == p.size() + 1){
            p.add(pon);
            return true;
        }
        else{
            adicionarLSEnoMeio(pon, pos);
            return true;
        }
        
    }
    
    /**
     * recupera elemento em determinada posição;
     * @param pos
     * @return 
     */
    public Poligono getPoligono(int pos){
        return p.get(pos);
    }    
    
    /**
     * retorna a quantidade de elementos da estrutura;
     * @return 
     */
    public int Tamanho(){
        return p.size();
    }
    
    /**
     * remove o elemento da estrutura;
     * @param indice
     */
    public void remover(int indice){
        if(indice < p.size()){
            p.remove(indice);
        }
    }
    
    /**
     * Remove o Elemento da Fila e Ajeita a distancia entre os elementos.
     * (x = x - 70).
     */
    public void removeNoInicioDaFilaCanvas(){
        
        //remove o primeiro elemento;
        remover(0);
        
        //move todos os elementos;
        for(int i = 0; i < p.size(); i++){
            p.get(i).coordX = p.get(i).coordX - 70;
        }
    }
    
    /**
     * Remove o Elemento no meio da fila.
     */
    public int removerNoMeioDaFilaCanvas(int pos){
        
        //guarda o valor do elemento que será removido.
        int aux = Integer.parseInt(p.get(pos - 1).valor);
        
        //move os elementos para a esquerda.
        for (int i = pos; i < p.size(); i++) {
            p.get(i).coordX = p.get(i).coordX - 70;
        }
        
        //remove o elemento.
        p.remove(pos - 1);
        return aux;
        
    }
    
    
    public int removeLSE(int pos){
        
        if(p.isEmpty()){              //se estiver vazio nao faz nada.
            return -1;
        }
        else if(pos == p.size()){     //remove o ultimo elemento.
            p.remove(pos - 1);
            return -1;
        }
        else if(pos == 1){            //remove o primeiro elemento.
            removeNoInicioDaFilaCanvas();
        }
        else{                         //remove o elemento do indice.
            removerNoMeioDaFilaCanvas(pos);
        }
        
        return -1;
    }
    
    /**
     * remove o primeiro elemento.
     * ESTRUTURA: FILA.
     */
    public void RemoveFilaCanvas(){
        removeNoInicioDaFilaCanvas();
    }
    
    /**
     * visualização em fila;
     * @param pon 
     */
    public void AddRepresentaFila(Poligono pon){
        pf.add(pon);
    }
    
    public void buscaEmLista(int pos, Graphics g){
        p.get(pos - 1).desenharCanvasColor(g, p.get(pos - 1).coordX, p.get(pos - 1).coordY, Color.RED);
        p.get(pos - 1).escreverCanvas(g, p.get(pos - 1).valor, p.get(pos - 1).coordX, p.get(pos - 1).coordY);
    }
    
    
    /**
     * pinta todos os retangulos de representação na tela.
     */
    public void PintaRepresentaFila(Graphics g){
        for(int i = pf.size() - 1; i >= 0; i--){
            
            //desenha o quadrado na tela (funçao desenhaCanvas).
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
    
    /**
     * printa na tela todos os elementos da estrutura Pilha;
     * @param g
     */
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
    
    /**
     * desenhar filas varendo todo o arraylist de poligonos;
     * @param g
     */
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
    
    /**
     * Desenha no Canvas a lista Simplesente Encadeada.
     * @param g 
     */
    public void PintaRepresentaLSE(Graphics g){
        
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
    
    public void paintArvBin(Graphics g){
        
        //passa o parametro para a classe pai;
        super.paint(g);
        
        //vai ler todo o arraylist;
        for(Poligono p : p){
            
            //desenha o circulo na tela;
            p.desenharCirculo(g, p.coordX);
            
            //desenha a seta na tela
            //p.desenharSetas(g, p.coordX, p.coordY + 11);
            
            //escreve o valor armazenado na tela;
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
        }
    }
    
    //printa na tela todos os elementos da estrutura Lista Sequencial;
    public void paintListaSequencial(Graphics g) {
        super.paint(g);
        for(Poligono p : p){
            p.desenharCanvas(g, p.coordX, p.coordY);
            p.escreverCanvas(g, p.valor, p.coordX, p.coordY);
        }
    }

    public int procurarElementoLS(Graphics g, int pos, int tamanho){
        int cont = 0;
        while(true){
            int v = 0;
            for(int j = 0; j < tamanho ;j++){
                try {
                    if(p.get(j).id == pos+cont){
                        v++;
                        cont++;

                    }
                } catch (Exception e) {

                }
                
            }
            if(v  == 0){
                break;
            }
            
        }
        return cont;
        
    }
    
    public void ajustarInserir(Graphics g, int pos, int tamanho, int dif) {
        super.paint(g);
        int cont = 0;
        while(dif != 0){
            for(Poligono p : p){
                if(p.id == pos + cont && dif > 0){
                    
                   p.id = p.id + 1;
                   
                   p.coordX = 70 * ( p.id - 1 );     
                    
                   cont ++;
                   dif--;

                }
            }

        }        
    }
    
    public boolean ajustarRemover(Graphics g, int pos, int tamanho, int dif) {
        super.paint(g);
        int cont = 0;
        while(dif != 0){
            for(Poligono p : p){
                if(p.id == pos + cont && dif > 0){
                    if(cont == 0){
                        p.id = -1;
                        
                    }else{
                        p.id -= 1;
                        p.coordX = 70 * (p.id - 1); 
                        
                    }
                   
                    cont ++;
                    dif--;
                    

                }

            }
        }
            
        
        for(int i = 0; i < tamanho;i++){
            try{
                if(p.get(i).id == -1){
                    remover(i);
                    return true;                    
                }
            }catch(Exception  e){
                    
            }
        }
        
                return false;
        }
    
    
}