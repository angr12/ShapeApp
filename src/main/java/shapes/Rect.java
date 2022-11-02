package shapes;

import java.awt.*;

public class Rect extends Shape implements Drawable{

    protected int w;
    protected int h;

    public Rect(Point initpos, Color col, int width, int height){ //constructor
        super(initpos, col);
        h = height;
        w = width;
    }


    public void draw(Graphics g){
        g.setColor(col);
        g.fillRect(pos.x, pos.y, w, h);
    }


}
