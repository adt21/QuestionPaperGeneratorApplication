import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class generate
{

    String temp[];
    int question[];

    generate()
    {

        JFrame gframe = new JFrame("\"Question Paper Generator\"");
        ImageIcon logo = new ImageIcon("logo.png");
        gframe.setIconImage(logo.getImage());
        gframe.getContentPane().setBackground( Color.decode("#9ff0bc") );

        JLabel la1 = new JLabel("GENERATE QUESTION PAPER");
        la1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 30));

        JLabel la2 = new JLabel("Branch");
        la2.setFont(la2.getFont().deriveFont(15.0f));
        String branch[] = {"Select", "CSE", "ECE", "EEE", "Mechanical"};
        JComboBox cb1 = new JComboBox(branch);
        cb1.setBackground(Color.WHITE);

        JLabel la3 = new JLabel("Year");
        la3.setFont(la3.getFont().deriveFont(15.0f));
        String year[] = {"Select", "First", "Second", "Third", "Fourth"};
        JComboBox cb2 = new JComboBox(year);
        cb2.setBackground(Color.WHITE);

        JLabel la4 = new JLabel("Semester");
        la4.setFont(la4.getFont().deriveFont(15.0f));
        String semester[] = {"Select", "Autumn", "Spring"};
        JComboBox cb3 = new JComboBox(semester);
        cb3.setBackground(Color.WHITE);

        JLabel la5 = new JLabel("Course");
        la5.setFont(la5.getFont().deriveFont(15.0f));
        String course[] = {"Select", "CSB252", "ECB257", "MAP281", "CSB271"};
        JComboBox cb4 = new JComboBox(course);
        cb4.setBackground(Color.WHITE);

        JLabel la6 = new JLabel("Difficulty Level");
        la6.setFont(la6.getFont().deriveFont(15.0f));
        String level[] = {"Select", "Easy", "Medium", "High"};
        JComboBox cb5 = new JComboBox(level);
        cb5.setBackground(Color.WHITE);

        JLabel la7 = new JLabel("Question");
        la7.setFont(la7.getFont().deriveFont(15.0f));
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel la8 = new JLabel("Marks");
        la8.setFont(la8.getFont().deriveFont(15.0f));
        JTextField marks = new JTextField();

        JButton button1 = new JButton("Submit");
        button1.setFocusable(false);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);

        JButton b = new JButton("Back");
        b.setFocusable(false);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);


        la1.setBounds(100, 50, 400, 40);
        la2.setBounds(100, 150, 150, 30);
        cb1.setBounds(250, 150, 150, 30);
        la3.setBounds(100, 200, 150, 30);
        cb2.setBounds(250, 200, 150, 30);
        la4.setBounds(100, 250, 150, 30);
        cb3.setBounds(250, 250, 150, 30);
        la5.setBounds(100, 300, 150, 30);
        cb4.setBounds(250, 300, 150, 30);
        la6.setBounds(100, 350, 150, 30);
        cb5.setBounds(250, 350, 150, 30);
        la7.setBounds(100, 400, 150, 30);
        ta.setBounds(250, 400, 250, 80);
        la8.setBounds(100, 500, 150, 30);
        marks.setBounds(250, 500, 100, 30);
        button1.setBounds(220, 550, 100, 30);
        b.setBounds(400, 550, 100, 30);

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BufferedReader br = null;
                if ((   !cb1.getSelectedItem().equals("Select")) ||
                        !(cb2.getSelectedItem().equals("Select")) ||
                        !(cb3.getSelectedItem().equals("Select")) ||
                        !(cb4.getSelectedItem().equals("Select")) ||
                        !(cb5.getSelectedItem().equals("Select")
                        ))
                {
                    String s1 = new String((String) cb1.getSelectedItem());
                    String s2 = new String((String) cb2.getSelectedItem());
                    String s3 = new String((String) cb3.getSelectedItem());
                    String s4 = new String((String) cb4.getSelectedItem());
                    String s5 = new String((String) cb5.getSelectedItem());
                    String fileName = new String(s1 + s2 + s3 + s4 + s5 + ".txt");

                    try
                    {
                        br = new BufferedReader(new FileReader(fileName));
                    }
                    catch (FileNotFoundException fileNotFoundException)
                    {
                        fileNotFoundException.printStackTrace();
                        JOptionPane.showMessageDialog(null,"No questions to display. Pls add questions");

                    }
                    String line = null;

                    while (true)
                    {
                        try
                        {
                            if (!((line = br.readLine()) != null)) break;
                        }
                        catch (IOException ioException)
                        {
                            ioException.printStackTrace();
                            JOptionPane.showMessageDialog(null,"No questions to display. File Empty");
                        }
                        temp = line.split("@");

                    }
                    int c= temp.length;
                    Random random = new Random();
                    question = new int[15];
                    int i = 0, j, check;
                    while (i < 15)
                    {
                        check = 1;
                        question[i] = random.nextInt((int) c);
                        j = i;
                        for (int k = 0; k < j; k++)
                        {
                            if (question[k] == question[i])
                                check = 0;
                        }
                        if (check == 1)
                            i++;
                    }

                    new generator(temp, question);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Select items from all the fields");
                }
            }
        });

        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                new afterlogin();
                gframe.dispose();
            }
        });

        gframe.add(la1);
        gframe.add(la2);
        gframe.add(la3);
        gframe.add(la4);
        gframe.add(la5);
        gframe.add(button1);
        gframe.add(cb1);
        gframe.add(cb2);
        gframe.add(cb3);
        gframe.add(cb4);
        gframe.add(b);
        gframe.add(cb5);
        gframe.add(la6);


        gframe.setSize(650,650);
        gframe.setLayout(null);
        gframe.setVisible(true);
    }

}
