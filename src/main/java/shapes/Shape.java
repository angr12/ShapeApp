package shapes;

import java.awt.*;

public abstract class Shape implements Drawable{
    protected Point pos; //protected keyword allows for access from subclasses
    protected Color col;

    public Shape(Point initPos, Color col) {
        pos = initPos;
        this.col = col;
    }

//    public abstract void draw(Graphics g);
}
