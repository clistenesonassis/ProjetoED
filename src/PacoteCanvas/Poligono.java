package PacoteCanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author clistenes
 */
public abstract class Poligono extends JPanel implements Serializable{

    protected int coordX;
    protected int coordY;
    protected String valor;
    protected String cor;

    public abstract int[][] centroDoPoligono();
    
    public abstract String corPoligono();
    
    public abstract boolean desenharCanvas(Graphics g, int a, int b);

    public abstract boolean escreverCanvas(Graphics g, String valor, int x, int y);
    
    public abstract boolean desenharSetas(Graphics g, int x, int y);
    
    public abstract boolean desenharCirculo(Graphics g, int x);

    public abstract boolean desenharCanvasColor(Graphics g, int coordX, int coordY, Color RED);
}
