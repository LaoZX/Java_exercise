import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExGUISwing_02 extends ExGUISwing_01 implements ActionListener {
    JLabel AFC;
    double Afreq=594;
    double Ffreq=76.1;
    int channel=1;

    ExGUISwing_02(String title){
        super(title);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        b1.setVisible(false);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(false);
        b6.setVisible(false);

        AFC = new JLabel("");
        AFC.setFont(new Font("Arial", Font.PLAIN, 20));
        AFC.setForeground(Color.BLACK);
        AFC.setBounds(0, 0, 100, 50);
        panel.add(AFC);
    }
    
    public static void main(String argv[]){
        new ExGUISwing_02("EX#2: Step 3").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == b1){
            b1.setVisible(false);
            b5.setVisible(false);
            b6.setVisible(false);
            label.setText("Power Off");
            AFC.setText("");
        }
        else if(source == b2){
            b1.setVisible(true);
            b5.setVisible(true);
            b6.setVisible(true);
            AFC.setText("AM");
            label.setText(Afreq+"kHz");
        }
        else if(source == b3){
            b1.setVisible(true);
            b5.setVisible(true);
            b6.setVisible(true);
            AFC.setText("FM");
            label.setText(Ffreq+"MHz");
        }
        else if(source == b4){
            b1.setVisible(true);
            b5.setVisible(true);
            b6.setVisible(true);
            AFC.setText("CD");
            label.setText("Track "+channel+"/20");
        }
        else if(source == b5){
            switch(AFC.getText()){
                case "AM": 
                    if(Afreq<720){Afreq+=16;}
                    label.setText(Afreq+"kHz");
                    break;
                case "FM": 
                    if(Ffreq<120){Ffreq+=8;}
                    label.setText(Ffreq+"MHz");
                    break;
                case "CD": 
                    if(channel<20){channel+=1;}
                    label.setText("Track "+channel+"/20");
                    break;
            }
        }
        else if(source == b6){
            switch(AFC.getText()){
                case "AM": 
                    if(Afreq>594){Afreq-=16;}
                    label.setText(Afreq+"kHz");
                    break;
                case "FM": 
                    if(Ffreq>76.1){Ffreq-=8;}
                    label.setText(Ffreq+"MHz");
                    break;
                case "CD": 
                    if(channel>1){channel-=1;}
                    label.setText("Track "+channel+"/20");
                    break;
            }
        }
    }
}
