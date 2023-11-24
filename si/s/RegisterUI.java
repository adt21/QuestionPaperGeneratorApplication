import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class RegisterUI extends JFrame implements ActionListener
{

    public RegisterUI()
    {
        JFrame reg = new JFrame("Question Paper Generator");  // creating a frame named 'Register'
        ImageIcon logo = new ImageIcon("logo.png");  // to set logo to the frame
        reg.setIconImage(logo.getImage());
        reg.getContentPane().setBackground( Color.decode("#9ff0bc") ); // to set the background color of frame

        JLabel l1 = new JLabel("Registration ");
        l1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 30));
        JLabel l2 = new JLabel("Name");
        l2.setFont(l2.getFont().deriveFont(15.0f));
        JLabel l3 = new JLabel("Email");
        l3.setFont(l3.getFont().deriveFont(15.0f));
        JLabel l4 = new JLabel("Phone no");
        l4.setFont(l4.getFont().deriveFont(15.0f));
        JLabel l5 = new JLabel("Username");
        l5.setFont(l5.getFont().deriveFont(15.0f));
        JLabel l6 = new JLabel("Password");
        l6.setFont(l6.getFont().deriveFont(15.0f));

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JPasswordField t5 = new JPasswordField();

        JButton b1 = new JButton("SUBMIT");
        b1.setFocusable(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        l1.setBounds(150,100,450,40);
        l2.setBounds(100,180,150,30);
        l3.setBounds(100,230,150,30);
        l4.setBounds(100,280,150,30);
        l5.setBounds(100,330,150,30);
        l6.setBounds(100,380,150,30);
        t1.setBounds(250,180,200,30);
        t2.setBounds(250,230,200,30);
        t3.setBounds(250,280,200,30);
        t4.setBounds(250,330,200,30);
        t5.setBounds(250,380,200,30);
        b1.setBounds(150,500,100,30);


        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e1)
            {

                if(!t4.getText().isEmpty() || !t5.getText().isEmpty())
                {

                    String s1 = new String(t4.getText());
                    String s2 = new String(t5.getPassword());
                    String ss = new String(t1.getText());

                    String fileName = new String(t4.getText()+".txt");
                    String fileName2 = new String(t4.getText()+"pass.txt");

                    try
                    {
                        File f1 = new File(fileName);     // make a file
                        FileWriter writer1 = new FileWriter(f1); // create a file writer
                        writer1.write(s1);   // write in the file
                        writer1.close();      // closing of file
                        File f2 = new File(fileName2);   // make another file
                        FileWriter writer2 = new FileWriter(f2);  // create another file writer
                        writer2.write(s2);    // write in the file
                        writer2.close();   // close the file

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();   // in case if any exception is encountered
                    }

                    JOptionPane.showMessageDialog(null, "Registration Successful", "Set Color", JOptionPane.INFORMATION_MESSAGE);
                    new LoginUI();  // creating instance of LoginUI()
                    reg.dispose();  // disposal of previous frame
                }
                else   // else condition
                {
                    JOptionPane.showMessageDialog(null, "Fill all the fields ");// to display a msg using message box
                }
            }
        });

        JButton b2 = new JButton("RESET");         // creating a button for RESET
        b2.setFocusable(false);
        b2.setBounds(300,500,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e2)
            {
                t1.setText(null); t2.setText(null); t3.setText(null); t4.setText(null); t5.setText(null);   // set all the text field as null
            }
        });


        reg.add(l1);  // adding components to the frame
        reg.add(l2);
        reg.add(l3);
        reg.add(l4);
        reg.add(l5);
        reg.add(l6);
        reg.add(t1);
        reg.add(t2);
        reg.add(t3);
        reg.add(t4);
        reg.add(t5);
        reg.add(b1);
        reg.add(b2);

        reg.setLayout(null);
        reg.setSize(650,650);
        reg.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
