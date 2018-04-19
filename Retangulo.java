package PacoteCanvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author jpedr
 */
public class Retangulo extends Poligono {

    private final int basePx = 50;
    private final int alturaPx = 25;

    @Override
    public boolean desenharCanvas(Graphics g, int a, int b) {
        g.setColor(Color.BLACK);
        g.drawRect(a, b, basePx, alturaPx);
        //g.fillRect(a, b, basePx, alturaPx);
        return true;
    }

    @Override
    public int[][] centroDoPoligono() {
        int[][] coordQuadrado = new int[1][1];
        coordQuadrado[0][0] = coordX;
        coordQuadrado[0][1] = coordY;
        return coordQuadrado;
    }

    @Override
    public String corPoligono() {
        return cor;
    }

    @Override
    public boolean escreverCanvas(Graphics g, String valor, int x, int y) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial Bold", Font.BOLD, 15));
        g.drawString("" + valor, x + 8, y + 18);
        return false;
    }

    @Override
    public boolean desenharSetas(Graphics g, int x, int y) {
        Polygon p = new Polygon();
        p.addPoint(x - 10, y - 8);
        p.addPoint(x, y);
        p.addPoint(x - 10, y + 8);
        g.drawLine(x - 10, y, x - 20, y);
        g.fillPolygon(p);
        return false;
    }
}
