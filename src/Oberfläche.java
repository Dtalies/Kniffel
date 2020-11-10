
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import java.util.*;
     
    
        public class Oberfläche
        {
        Frame fa;
        Label la;
        Button button;
        TextField eingabe;
    
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
    
        public Oberfläche()
        {
            Test();
            //Test2();
    
        }
    
        public void Test()
        {
            f= new JFrame("TestFenster");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(550,900);
            f.setVisible(true);
            f.setBackground(new Color(255,255,255));
            p= new JPanel();
            p.setLayout(new FlowLayout(FlowLayout.CENTER));
            
            
            p2= new JPanel();
            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
            
            p3= new JPanel();
            p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
            
            
            
            
            contentPane = f.getContentPane();
            l = new JLabel("");
            l.setVisible(true);
            l.setPreferredSize(new Dimension(100,100));
            l.setLocation(183,0);
            l.setFont(new Font("Verdana", Font.BOLD, 30));
            l.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            l2 = new JLabel("");
            l2.setVisible(true);
            l2.setPreferredSize(new Dimension(100,100));
            l2.setLocation(366,0);
            l2.setFont(new Font("Verdana", Font.BOLD, 30));
            l2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            l3 = new JLabel("");
            l3.setVisible(true);
            l3.setPreferredSize(new Dimension(100,100));
            l3.setLocation(549,0);
            l3.setFont(new Font("Verdana", Font.BOLD, 30));
            l3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            
            l4 = new JLabel("");
            l4.setVisible(true);
            l4.setPreferredSize(new Dimension(100,100));
            l4.setLocation(732,0);
            l4.setFont(new Font("Verdana", Font.BOLD, 30));
            l4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            l5 = new JLabel("");
            l5.setVisible(true);
            l5.setPreferredSize(new Dimension(100,100));
            l5.setLocation(915,0);
            l5.setFont(new Font("Verdana", Font.BOLD, 30));
            l5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            //l6 = new JLabel("");
            //l6.setVisible(true);
            //l6.setFont(new Font("Verdana", Font.BOLD, 30));
            //l6.setText("GEWINNE GEWINNE GEWINNE");
            
            contentPane.add(l);
    
            text = new JTextField();
            contentPane.add(text);
    
            b = new JButton("Roll");
            
            b.setFont(new Font("Verdana", Font.BOLD, 15));
            b.setBackground(Color.black);
            b.setForeground(Color.white);
            b.setPreferredSize(new Dimension(100,50));
            b.addActionListener(new ActionListener()
            {
                    public void actionPerformed(ActionEvent e){
                        l.setText("" + Random());
                        l2.setText("" + Random());
                        l3.setText("" + Random());
                        l4.setText("" + Random());
                        l5.setText("" + Random());
              }
            });
            p.add(b);
            p2.add(l);
            p2.add(l2);
            p2.add(l3);
            p2.add(l4);
            p2.add(l5);
            //p3.add(l6);
           
            
            contentPane.add(p, BorderLayout.SOUTH);
            contentPane.add(p2, BorderLayout.NORTH);
            contentPane.add(p3, BorderLayout.CENTER);
            
    
    
            f.addWindowListener(new WindowAdapter() 
                { 
                    public void windowClosing(WindowEvent e)    
                    {        
                        System.exit(1);
                    }
                });
    
            f.setVisible(true);
        }
    
        public void Test2()
        {
            Frame();
            Label();
    
            fa.addWindowListener(new WindowAdapter() 
                { 
                    public void windowClosing(WindowEvent e)    
                    {        
                        System.exit(1);
                    }
                });
        }
    
        public void Frame()
        {
            fa = new Frame ("Testfenster");
            fa.setSize(600, 300);
            fa.setLocation(100, 100);
            fa.setVisible(true);
            fa.setLayout(null);
        }
    
        public void Label()
        {
            la=new Label();
            la.setText("Git Gud nub");
            la.setLocation(100, 100);
            la.setVisible(true);
            la.setSize(100, 100);
            la.setForeground(new Color (0, 0, 0));
            la.setBackground(new Color (255, 255, 255));
            fa.add(la);
        }
        public  int Random() {
          
          
          Random Roll = new Random();
         
          
          return(Roll.nextInt(6)+1);
          
        }
    }



