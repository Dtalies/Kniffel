
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
//import java.util.thread;

public class Gui implements ActionListener {
    
    final String h = "Hilfe";
    final String c = "Credits";
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
             
              JOptionPane.showMessageDialog(frame,"Der Spieler " + p.getName() + " wurde hinzugefügt");
             
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
            hilfe.setTitle(h);
            hilfe.setName(h); 

            
            JTextArea t1 = new JTextArea(h);
            
            hilfe.add(t1);

            hilfe.setVisible(true);

            
        }
        if(ae.getSource() == i5){

            JFrame credits = new JFrame();
            credits.setDefaultCloseOperation(2); // JFrame.DISPOSE_ON_CLOSE
            credits.setSize(300,300);   
            credits.setTitle(c);
            credits.setName(c); 

            
            JTextArea t1 = new JTextArea("credits");
            
            credits.add(t1);
            credits.setVisible(true);

            
        }
    }

    public void startGame(playerList sPlayerList)
    {

        List<JFrame> playerFrame = new ArrayList<>();
        sPlayerList.players.get(0).setTurn(true);
        

        for(int i = 0; i<sPlayerList.getSize();i++)
        {
            int truePlayer = i;
            
            JFrame playFrame = new JFrame();
            playFrame.setDefaultCloseOperation(0);
            playFrame.setSize(900,900);   
            playFrame.setTitle(sPlayerList.players.get(i).getName());
            playFrame.setName(Integer.toString(i));            
            playFrame.setVisible(true);
            playFrame.setLocation(100, 100);

            JPanel p1 = new JPanel();
            p1.setLayout(new FlowLayout(FlowLayout.CENTER));


            JLabel[] scoresName = new JLabel[sPlayerList.players.get(i).scoresheet.getlength()];
            JLabel[] scores = new JLabel[sPlayerList.players.get(i).scoresheet.getlength()];
            JButton[] setScores = new JButton[sPlayerList.players.get(i).scoresheet.getlength()];

            for(int s = 0 ; s<sPlayerList.players.get(i).scoresheet.getlength()-1; s++)
            {
                int trueScore = s;

                JLabel l2 = new JLabel();
                l2.setSize(new Dimension(50, 50));
                l2.setName(Integer.toString(s));
                l2.setText(sPlayerList.players.get(truePlayer).scoresheet.getTitle(s));
                l2.setLocation(100+s*100, 100);
                l2.setVisible(true);
                scoresName[s] = l2;
                p1.add(l2);

                JLabel l3 = new JLabel();
                l3.setSize(new Dimension(50, 50));
                l3.setName(Integer.toString(s));
                if (sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(s)) == -1) {
                    l3.setText("0");
                }
                else {
                    l3.setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(s))));
                }
                l3.setLocation(100+s*100, 100);
                l3.setVisible(true);
                scores[s] = l3;
                p1.add(l3);

                JButton b2 = new JButton();
                b2.setSize(new Dimension(50, 50));
                b2.setName(sPlayerList.players.get(truePlayer).scoresheet.getTitle(s));
                b2.setText("Eintragen");
                b2.setLocation(100+s*100, 100);
                if(trueScore== 6 || trueScore==7 || trueScore==15 || trueScore==16)
                {
                b2.setVisible(false);
                }
                else
                {
                    b2.setVisible(true);
                }
                b2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    JButton b3 = (JButton)e.getSource();
                    String t = b3.getName();

                    switch(t)
                    {
                        case "Einer" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.addOnes(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Zweier" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.addTwos(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Dreier" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.addThrees(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Vierer" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.addFours(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Fuenfer" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.addFives(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Sechser" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.addSixes(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        
                        case "3er" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.rowOfThree(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "4er" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.rowOfFour(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Fullhouse" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.fullHouse(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Kleine Strasse" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.shortstreet(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Große Straße" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.longstreet(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                        case "Chance" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.chance(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            break;
                            
                        case "Kniffel" : 
                            sPlayerList.players.get(truePlayer).scoresheet.setScore(trueScore ,sheet.kniffel(sPlayerList.players.get(truePlayer).diceCup)); 
                            scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(trueScore))));
                            p1.revalidate(); 
                            p1.repaint(); 
                            sPlayerList.players.get(truePlayer).setTurn(false);
                            if(truePlayer== sPlayerList.getSize()-1)
                            {
                                sPlayerList.players.get(0).setTurn(true);
                            }
                            else
                            {
                            sPlayerList.players.get(truePlayer+1).setTurn(true);
                            }
                            break;
                    
                        default : 
                        break;
                    }
                    
                    //Thread.sleep(1000);
                    playFrame.setVisible(false);
                    sPlayerList.players.get(truePlayer).diceCup.clearTimesRolled();

                    sPlayerList.players.get(truePlayer).scoresheet.setScore(6 , 0); 
                    scores[6].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(6))));

                    sPlayerList.players.get(truePlayer).scoresheet.setScore(7 , 0); 
                    scores[7].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(7))));

                    sPlayerList.players.get(truePlayer).scoresheet.setScore(15 , 0);
                    scores[15].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(15))));

                    sPlayerList.players.get(truePlayer).scoresheet.setScore(16 , 0); 
                    scores[16].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoresheet.getValue(sPlayerList.players.get(truePlayer).scoresheet.getTitle(16))));
 
                    p1.revalidate(); 
                    p1.repaint();
                    
                }
            });
                setScores[s] = b2;
                p1.add(b2);
            }
            

            JLabel[] dices = new JLabel[5];
            JCheckBox[] checkroll = new JCheckBox[5];

            for(int d = 0; d<5; d++)
            {
                int truedice = d;
                JLabel l1 = new JLabel();
            
                l1.setSize(new Dimension(50, 50));
                l1.setName(Integer.toString(d));
                l1.setText(Integer.toString(sPlayerList.players.get(truePlayer).diceCup.dices[truedice].getCount()));
                l1.setLocation(100+d*100, 100);
                l1.setVisible(true);
                
                dices[d] = l1;
                checkroll[d] = new JCheckBox();
                checkroll[d].setSize(new Dimension(20,20));
                checkroll[d].setLocation(200+d*100, 100);
                

                checkroll[d].addItemListener(e -> {

                    if(e.getStateChange() == ItemEvent.SELECTED)
                    {
                        sPlayerList.players.get(truePlayer).diceCup.dices[truedice].setRoll(false);  
                    }
                    else
                    {
                        sPlayerList.players.get(truePlayer).diceCup.dices[truedice].setRoll(true);
                    }

                });

                checkroll[d].setVisible(false);
                p1.add(checkroll[d]);
                
                // if(sPlayerList.players.get(truePlayer).diceCup.getTimesRolled() >= 3)
                // {
                // p1.remove(checkroll[d]);
                // }
                
            }
                for(int u = 0; u<5;u++)
                {
                    p1.add(dices[u]);
                }
                playFrame.add(p1);
            


            // JButton b = new JButton("Finish");
            
            // b.setBackground(Color.black);
            // b.setForeground(Color.white);
            // b.setLocation(200, 200);
            // b.setSize(new Dimension(100,100));
            // b.addActionListener(new ActionListener()
            // {
            //     public void actionPerformed(ActionEvent e)
            //     {
            //         playFrame.setVisible(false);
            //         sPlayerList.players.get(truePlayer).diceCup.clearTimesRolled();
                    

            //     }
            // });
            // p1.add(b);

            JButton b1 = new JButton("Roll");
            
                b1.setBackground(Color.black);
                b1.setForeground(Color.white);
                b1.setSize(new Dimension(100,100));
                b1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        for(int d = 0; d<5 ;d++)
                        {
                        checkroll[d].setVisible(true);
                        }

                        if(sPlayerList.players.get(truePlayer).diceCup.getTimesRolled() == 10)
                        { 
                           p1.remove(b1);

                           for(int d = 0; d<5;d++)
                           {
                           p1.remove(checkroll[d]);
                           }
                           p1.revalidate();
                           p1.repaint();
                        }
                        

                        sPlayerList.players.get(0).diceCup.shake();
                        for (int p = 0 ; p<5 ; p++)
                        {
                        dices[p].setText(Integer.toString(sPlayerList.players.get(truePlayer).diceCup.dices[p].getCount()));
                        sPlayerList.players.get(truePlayer).diceCup.setTimesRolled();
                        
                    }   
                }
            });
            if(sPlayerList.players.get(truePlayer).diceCup.getTimesRolled() != 15)
                        { 
                           p1.add(b1);
                        }
            
                
            
            playerFrame.add(playFrame);
        }
        
        int q = 0;
        while( q!= 99){
         for(int z = 0; z<sPlayerList.getSize();z++)
         {
             if(sPlayerList.players.get(z).getTurn() == true)
             {
             playerFrame.get(z).setVisible(true);
             }
             else
             {
                 playerFrame.get(z).setVisible(false);
             }
             
         }
        }
    }
    
    
 }

