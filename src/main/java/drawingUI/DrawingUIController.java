package drawingUI;
import shapes.Drawing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingUIController{


    private JPanel controlsPanel = new JPanel(new GridLayout(3,1));
    private JPanel mainPanel = new JPanel(new GridLayout(2,1));
//    private Color newColour;


    public DrawingUIController(){ //constructor

        Drawing drawing = new Drawing();
        ShapeSelector ssel = new ShapeSelector();
        ColourSelector csel  = new ColourSelector();
        RectSelector rsel = new RectSelector();
        CircleDimsSelector circDims = new CircleDimsSelector();
        SquareSelector squareDims = new SquareSelector();
        count shapeCounter = new count();

        //add a mouse listener to create circle when it is clicked
        drawing.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point click_loc = e.getPoint(); // retrieves the coordinates of the mouse click
                if (ssel.getCurrentShape() == 0){
                    drawing.addCircle(click_loc, csel.getCurrentColour(), circDims.getCurrentRadius());

                    // Increment the stored number of circles in the counter object and change the text on the JPanel
                    shapeCounter.CircleCount++;
                    shapeCounter.circleLabel.setText("Circle Count: " + shapeCounter.CircleCount);
                }

                else if (ssel.getCurrentShape() == 1){
                    drawing.addRect(click_loc, csel.getCurrentColour(), rsel.getCurrentWidth(),
                            rsel.getCurrentHeight());

                    shapeCounter.RectangleCount++;
                    shapeCounter.rectLabel.setText("Rectangle Count: " + shapeCounter.RectangleCount);

                }

                else if (ssel.getCurrentShape() == 2){
                    drawing.addSquare(click_loc, csel.getCurrentColour(),squareDims.getSqrSize() );

                    shapeCounter.SquareCount++;
                    shapeCounter.squareLabel.setText("Square Count: " + shapeCounter.SquareCount);
                }

                drawing.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Color newColour = csel.getCurrentColour();
//                System.out.println(newColour);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // Add colour and shape selector and radius selector etc. to controls panel
        controlsPanel.add(ssel);
        controlsPanel.add(csel);
        controlsPanel.add(rsel);
        controlsPanel.add(circDims);
        controlsPanel.add(squareDims);
        controlsPanel.add(shapeCounter);

        // Add the two panels to the main panel
        mainPanel.add(controlsPanel);// add the controls panel to the main panel
        mainPanel.add(drawing); //add the drawing to the panel

    }
    public JPanel getMainPanel(){
        return mainPanel;
    }

    public class ShapeSelector extends JPanel {
        private JRadioButton bCirc = new JRadioButton("Circle");
        private JRadioButton bRect = new JRadioButton("Rectangle");
        private JRadioButton bSquare = new JRadioButton("Square");

        public ShapeSelector() {
            // Button group object to add all 3 radio buttons to it
            ButtonGroup bg = new ButtonGroup();
            bg.add(bCirc);
            bg.add(bRect);
            bg.add(bSquare);

            // Add each button to each shape selector object which is a Jpanel inherited class
            this.add(bCirc);
            this.add(bRect);
            this.add(bSquare);
        }

        public int getCurrentShape() {
            if (bCirc.isSelected()) { // case to draw circle
                return 0;
            }
            else if (bRect.isSelected()){ // draw rect
                return 1;
            }
            else if (bSquare.isSelected()){
                return 2;
            }
            else{
                return -1;
            }
        }
    }

    public class ColourSelector extends JPanel{
        public Color currentColour;

        public ColourSelector(){
            JButton btn1 = new JButton("Select");
            btn1.setOpaque(true); // set opaque to be able to change the background colour
            currentColour = Color.BLACK;
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color newColour = JColorChooser.showDialog(
                            btn1, "Choose Colour", currentColour);
                    currentColour=newColour;
                    btn1.setBackground(currentColour);

                }
            });
            this.add(btn1);
        }
        public Color getCurrentColour(){
            return currentColour;
        }
    }

    public class CircleDimsSelector extends JPanel{
        JSlider radius = new JSlider(1,100);

        public CircleDimsSelector(){
            JPanel controls = new JPanel(); // create a panel to store all the related components
            controls.setLayout(new GridLayout(2,1));
            JLabel label = new JLabel("Circle Radius:");

            controls.add(label);
            controls.add(radius);
            this.add(controls);
        }

        public int getCurrentRadius(){
            return radius.getValue();

        }

    }
    public class RectSelector extends JPanel {
        JSlider width = new JSlider(1, 100);
        JSlider height = new JSlider(1, 100);

        public RectSelector() {
            JPanel rectControls = new JPanel();
            rectControls.setLayout(new GridLayout(3,1));
            JLabel label = new JLabel("Rectangle Width and Height:");
            rectControls.add(label);
            rectControls.add(width); // add the width slider to the class
            rectControls.add(height); // add the heigh slider to the class
            this.add(rectControls);
        }

        public int getCurrentWidth() {
            return width.getValue();
        }

        public int getCurrentHeight() {
            return height.getValue();
        }
    }

    public class SquareSelector extends JPanel {
        JSlider sqr_size = new JSlider(1, 100);

        public SquareSelector() {
            JPanel squareControl = new JPanel();
            squareControl.setLayout(new GridLayout(2,1));
            JLabel squareLabel = new JLabel("Square Dimensions:");
            squareControl.add(squareLabel);
            squareControl.add(sqr_size);

            this.add(squareControl); // add the square size slider to the class
        }

        public int getSqrSize() {
            return sqr_size.getValue();
        }

    }

    public class count extends JPanel{ // class to keep track of the no. of shapes

        private int SquareCount = 0;
        private int CircleCount = 0;
        private int RectangleCount = 0;
        private final JLabel squareLabel = new JLabel();
        private final JLabel circleLabel = new JLabel();
        private final JLabel rectLabel = new JLabel();

        public count(){
            squareLabel.setText("Square Count: " + SquareCount);
            circleLabel.setText("Circle Count: " + CircleCount);
            rectLabel.setText("Rectangle Count: " + RectangleCount);
            JPanel countPanel = new JPanel();
            countPanel.setLayout(new GridLayout(3,1));

            countPanel.add(squareLabel);
            countPanel.add(circleLabel);
            countPanel.add(rectLabel);
            add(countPanel);
        }

    }
}
