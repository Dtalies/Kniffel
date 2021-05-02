import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

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
        frame.setLocation(500, 500);
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
                System.exit(0);
            }

        }
        if(ae.getSource() == i3)
        {
            startGame(spielerliste);


            

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

        public void startGame(playerList sPlayerList)
    {

        List<JFrame> playerFrame = new ArrayList<>();


        for(int i = 0; i<sPlayerList.getSize();i++)
        {
            JFrame playFrame = new JFrame();
            playFrame.setDefaultCloseOperation(0);
            playFrame.setSize(900,900);   
            playFrame.setTitle(sPlayerList.players.get(i).getName());
            playFrame.setName(Integer.toString(i));
            playFrame.setVisible(false);
            playFrame.setLocation(100, 100);

            JPanel p1 = new JPanel();
            p1.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel[] dices = new JLabel[5];

            for(int d = 0; d<5; d++)
            {
                JLabel l1 = new JLabel();
            
                l1.setSize(new Dimension(50, 50));
                l1.setName(Integer.toString(d));
                l1.setText(Integer.toString(sPlayerList.players.get(i).diceCup.dices[d].getCount()));
                l1.setLocation(100+d*100, 100);
                l1.setVisible(true);
                
                dices[d] = l1;
            }
                for(int u = 0; u<5;u++)
                {
                    p1.add(dices[u]);
                }
                playFrame.add(p1);
            


            JButton b = new JButton("Finish");
            
            b.setBackground(Color.black);
            b.setForeground(Color.white);
            b.setLocation(200, 200);
            b.setSize(new Dimension(100,100));
            b.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    playFrame.setVisible(false);
                    sPlayerList.players.get(0).diceCup.clearTimesRolled();
                }
            });
            p1.add(b);

            JButton b1 = new JButton("Roll");
            
                b1.setBackground(Color.black);
                b1.setForeground(Color.white);
                b1.setSize(new Dimension(100,100));
                b1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {

                        sPlayerList.players.get(0).diceCup.shake();
                        for (int p = 0 ; p<5 ; p++)
                        {
                        dices[p].setText(Integer.toString(sPlayerList.players.get(0).diceCup.dices[p].getCount()));
                        sPlayerList.players.get(0).diceCup.setTimesRolled();

                        
                    }
                }
            });
            
            
            p1.add(b1);
            //if(sPlayerList.players.get(0).diceCup.getTimesRolled()>= 3){ p1.remove(b1);}
                
            
            playerFrame.add(playFrame);
        }
        
        
        for(int i = 0; i<sPlayerList.getSize();i++)
        {
            playerFrame.get(i).setVisible(true);
            
            
        }
    }
    
    
 }

