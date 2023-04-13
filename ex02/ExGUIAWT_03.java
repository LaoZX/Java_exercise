import java.awt.event.*;
import java.awt.*;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener{
    public ExGUIAWT_03(String title){
        super(title);
        cvs.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        center.setLocation(me.getX(), me.getY());
        cvs.repaint();
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    
    public static void main(String[] args) {
        new ExGUIAWT_03("s1282012 Ex#3: Step 3").setVisible(true);
    }
}
