import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExGUISwing_01 extends JFrame{
    JButton b1,b2,b3,b4,b5,b6;
    JPanel panel;
    JLabel label;
    
    ExGUISwing_01(String title){
        super(title);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }
    
    public static void main(String argv[]){
        new ExGUISwing_01("EX#2: Step 2").setVisible(true);
    }
}
