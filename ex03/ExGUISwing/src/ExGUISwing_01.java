import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ExGUISwing_01 extends JFrame{
    JButton b1,b2,b3,b4,b5,b6;
    JPanel panel;
    JLabel label;
    
    ExGUISwing_01(String title){
        super(title);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        b1 = new JButton("PW");
        b1.setSize(100, 60);
        b1.setLocation(0, 0);
        add(b1);

        b2 = new JButton("AM");
        b2.setSize(100, 60);
        b2.setLocation(0, 100);
        add(b2);

        b3 = new JButton("FM");
        b3.setSize(100, 60);
        b3.setLocation(0, 200);
        add(b3);

        b4 = new JButton("CD");
        b4.setSize(100, 60);
        b4.setLocation(400, 0);
        add(b4);

        b5 = new JButton("Up");
        b5.setSize(100, 60);
        b5.setLocation(400, 100);
        add(b5);

        b6 = new JButton("Dowm");
        b6.setSize(100, 60);
        b6.setLocation(400, 200);
        add(b6);

        panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panel.setSize(300, 260);
        panel.setLocation(100, 0);
        panel.setLayout(null);
        add(panel);
        
        label = new JLabel("Power off");
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setForeground(new Color(0,102,0));
        label.setBounds(45, 100, 250, 50);
        panel.add(label);
        
    }
    
    public static void main(String argv[]){
        new ExGUISwing_01("EX#2: Step 2").setVisible(true);
    }
}
