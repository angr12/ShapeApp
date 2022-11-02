package shapes;
import java.awt.*;

/**
 * The shapes.Circle class encapsulates the information describing a circle and can draw it in
 * an AWT Graphics object using AWT library methods
 * */
public class Circle extends Shape implements Drawable{
    private int rad; // Fields private Point pos, only this class can access this field;

    public Circle(Point initPos, Color col, int radius){
        super(initPos, col); // The constructor
        rad=radius; // Initialize fields (self.rad = radius in python)
    }

    public void draw(Graphics g) { // A method that draws the object in g
        g.setColor(col);
        g.fillOval(pos.x,pos.y,rad, rad);
    }
}
