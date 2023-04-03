import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExGUIAWT_02_ans extends ExGUIAWT_01_ans implements ActionListener {

    private Button btn1;
    private Button btn2;

    public ExGUIAWT_02_ans(String title) {
        super(title);

        btn1 = new Button("Decrease");
        btn2 = new Button("Increase");

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        Panel buttonPanel = new Panel();
        buttonPanel.add(btn1);
        buttonPanel.add(btn2);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ExGUIAWT_02_ans("Ex#2: Step 1").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btn1) {
            if (r > 10) {
                r -= 10;
            }
        } else if (source == btn2) {
            if (r < 100) {
                r += 10;
            }
        }

        cvs.repaint();
    }
}
