import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

public class ExGUIAWT_01 extends Frame {

    protected Point center = new Point(200, 100);
    protected int r = 100;
    protected Canvas cvs;

    protected final class ExGUIAWT_CVS extends Canvas {

        // paint this canvas
        @Override
        public void paint(final Graphics g) {
            g.clearRect(0, 0, 400, 200);

            g.setColor(Color.blue);
            g.drawRect(10,0, 400-20,200);

            g.setColor(Color.red);
            g.drawOval(center.x - r, center.y - r, r * 2, r * 2);

            g.setColor(Color.black);
            g.drawString("The circle:", 140, 90);
            g.drawString(String.format("center = (%d,%d);", center.x, center.y), 160, 110);
            g.drawString("radius = " + r, 160, 130);
        }

    }

    public ExGUIAWT_01(String title) {
        super(title);
        
        System.out.println("Default layout manager of Frame: " + getLayout());
        cvs = new ExGUIAWT_CVS();
        add(cvs, BorderLayout.CENTER); // add canvas to paint with BorderLayout.CENTER
        setSize(400, 300);
    }

    public static void main(String[] args) {
        new ExGUIAWT_01("s1282012 Ex#1: Step 1").setVisible(true);
    }
}
