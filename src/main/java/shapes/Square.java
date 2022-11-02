package shapes;

import java.awt.*;

public class Square extends Rect{

    public Square(Point initpos, Color col, int x){
        super(initpos, col, x, x); // set the width and height of the rect class to the same int to create a square
    }
}
