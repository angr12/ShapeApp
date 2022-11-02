package shapes;

import java.util.ArrayList;
import java.awt.*;

public class ShapeDB {
    private ArrayList<Shape> slist = new ArrayList<Shape>();

    protected void addRect(Point p, Color c, int width, int height){
        Rect rect1 = new Rect(p,c,width,height);
        slist.add(rect1);
//        System.out.println(slist);
    }

    protected void addSquare(Point p, Color c, int len){
        Square s1 = new Square(p,c,len);
        slist.add(s1);
//        System.out.println(slist);
    }

    protected void addCircle(Point p, Color c, int rad){
        Circle c1 = new Circle(p,c,rad);
        slist.add(c1);
//        System.out.println(slist);
    }

    protected void drawShapes(Graphics g){
        for (int i = 0; i < slist.size(); i++) {
            Shape toDraw = slist.get(i);
            toDraw.draw(g);
        }
    }
}
