import shapes.Circle;
import shapes.Rect;
import shapes.Square;
import shapes.Shape;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Drawing extends Canvas {
    // A private field called f of class Frame. This is also in the AWT.
    private JFrame f;

    Point p = new Point(200,200);
    Point p2 = new Point(100, 100);
    Point p3 = new Point(200, 50);
    Color c = new Color(0x992266);// The RGB number comprises three bytes: red, green and blue
    Color ca = new Color(0x121644);
    private Circle c1 = new Circle(p,c,100); //initialise private circle that is passed into paint method
    Shape s = c1;
    private Rect r1 = new Rect(p2,ca,25, 50 );
    Shape s2 = r1;
    private Square s1 = new Square(p3, c, 100);
    Shape s3 = s1;

    private ArrayList<Shape> slist = new ArrayList<Shape>();


    // The constructor
    public Drawing() {
        for (int i = 0; i < 1; i++){

            slist.add(s);
            slist.add(r1);
            slist.add(s1);
        }
        System.out.println(slist);
        setupFrame();
        setupCanvas();

    }

    private void setupCanvas() {
        setBackground(Color.WHITE); // Sets the Canvas background
        setSize(400, 400); // Sets the Canvas size to be the same as the frame
    }

    private void setupFrame() {
        f = new JFrame("My window"); // Instantiates the Frame
        f.add(this); // Adds the Canvas to the Frame
        f.setLayout(null); // Stops the frame from trying to layout contents
        f.setSize(400, 400); // Sets the dimensions of the frame
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {// Closes the program if close window clicked
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }

    public void paint(Graphics g){
        for (int i = 0; i < 3; i++){
            Shape el = slist.get(i);
            el.draw(g);
        }
    }
}