import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui implements ActionListener {
    
    playerList spielerliste = new playerList();
    public Gui(){

        createMainFrame();
        

    }
     JMenuItem i1, i2, i3, i4, i5;
    
    private static JFrame frame = new JFrame();
    
    public void createMainFrame(){

        
        JMenuBar mb = new JMenuBar();
        
        JMenu m1 = new JMenu("Spiel");
        JMenu m2 = new JMenu("Hilfe");

        mb.setVisible(true);

        i1=new JMenuItem("Spieler hinzufügen");
        i1.addActionListener(this);  
        i2=new JMenuItem("Spiel beenden");  
        i2.addActionListener(this);  
        i3=new JMenuItem("Spiel starten");
        i3.addActionListener(this);    
        i4=new JMenuItem("Anleitung");
        i4.addActionListener(this);    
        i5=new JMenuItem("Info");
        i5.addActionListener(this);  
        
        


        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        m2.add(i4);
        m2.add(i5);
        
        mb.add(m1);
        mb.add(m2);

        frame.setDefaultCloseOperation(3); // JFrame.EXIT_ON_CLOSE
        frame.setSize(300,300);   
        frame.setTitle("Kniffel");
        frame.setName("Kniffel"); 
        frame.setJMenuBar(mb);
        //frame.add(BorderLayout.NORTH, mb);
        
        
        frame.setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == i1)
        {
            String name = JOptionPane.showInputDialog(frame,"Spielername", "Spieler Hinzufügen", JOptionPane.QUESTION_MESSAGE);
            player p = new player();
            p.setName(name);
            spielerliste.add(p);
            System.out.println(spielerliste.getContent());
            
        }
        if(ae.getSource() == i2)
        {

            int n = JOptionPane.showConfirmDialog(frame,"WOllen sie das Spiel wirklich Beenden","Spiel Beenden",JOptionPane.YES_NO_OPTION);

            if(n == JOptionPane.YES_OPTION)
            {
                frame.dispose();
            }

        }
        if(ae.getSource() == i4){

            JFrame hilfe = new JFrame();
            hilfe.setDefaultCloseOperation(2); // JFrame.DISPOSE_ON_CLOSE
            hilfe.setSize(300,300);   
            hilfe.setTitle("Hilfe");
            hilfe.setName("Hilfe"); 

            
            JTextArea t1 = new JTextArea("Hilfe");
            
            hilfe.add(t1);

            hilfe.setVisible(true);

            
        }
        if(ae.getSource() == i5){

            JFrame credits = new JFrame();
            credits.setDefaultCloseOperation(2); // JFrame.DISPOSE_ON_CLOSE
            credits.setSize(300,300);   
            credits.setTitle("credits");
            credits.setName("credits"); 

            
            JTextArea t1 = new JTextArea("credits");
            
            credits.add(t1);
            credits.setVisible(true);

            
        }
    }


    


 }

