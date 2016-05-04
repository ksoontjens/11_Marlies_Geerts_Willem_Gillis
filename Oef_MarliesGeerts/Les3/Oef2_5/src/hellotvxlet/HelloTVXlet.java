package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    HTextButton button1;
    HTextButton button2; 
    HTextButton button3;
    HTextButton button4;
    HTextButton hulplijn;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      System.out.println("initXLet");
      scene = HSceneFactory.getInstance().getDefaultHScene();
     
    }

    public void startXlet() {
        System.out.println("StartXlet");
        HStaticText label = new HStaticText("Wat is de hoofdstad van België?",100,100,350,50 );  //pos x, pos y, breedte, hoogte
        label.setBackgroundMode(HVisible.BACKGROUND_FILL);
        label.setBackground(Color.LIGHT_GRAY);
        
        button1 = new HTextButton("Brussel", 100, 200, 120,50);
        button2 = new HTextButton("Antwerpen", 100, 300, 120,50);
        button3 = new HTextButton("Gent", 330, 200, 120,50);
        button4 = new HTextButton("Luik", 330, 300, 120,50);
        hulplijn = new HTextButton("Help!", 100, 400, 120,50);
        
        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button1.setBackground(Color.GRAY); 
        button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button2.setBackground(Color.GRAY); 
        button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button3.setBackground(Color.GRAY); 
        button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button4.setBackground(Color.GRAY); 
        hulplijn.setBackgroundMode(HVisible.BACKGROUND_FILL);
        hulplijn.setBackground(Color.BLUE);
        
        scene.add(button1);
        scene.add(button2);
        scene.add(button3);
        scene.add(button4);
        scene.add(hulplijn);
        
        button1.setFocusTraversal(null, button2, null, button3); //wat moet er gebeuren als men op button1 staat en men naar: boven, onder, links en rechts gaat
        button2.setFocusTraversal(button1, hulplijn, null, button4);
        button3.setFocusTraversal(null, button4, button1, null); 
        button4.setFocusTraversal(button3, null, button2, null);
        hulplijn.setFocusTraversal(button2, null, null, null);
        
        button1.setActionCommand("juist");  //dit wordt doorgestuurd als men op de knop duwt, wordt nog niet effectief iets mee gedaan zonder listener 
        button1.addHActionListener(this); //bovenaan toevoegen als interface. Moet dan import toevoegen en alle abstracte klassen hiervan ook (zie helemaal beneden voor extra abstracte methode)
        button2.setActionCommand("fout"); 
        button2.addHActionListener(this);
        button3.setActionCommand("fout");  
        button3.addHActionListener(this);
        button4.setActionCommand("fout"); 
        button4.addHActionListener(this);
        hulplijn.setActionCommand("help"); 
        hulplijn.addHActionListener(this);
        
        scene.add(label); //voegt component toe aan scene
        scene.validate();
        scene.setVisible(true); //Laat scene zien
        button1.requestFocus();  //Button staat 'actief' 
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {  //Event komt binnen. Dit doet iets bij event.
      System.out.println(event.getActionCommand()); //Toont welke actioncommand er is doorgestuurd. Dus 'button1klik' bv.
      
      if(event.getActionCommand().equals("juist")) {
        button1.setBackground(new DVBColor(15,200,40,127)); //r,g,b,alfa
        HStaticText juist = new HStaticText("Correct!!",330,400,120,50 );  //pos x, pos y, breedte, hoogte
        juist.setBackgroundMode(HVisible.BACKGROUND_FILL);
        juist.setBackground(Color.GREEN);
        scene.add(juist);
        scene.popToFront(juist);
        scene.repaint();  //nodig om wijzigingen te tonen. Scene wordt hertekend.
      }
      else if (event.getActionCommand().equals("help")) {
        scene.remove(button2);
        scene.remove(button4);
        
        button1.setFocusTraversal(null, hulplijn, null, button3);
        button3.setFocusTraversal(null, null, button1, null); 
        hulplijn.setFocusTraversal(button1, null, null, null);
        
        scene.repaint();
      }
      else {
        HStaticText fout = new HStaticText("Fout...",330,400,120,50 );  //pos x, pos y, breedte, hoogte
        fout.setBackgroundMode(HVisible.BACKGROUND_FILL);
        fout.setBackground(Color.RED);
        scene.add(fout);
        scene.popToFront(fout);
        scene.repaint();  
      }
      }
    }

