package PacoteCanvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author jpedr
 */
public class Circulo extends Poligono {

    private int basePx = 50;
    private int alturaPx = 50;

    public void setBasePx(int base) {
        basePx = base;
    }

    public void setAlturaPx(int altura) {
        alturaPx = altura;
    }

    public void setCoordX(int x) {
        coordX = x;
    }

    public void setCoordY(int y) {
        coordY = y;
    }

    public void setValor(String s) {
        valor = s;
    }

    @Override
    public int[][] centroDoPoligono() {
        int[][] coordCirculo = new int[1][1];
        coordCirculo[0][0] = coordX;
        coordCirculo[0][1] = coordY;
        return coordCirculo;
    }

    @Override
    public String corPoligono() {
        return cor;
    }

    @Override
    public boolean escreverCanvas(Graphics g, String valor, int x, int y) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial Bold", Font.BOLD, 15));
        g.drawString("" + valor, coordX + 18, coordY + 30);
        return false;
    }

    @Override
    public boolean desenharSetas(Graphics g, int x, int y) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desenharCanvas(Graphics g, int a, int b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desenharCirculo(Graphics g, int a) {
        
        g.setColor(Color.BLACK);
        g.drawOval(coordX, coordY, basePx, alturaPx);
        g.setColor(Color.BLACK);
        //g.drawRect(a, a, basePx, alturaPx);
        return true;
    }    

    @Override
    public boolean desenharCanvasColor(Graphics g, int coordX, int coordY, Color RED) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
