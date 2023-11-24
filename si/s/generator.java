import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class generator
{

    generator(String temp[] , int question[])
    {

        JFrame g = new JFrame("Question Paper Generator");
        g.getContentPane().setBackground( Color.decode("#9ff0bc") );
        ImageIcon logo = new ImageIcon("logo.png");
        g.setIconImage(logo.getImage());

        JLabel la = new JLabel("Questions");
        la.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 20));

        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "ALL QUESTIONS"));

        String str = "";
        for (int i = 0; i < question.length; i++)
        {
            str += (i+1)+ ")  " + temp[question[i]] + "\n";

        }

        la.setBounds(100, 50, 200, 40);
        middlePanel.setBounds(40, 100, 600, 500);

        JTextArea display = new JTextArea(30, 58);
        display.setFont(new Font("Arial Black", Font.PLAIN, 10));
        display.setText(str);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add Textarea in to middle panel
        middlePanel.add(scroll);
        g.add(middlePanel);

        JButton b = new JButton("Generate Pdf ");
        b.setFocusable(false);
        b.setBounds(450,50,150,40);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String stri = "";
                for (int i = 0; i < question.length; i++)
                {
                    stri += i + 1 + ")  " + temp[question[i]] + "\n";
                }
                Document document = new Document();
                PdfWriter writer = null;
                try
                {
                    writer = PdfWriter.getInstance(document, new FileOutputStream("QuestionPaper.pdf"));
                }
                catch (DocumentException documentException)
                {
                    documentException.printStackTrace();
                }
                catch (FileNotFoundException fileNotFoundException)
                {
                    fileNotFoundException.printStackTrace();
                }
                document.open();
                try
                {
                    String collegename = "                                             National Institute of Technology, Delhi";
                    document.add(new Paragraph(collegename));
                    document.add(new Paragraph( "                                                    Mid Semester Examination"+ "\n" + "                                                       Spring Semester"+"\n" + "\n"));  // add new paragraph to the pdf
                }
                catch (DocumentException documentException)
                {
                    documentException.printStackTrace();
                }

                try
                {
                    document.add( new Paragraph(stri));
                }
                catch (DocumentException documentException)
                {
                    documentException.printStackTrace();
                }
                document.close();
                writer.close();
            }
        });

        g.setResizable(false);
        g.add(la);
        g.add(b);

        g.setSize(700, 700);
        g.setLayout(null);
        g.setVisible(true);
    }
}
