
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


public class Gui implements ActionListener {    
    final String h = "Hilfe";
    final String c = "Credits";
    private PlayerList spielerliste = new PlayerList();
    private JMenuItem i1, i2, i3, i4, i5;
    private static JFrame frame = new JFrame();
    private List<JFrame> playerFrame = new ArrayList<>();
    private boolean finish = false;

    public Gui(){
        createMainFrame();
    }
    
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
       
        
        frame.setVisible(true);
        frame.setLocation(500, 500);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == i1){
            String name = JOptionPane.showInputDialog(frame,"Spielername", "Spieler Hinzufügen", JOptionPane.QUESTION_MESSAGE);
            Player p = new Player();
            p.setName(name);
            spielerliste.add(p);             
            JOptionPane.showMessageDialog(frame,"Der Spieler " + p.getName() + " wurde hinzugefügt");             
        }
        if(ae.getSource() == i2){
            int n = JOptionPane.showConfirmDialog(frame,"WOllen sie das Spiel wirklich Beenden","Spiel Beenden",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                frame.dispose();
                System.exit(0);
            }
        }
        if(ae.getSource() == i3){
            createGUI(spielerliste);
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

    private void decide(PlayerList sPlayerList, int truePlayer , int trueScore, String t, JLabel[] scores, JPanel p1){
        switch(t){
            case "Einer" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.adding(1,sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Zweier" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.adding(2,sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Dreier" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.adding(3,sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Vierer" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.adding(4,sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Fuenfer" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.adding(5,sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Sechser" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.adding(6,sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;                            
            case "3er" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.rowOfThree(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "4er" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.rowOfFour(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Fullhouse" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.fullHouse(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Kleine Strasse" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.shortStreet(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Große Straße" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.longStreet(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Chance" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.chance(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;
            case "Kniffel" : 
                sPlayerList.players.get(truePlayer).scoreSheet.setScore(trueScore ,Sheet.kniffel(sPlayerList.players.get(truePlayer).diceCup)); 
                scores[trueScore].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore))));
                p1.revalidate(); p1.repaint(); break;                        
            default : break;
        }

        

    }


    private void sumScore(PlayerList sPlayerList, int truePlayer, JLabel[] scores){

        sPlayerList.players.get(truePlayer).scoreSheet.setScore(6 , 0); 
        scores[6].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(6))));

        sPlayerList.players.get(truePlayer).scoreSheet.setScore(7 , 0); 
        scores[7].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(7))));

        sPlayerList.players.get(truePlayer).scoreSheet.setScore(15 , 0);
        scores[15].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(15))));

        sPlayerList.players.get(truePlayer).scoreSheet.setScore(16 , 0); 
        scores[16].setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(16))));
    }

    public void startGame(PlayerList sPlayerList){
            for(int z = 0; z<sPlayerList.getSize();z++){ 
                    playerFrame.get(z).setVisible(false);   
            }

            playerFrame.get(0).setVisible(true);
    }

    private void checkFinish(PlayerList sPlayerList){
        boolean done = false;
        for(int i = 0; i < sPlayerList.getSize();i++){
            for(int cf = 0; cf<sPlayerList.players.get(i).scoreSheet.getlength();cf++){
                done = sPlayerList.players.get(i).scoreSheet.finished();
                
            }
        }
       //TODO: Gewinner funktion (aufrufen)
        finish = done;
    }
    private void swapPlayer(PlayerList sPlayerList, int truePlayer){
        sPlayerList.players.get(truePlayer).setTurn(false);
                playerFrame.get(truePlayer).setVisible(false);
                if(truePlayer== sPlayerList.getSize()-1){
                    sPlayerList.players.get(0).setTurn(true);
                    playerFrame.get(0).setVisible(true);
                    sPlayerList.players.get(0).diceCup.clearTimesRolled();
                    sPlayerList.players.get(0).diceCup.clearDiceCup();
                } else {
                    sPlayerList.players.get(truePlayer+1).setTurn(true);
                    playerFrame.get(truePlayer+1).setVisible(true);
                    sPlayerList.players.get(truePlayer+1).diceCup.clearTimesRolled();
                    sPlayerList.players.get(0).diceCup.clearDiceCup();
                }
    }
    public void disableButton(PlayerList sPlayerList, int truePlayer, JButton b2, int trueScore){
        int tempScore = sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(trueScore));
                    if(tempScore <0){
                        b2.setVisible(true);
                    }
                    else{
                        b2.setVisible(false);
                    }
    }
     public void addRolleButton(JButton b1,JLabel[] dices){
         b1.setVisible(true);
        //  for(int i = 0; i<5;i++)
        //  {
        //      checkRoll[i].setVisible(true);
        //  }
        for(int i = 0;i<5;i++){
            dices[i].setText(Integer.toString(0));
        }
         
    }

    private void createGUI(PlayerList sPlayerList)
    {
        sPlayerList.players.get(0).setTurn(true);
        
        for(int i = 0; i<sPlayerList.getSize();i++){
            int truePlayer = i;            
            JFrame playFrame = new JFrame();

            playFrame.setDefaultCloseOperation(0);
            playFrame.setSize(900,900);   
            playFrame.setTitle(sPlayerList.players.get(i).getName());
            playFrame.setName(Integer.toString(i));
            playFrame.setLayout(new BorderLayout());            
            playFrame.setVisible(true);
            playFrame.setLocation(100, 100);

            JPanel p1 = new JPanel();
            p1.setLayout(new FlowLayout(FlowLayout.CENTER));
            JPanel p2 = new JPanel();
            p2.setLayout(new GridLayout(7,3));
            JPanel p3 = new JPanel();
            p3.setLayout(new GridLayout(7,3));
            JPanel p4 = new JPanel();
            p4.setLayout(new GridLayout(8,1));


            JLabel[] scoresName = new JLabel[sPlayerList.players.get(i).scoreSheet.getlength()];
            JLabel[] scores = new JLabel[sPlayerList.players.get(i).scoreSheet.getlength()];
            JButton[] setScores = new JButton[sPlayerList.players.get(i).scoreSheet.getlength()];

            

            JLabel[] dices = new JLabel[5];
            JCheckBox[] checkroll = new JCheckBox[5];

            for (int d = 0; d<5; d++){
                int truedice = d;
                JLabel l1 = new JLabel();
            
                //Erzeugt 5 Labels welche die Werte der Würfel dastellen
                l1.setSize(new Dimension(50, 50));
                l1.setName(Integer.toString(d));
                l1.setText(Integer.toString(sPlayerList.players.get(truePlayer).diceCup.dices[truedice].getCount()));
                l1.setLocation(100+d*100, 100);
                l1.setVisible(true);
                dices[d] = l1;

                //Erzeugt 5 Checkboxen , welche (wenn angeglickt) die Würfel nicht Würfeln lassen
                checkroll[d] = new JCheckBox();
                checkroll[d].setSize(new Dimension(20,20));
                checkroll[d].setLocation(200+d*100, 100);
                checkroll[d].addItemListener(e -> {
                    if(e.getStateChange() == ItemEvent.SELECTED) {
                        sPlayerList.players.get(truePlayer).diceCup.dices[truedice].setRoll(false);  
                    } else {
                        sPlayerList.players.get(truePlayer).diceCup.dices[truedice].setRoll(true);
                    }
                });

                checkroll[d].setVisible(false);
               
                
               
                
            }
                
            playFrame.add(p1,BorderLayout.NORTH);

            //erzeugt den Würfel Button und sobald dieser Betätigt wurde und alle Würfel gewürfelt wurde werden die CheckBoxen auf Visible gesetzt
            JButton b1 = new JButton("Roll");
            
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b1.setSize(new Dimension(100,100));
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for(int d = 0; d<5 ;d++){
                        checkroll[d].setVisible(true);
                    }

                    if(sPlayerList.players.get(truePlayer).diceCup.getTimesRolled() == 10){ 
                        b1.setVisible(false);
                        for(int d = 0; d<5;d++){
                            checkroll[d].setVisible(false);
                        }
                        p1.revalidate(); p1.repaint();
                    }                

                    sPlayerList.players.get(truePlayer).diceCup.shake();
                    for (int p = 0 ; p<5 ; p++){
                        dices[p].setText(Integer.toString(sPlayerList.players.get(truePlayer).diceCup.dices[p].getCount()));
                        sPlayerList.players.get(truePlayer).diceCup.setTimesRolled();                    
                    }   
                }
            });
            
            // JButton[] eintragen = new JButton[sPlayerList.players.get(truePlayer).scoreSheet.getlength()];
            // JLabel[] namen = new JLabel[sPlayerList.players.get(truePlayer).scoreSheet.getlength()];
            // JLabel[] werte = new JLabel[sPlayerList.players.get(truePlayer).scoreSheet.getlength()];
            
            for(int s = 0 ; s<sPlayerList.players.get(i).scoreSheet.getlength()-1; s++){
                int trueScore = s;
                JLabel l2 = new JLabel();

                //l2.setSize(new Dimension(50, 50));
                l2.setName(Integer.toString(s));
                l2.setText(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(s));
                l2.setLocation(100+s*100, 100);
                l2.setVisible(true);
                scoresName[s] = l2;
                

                JLabel l3 = new JLabel();
                //l3.setSize(new Dimension(50, 50));
                l3.setName(Integer.toString(s));
                if (sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(s)) < 0) {
                    l3.setText("0");
                } else {
                    l3.setText(Integer.toString(sPlayerList.players.get(truePlayer).scoreSheet.getValue(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(s))));
                }
                l3.setLocation(100+s*100, 100);
                l3.setVisible(true);
                scores[s] = l3;
                

                JButton b2 = new JButton();
                //b2.setSize(new Dimension(50, 50));
                b2.setName(sPlayerList.players.get(truePlayer).scoreSheet.getTitle(s));
                b2.setText("Eintragen");
                b2.setLocation(100+s*100, 100);
                
                if(trueScore== 6 || trueScore==7 || trueScore==15 || trueScore==16) {
                    b2.setVisible(false);
                } else {
                    b2.setVisible(true);
                }
                b2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        JButton b3 = (JButton)e.getSource();
                        String t = b3.getName();
                        decide(sPlayerList , truePlayer , trueScore, t, scores , p1);
                        disableButton(sPlayerList, truePlayer, b2, trueScore);
                        sumScore(sPlayerList, truePlayer, scores);
                        checkFinish(sPlayerList);
                        swapPlayer(sPlayerList, truePlayer);
                        addRolleButton(b1, dices);
                        p1.revalidate(); 
                        p1.repaint();
                        
                    }
                });
                setScores[s] = b2;
                
            }
            for(int k=0; k<5;k++)
            {
                p1.add(dices[k]);
                p1.add(checkroll[k]);
            }
            if(sPlayerList.players.get(truePlayer).diceCup.getTimesRolled() != 15){ 
                p1.add(b1);
            }
            for(int l = 0; l<sPlayerList.players.get(truePlayer).scoreSheet.getlength()/2-1;l++)
            {
                p2.add(scoresName[l]);
                p2.add(scores[l]);
                p2.add(setScores[l]);
                if(l== 6 || l==7 || l==15 || l==16) {
                    p2.remove(scoresName[l]);
                    p2.remove(scores[l]);
                    p2.remove(setScores[l]);
             }
            }
            for(int o = 8; o<sPlayerList.players.get(truePlayer).scoreSheet.getlength();o++){
                p3.add(scoresName[o]);
                p3.add(scores[o]);
                p3.add(setScores[o]);
                if(o== 6 || o==7 || o==15 || o==16) {
                   p3.remove(scoresName[o]);
                   p3.remove(scores[o]);
                   p3.remove(setScores[o]);
            }
            for(int m = 0; m<sPlayerList.players.get(truePlayer).scoreSheet.getlength();m++){
                if(m==6 || m==7 || m==15|| m==16){
                    p4.add(scoresName[m]);
                    p4.add(scores[m]);
                }
            }
            playFrame.add(p2,BorderLayout.WEST);
            playFrame.add(p3,BorderLayout.EAST);
            playFrame.add(p4,BorderLayout.CENTER);
            playerFrame.add(playFrame);
        }
    }        
 }
}