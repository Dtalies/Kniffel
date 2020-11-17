import java.awt.*;
import java.awt.event.*;
import javax.swing.*;






import java.util.*;

public class GUI {
    JFrame f;
    JPanel p;
    JPanel p2;
    JPanel p3;

    Container contentPane;

    JLabel l;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    
    JButton b;
    JTextField text;
    
    public GUI(){
        test();
    }
    public static void main(String args[])
    {
        new GUI();
    }

    public void test()
    
    {
        f = new JFrame("TestWindow");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setVisible(true);
        f.setBackground(new Color(255,255,255));
        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));

        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout. Y_AXIS));

        p3 = new JPanel();
        p3.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        contentPane = f.getContentPane();

        l = new JLabel("");
        l.setVisible(true);    
        l.setPreferredSize(new Dimension(100, 100));
        l.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        l2 = new JLabel("");
        l2.setVisible(true);    
        l2.setPreferredSize(new Dimension(100, 100));
        l2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l3 = new JLabel("");
        l3.setVisible(true);    
        l3.setPreferredSize(new Dimension(100, 100));
        l3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l4 = new JLabel("");
        l4.setVisible(true);    
        l4.setPreferredSize(new Dimension(100, 100));
        l4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l5 = new JLabel("");
        l5.setVisible(true);    
        l5.setPreferredSize(new Dimension(100, 100));
        l5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l5 = new JLabel("");
        l5.setVisible(true);    
        l5.setPreferredSize(new Dimension(100, 100));
        l5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        contentPane.add(l);

        b = new JButton("Roll");

        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.setPreferredSize(new Dimension(100, 50));
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("" + random());
                l2.setText("" + random());
                l3.setText("" + random());
                l4.setText("" + random());
                l5.setText("" + random());
                


            }
        });

        p.add(b);
        p2.add(l);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);

        contentPane.add(p, BorderLayout.SOUTH);
        contentPane.add(p2, BorderLayout.NORTH);

        f.addWindowListener(new WindowAdapter()
       {
           public void windowColsing(WindowEvent e)
           {
            System.exit(1);
           }

       });

       f.setVisible(true);
    }

    public int random()
    {
     
    int max = 6; 
    int min = 1; 
    int range = max - min + 1; 

     
    for (int i = 0; i < 1; i++) { 
    int rand = (int)(Math.random() * range) + min;
    
    return rand;

    
    
 
    }
    return 6;

    }
    

}
