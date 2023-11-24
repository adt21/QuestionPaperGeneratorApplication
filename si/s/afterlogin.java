import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class afterlogin
{

    public afterlogin()
    {
        JFrame fr = new JFrame("Question Paper Generator");
        ImageIcon logo = new ImageIcon("logo.png");
        fr.setIconImage(logo.getImage());
        fr.getContentPane().setBackground( Color.decode("#9ff0bc") );

        JButton b3 = new JButton("View Questions");
        b3.setFocusable(false);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        JButton b4 = new JButton("Add Questions");
        b4.setFocusable(false);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        JButton b5 = new JButton("Generate Question Paper");
        b5.setFocusable(false);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);

        b3.setBounds(150,150,300,50);
        b4.setBounds(150,250,300,50);
        b5.setBounds(150,350,300,50);

        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {
                new viewquestions();
                fr.dispose();
            }
        });

        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e2)
            {
                new addquestions();
                fr.dispose();
            }

        });

        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e3)
            {
                new generate();
                fr.dispose();

            }
        });

        fr.add(b3);
        fr.add(b4);
        fr.add(b5);

        fr.setSize(650,650);
        fr.setLayout(null);
        fr.setVisible(true);
    }
}
