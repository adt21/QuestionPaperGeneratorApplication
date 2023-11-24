import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LoginUI extends JFrame implements ActionListener{

   public LoginUI()
   {

      JFrame log = new JFrame("Question Paper Generator");
      ImageIcon logo = new ImageIcon("logo.png");
      log.setIconImage(logo.getImage());
      log.getContentPane().setBackground( Color.decode("#9ff0bc") );

      JLabel l1 = new JLabel("LOGIN ");
      l1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 30));
      JLabel l2 = new JLabel("Username");
      l2.setFont(l2.getFont().deriveFont(15.0f));
      JTextField text = new JTextField();
      JLabel l3 = new JLabel("Password");
      l3.setFont(l3.getFont().deriveFont(15.0f));
      JPasswordField p1 = new JPasswordField();
      JCheckBox showpassword = new JCheckBox("Show Password");

      JButton b = new JButton("Submit");
      b.setFocusable(false);
      b.setBackground(Color.BLACK);
      b.setForeground(Color.WHITE);

      l1.setBounds(250,100,400,40);
      l2.setBounds(120,200,150,30);
      text.setBounds(320,200,150,30);
      l3.setBounds(120,260,150,30);
      p1.setBounds(320,260,150,30);
      showpassword.setBounds(300,300,150,30);
      b.setBounds(250,350,100,30);

      b.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {

            String fileName = new String(text.getText()+".txt");
            String fileName2 = new String(text.getText()+"pass.txt");

            File f1 = new File(fileName);
            Scanner s = null;
            try
            {
               s = new Scanner(f1);
            }
            catch (FileNotFoundException e)
            {
               e.printStackTrace();
            }
            String name = s.next();
            s.close();
            File f2 = new File(fileName2);
            Scanner s1 = null;
            try
            {
               s1 = new Scanner(f1);
            }
            catch (FileNotFoundException e)
            {
               e.printStackTrace();
            }
            String pass = s1.next();
            s1.close();

            if(f1.exists() || f2.exists())
            {
               String password = new String(p1.getPassword());
               String namee = new String(text.getText());

               if (password.equals(pass) || namee.equals(name))
               {
                  JOptionPane j = new JOptionPane();
                  j.showMessageDialog(null,"Login Successfull");
                  new afterlogin();
                  log.dispose();
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Fill all the fields");
            }

         }
      });
      log.add(l1);
      log.add(l2);
      log.add(l3);
      log.add(text);
      log.add(p1);
      log.add(b);
      log.add(showpassword);

      log.setVisible(true);
      log.setLayout(null);
      log.setSize(650,650);
   }
   @Override
   public void actionPerformed(ActionEvent e)
   {

   }
}
