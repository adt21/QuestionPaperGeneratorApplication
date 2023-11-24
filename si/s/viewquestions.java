import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class viewquestions
{

    public viewquestions()
    {
        JFrame vframe = new JFrame("Question Paper Generator");
        vframe.getContentPane().setBackground( Color.decode("#9ff0bc") );
        ImageIcon logo = new ImageIcon("logo.png");
        vframe.setIconImage(logo.getImage());

        JLabel la1 = new JLabel("VIEW QUESTIONS");
        la1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 20));

        JLabel la2 = new JLabel("Branch");
        la2.setFont(la2.getFont().deriveFont(15.0f));
        String branch[]= {"Select","CSE","ECE","EEE","Mechanical"};
        JComboBox cb1 = new JComboBox(branch);
        cb1.setBackground(Color.WHITE);

        JLabel la3 = new JLabel("Year");
        la3.setFont(la3.getFont().deriveFont(15.0f));
        String year[] = {"Select","First","Second","Third","Fourth"};
        JComboBox cb2 = new JComboBox(year);
        cb2.setBackground(Color.WHITE);

        JLabel la4 = new JLabel("Semester");
        la4.setFont(la4.getFont().deriveFont(15.0f));
        String semester[] = {"Select","Autumn","Spring"};
        JComboBox cb3 = new JComboBox(semester);
        cb3.setBackground(Color.WHITE);

        JLabel la5 = new JLabel("Course");
        la5.setFont(la5.getFont().deriveFont(15.0f));
        String course[] = {"Select","CSB252","ECB257","MAP281","CSB271"};
        JComboBox cb4 = new JComboBox(course);
        cb4.setBackground(Color.WHITE);

        JLabel la6 = new JLabel("Difficulty Level");
        la6.setFont(la6.getFont().deriveFont(15.0f));
        String level[] = {"Select","Easy","Medium","High"};
        JComboBox cb5 = new JComboBox(level);
        cb5.setBackground(Color.WHITE);

        JButton button1 = new JButton("Submit");
        button1.setFocusable(false);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);

        la1.setBounds(180,50,400,40);
        la2.setBounds(100,150,150,30);
        cb1.setBounds(250,150,150,30);
        la3.setBounds(100,200,150,30);
        cb2.setBounds(250,200,150,30);
        la4.setBounds(100,250,150,30);
        cb3.setBounds(250,250,150,30);
        la5.setBounds(100,300,150,30);
        cb4.setBounds(250,300,150,30);
        la6.setBounds(100,350,150,30);
        cb5.setBounds(250,350,150,30);
        button1.setBounds(40,500,100,30);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((!cb1.getSelectedItem().equals("Select")) ||
                        !(cb2.getSelectedItem().equals("Select")) ||
                        !(cb3.getSelectedItem().equals("Select")) ||
                        !(cb4.getSelectedItem().equals("Select")) ||
                        !(cb5.getSelectedItem().equals("Select")))
                {
                    String s1 = new String((String) cb1.getSelectedItem());
                    String s2 = new String((String) cb2.getSelectedItem());
                    String s3 = new String((String) cb3.getSelectedItem());
                    String s4 = new String((String) cb4.getSelectedItem());
                    String s5 = new String((String) cb5.getSelectedItem());
                    String fileName = new String(s1 + s2 + s3 + s4 + s5 + ".txt");

                    try
                    {
                        BufferedReader br = new BufferedReader(new FileReader(fileName));
                        String line = null;
                        String str="";
                      /*  while ((line = br.readLine()) != null)
                        {

                           // String temp[] = line.split("@");
                           // new viewer(temp);

                        }*/
                        line=br.readLine();
                        new viewer(line);

                    }
                    catch (FileNotFoundException fileNotFoundException)
                    {
                        fileNotFoundException.printStackTrace();
                        JOptionPane.showMessageDialog(null,"No questions to display. Pls add questions");
                    }
                    catch (IOException ioException)
                    {
                        ioException.printStackTrace();
                    }
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Select items from all the fields");
                }

            }
        });

        JButton b = new JButton("Back");
        b.setFocusable(false);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(450,500,100,30);
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new afterlogin();
                vframe.dispose();
            }
        });

        JButton b1 = new JButton("View Another");
        b1.setFocusable(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(220,500,150,30);
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                cb1.setSelectedItem("Select");
                cb2.setSelectedItem("Select");
                cb3.setSelectedItem("Select");
                cb4.setSelectedItem("Select");
                cb5.setSelectedItem("Select");
            }

        });

        vframe.add(la1);
        vframe.add(la2);
        vframe.add(la3);
        vframe.add(la4);
        vframe.add(la5);
        vframe.add(button1);
        vframe.add(cb1);
        vframe.add(cb2);
        vframe.add(cb3);
        vframe.add(cb4);
        vframe.add(b);
        vframe.add(cb5);
        vframe.add(la6);
        vframe.add(b1);   // add components to the frame


        vframe.setSize(650,650);
        vframe.setLayout(null);
        vframe.setVisible(true);
    }


}


