
package PacoteCanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author jpedr
 */

public class Seta extends Poligono {

    private Point v1, v2, v3;

    public boolean desenharCanvas(Graphics g, int x, int y) {
        Polygon p = new Polygon();
        p.addPoint(x - 10, y - 8);
        p.addPoint(x, y);
        p.addPoint(x - 10, y + 8);
        g.drawLine(x - 10, y, x - 20, y);
        g.fillPolygon(p);
        return false;
    }

    @Override
    public int[][] centroDoPoligono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String corPoligono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean escreverCanvas(Graphics g, String valor, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desenharSetas(Graphics g, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desenharCirculo(Graphics g, int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desenharCanvasColor(Graphics g, int coordX, int coordY, Color RED) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}