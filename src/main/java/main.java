import drawingUI.DrawingUIController;
import shapes.*;

import javax.swing.*;
import java.awt.*;

public class main {

    public static void main(String[] args) {

        DrawingUIController d = new DrawingUIController(); // initialise the UI controller object
        JFrame frame = new JFrame("Shape Drawer");
        frame.setSize(500, 600);
        JPanel panel = d.getMainPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}