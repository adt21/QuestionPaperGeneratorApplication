import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class startpage
{
    startpage() // constructor of startpage()
    {
        JFrame frame1 = new JFrame("Question Paper Generator");  // creating an instance of JFrame
        ImageIcon logo = new ImageIcon("logo.png");  // to set logo to the frame
        frame1.setIconImage(logo.getImage());
        frame1.setSize(650,650);       // to set the size of the frame
        frame1.setLayout(null);        //to set layout of the frame as null

        JLabel label1 = new JLabel(" QUESTION PAPER GENERATOR");
        label1.setBounds(150,100,450,60);
        label1.setFont(new Font("Arial Black", Font.BOLD,15));   //font

        JButton login = new JButton("Login");   //creating instance of JButton
        login.setFocusable(false);
        login.setBounds(250,250,100,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==login)  // if the button Login is clicked the action to be performed
                {
                    new LoginUI();   // creating instance of LoginUI
                    frame1.dispose();  // dispose the starting page
                }

            }
        });

        JButton register = new JButton("Register");   // creating instance of JButton named 'Register'
        register.setFocusable(false);
        register.setBounds(250,350,100,40);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(new ActionListener()   // add ActionListener to button
        {
            public void actionPerformed(ActionEvent ev){
                if(ev.getSource()==register)
                {
                    new RegisterUI();      // creating instance of RegisterUI
                    frame1.dispose();  // disposal of previous frame
                }
            }
        });

        //for Background of the frame
        JLabel background=new JLabel(new ImageIcon("b.jpg"));   // creating instance of JLabel and including an image in the label
        background.setBounds(0,10,650,650);
        background.setLayout(null);
        frame1.setLayout(new BorderLayout());

        frame1.add(background);      //adding  components
        background.add(label1);
        background.add(login);
        background.add(register);

        frame1.setVisible(true);  // making the Frame visible
    }
}


