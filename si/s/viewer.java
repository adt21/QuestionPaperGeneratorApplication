import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewer
{

    viewer(String line)
    {

        String temp[] = line.split("@");

        JFrame view = new JFrame("Question Paper Generator");
        ImageIcon logo = new ImageIcon("logo.png");
        view.setIconImage(logo.getImage());

        view.getContentPane().setBackground(Color.decode("#9ff0bc"));
        view.setForeground(Color.WHITE);

        JLabel la = new JLabel("--- QUESTIONS ---");
        la.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 20));
        la.setBounds(250,50,400,40);


        JPanel middlePanel = new JPanel ();
        middlePanel.setBorder ( new TitledBorder( new EtchedBorder(), "ALL QUESTIONS" ) );
        middlePanel.setBounds(40,100,600,600);
        String str = "";
        for(int i=0;i<temp.length; i++)
        {
            str += i+1 +")  "+ temp[i]+"\n";
        }
        System.out.println(str);
        JTextArea display = new JTextArea ( 38, 58 );
        display.setText(str);
        display.setEditable ( false );
        JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        //Add Textarea in to middle panel
        middlePanel.add ( scroll );
        view.add ( middlePanel );
        view.setResizable(false);

        JButton b = new JButton("Close");
        b.setBounds(300,720,100,30);
        b.setFocusable(false);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                view.dispose();
            }
        });

        view.add(la);
        view.add(b);
        view.setSize(700, 800);
        view.setLayout(null);
        view.setVisible(true);
    }
}
