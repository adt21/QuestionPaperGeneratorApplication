import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class addquestions
{

    addquestions()
    {

        JFrame frame2 = new JFrame("Question Paper Generator");
        frame2.getContentPane().setBackground(Color.decode("#9ff0bc"));
        ImageIcon logo = new ImageIcon("logo.png");
        frame2.setIconImage(logo.getImage());

        JLabel la1 = new JLabel("ADD QUESTIONS");
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

        JButton bu = new JButton("Add More");
        bu.setFocusable(false);
        bu.setBackground(Color.BLACK);
        bu.setForeground(Color.WHITE);

        la1.setBounds(180, 50, 400, 40);
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
        bu.setBounds(40, 550, 100, 30);


        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ee) {


                if ((!cb1.getSelectedItem().equals("Select")) ||
                        !(cb2.getSelectedItem().equals("Select")) ||
                        !(cb3.getSelectedItem().equals("Select")) ||
                        !(cb4.getSelectedItem().equals("Select")) ||
                        !(cb5.getSelectedItem().equals("Select")) ||
                        !(ta.getText().isEmpty()) ||
                        !(marks.getText().isEmpty()
                        )) {
                    String s1 = new String((String) cb1.getSelectedItem());
                    String s2 = new String((String) cb2.getSelectedItem());
                    String s3 = new String((String) cb3.getSelectedItem());
                    String s4 = new String((String) cb4.getSelectedItem());
                    String s5 = new String((String) cb5.getSelectedItem());
                    String q = new String(ta.getText());
                    String fileName = new String(s1 + s2 + s3 + s4 + s5 + ".txt");

                    try {
                        FileWriter writer = new FileWriter(s1 + s2 + s3 + s4 + s5 + ".txt", true);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        buffer.write(q);
                        buffer.write("@");
                        buffer.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Question addeded");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Select items from all the fields");
                }
            }
        });


        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ee)
            {
                new afterlogin();
                frame2.dispose();
            }

        });

        bu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent eee)
            {
                ta.setText("");
                marks.setText("");
            }
        });

        // adding components to the frame
        frame2.add(la1);
        frame2.add(la2);
        frame2.add(la3);
        frame2.add(la4);
        frame2.add(la5);
        frame2.add(la6);
        frame2.add(la7);
        frame2.add(la8);
        frame2.add(button1);
        frame2.add(cb1);
        frame2.add(cb2);
        frame2.add(cb3);
        frame2.add(cb4);
        frame2.add(cb5);
        frame2.add(ta);
        frame2.add(marks);
        frame2.add(scroll);
        frame2.add(b);
        frame2.add(bu);

        frame2.setSize(650, 650);
        frame2.setLayout(null);
        frame2.setVisible(true);
    }
}
