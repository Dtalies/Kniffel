

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;



public class GUI {
    JFrame f;
    JFrame f2;
    JPanel p;
    JPanel p2;
    JPanel p3;

    ImageIO image;

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
        
        //Image bgImage= Toolkit.getDefaultToolkit().getImage("wallpaper_adrift.jpg");

        
        f = new JFrame("TestWindow");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200,200);
        f.setVisible(true);
        f.setBackground(new Color(255,255,255));
        //g.drawImage(Image, 0, 0, null);
        

        
        
        
        


        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));

        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));

        contentPane = f.getContentPane();

        l = new JLabel("");
        l.setVisible(true);    
        l.setPreferredSize(new Dimension(50, 50));
        l.setBackground(Color.black);
        l.setForeground(Color.black);
        l.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        l2 = new JLabel("");
        l2.setVisible(true);    
        l2.setPreferredSize(new Dimension(50, 50));
        l2.setBackground(Color.black);
        l2.setForeground(Color.black);
        l2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l3 = new JLabel("");
        l3.setVisible(true);    
        l3.setPreferredSize(new Dimension(50, 50));
        l3.setBackground(Color.black);
        l3.setForeground(Color.black);
        l3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l4 = new JLabel("");
        l4.setVisible(true);    
        l4.setPreferredSize(new Dimension(50, 50));
        l4.setBackground(Color.black);
        l4.setForeground(Color.black);
        l4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));    

        l5 = new JLabel("");
        l5.setVisible(true);    
        l5.setPreferredSize(new Dimension(50, 50));
        l5.setBackground(Color.black);
        l5.setForeground(Color.black);
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
