package shapes;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Drawing extends Canvas {
    // A private field called f of class Frame. This is also in the AWT.
    private JFrame f;
    private ShapeDB db = new ShapeDB();
    Point p = new Point(200,200);
    Point p2 = new Point(100, 100);
    Point p3 = new Point(200, 50);
    Color c = new Color(0x992266);// The RGB number comprises three bytes: red, green and blue
    Color ca = new Color(0x102607);


    public void addCircle(Point p, Color c, int rad){
        db.addCircle(p, c, rad);
    }

    public void addRect(Point initpos, Color col, int width, int height){
        db.addRect(initpos, col, width, height);
    }

    public void addSquare(Point initpos, Color col, int x){
        db.addSquare(initpos, col, x);
    }

    public void paint(Graphics g){ // draws all shapes in the database
        db.drawShapes(g);
    }
}