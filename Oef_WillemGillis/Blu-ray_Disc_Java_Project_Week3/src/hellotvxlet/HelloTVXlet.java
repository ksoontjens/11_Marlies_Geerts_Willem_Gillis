package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {
    HScene scene;
	String answer = "Kippen";
	HTextButton answer1;
	HTextButton answer2;
	HTextButton answer3;
	HTextButton answer4;
	HTextButton hulplijn;
	
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        System.out.println("initXlet");
		scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
		System.out.println("startXlet");
		HStaticText label = new HStaticText("Wat heeft Marlies niet gezegd? Voor 15:00 op donderdag 10/12/2015",10,100,400,50);
		hulplijn = new HTextButton("Hulplijn aanvragen",10,450,400,50);
		answer1 = new HTextButton("Hanen",10,250,100,100);
		answer2 = new HTextButton("5 ppixels",110,250,100,100);
		answer3 = new HTextButton("Ok",210,250,100,100);
		answer4 = new HTextButton("Humff",310,250,100,100);
		answer1.setFocusTraversal(null, null, hulplijn, answer2);
		answer2.setFocusTraversal(null, null, answer1, answer3);
		answer3.setFocusTraversal(null, null, answer2, answer4);
		answer4.setFocusTraversal(null, null, answer3, hulplijn);
		hulplijn.setFocusTraversal(null, null, answer4, answer1);
		label.setBackgroundMode(HVisible.BACKGROUND_FILL);
		label.setBackground(Color.BLACK);
		
		answer1.setActionCommand("button1klik");
		answer1.addHActionListener(this);
		answer2.setActionCommand("button2klik");
		answer2.addHActionListener(this);
		answer3.setActionCommand("button3klik");
		answer3.addHActionListener(this);
		answer4.setActionCommand("button4klik");
		answer4.addHActionListener(this);
		hulplijn.setActionCommand("hulplijn");
		hulplijn.addHActionListener(this);
		scene.add(label);
		scene.add(answer1);
		scene.add(answer2);
		scene.add(answer3);
		scene.add(answer4);
		scene.add(hulplijn);
		scene.validate();
		scene.setVisible(true);
		answer1.requestFocus();
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("button1klik")){	
			answer1.setBackground(Color.green);
			answer1.setTextContent("Dat is correct!", 0);
			scene.repaint();
		}else if (arg0.getActionCommand().equals("button2klik")){
			answer2.setBackground(Color.red);
			answer2.setTextContent("Fout, het juiste antwoord was: " + answer, 0);
			answer1.setBackground(Color.green);
			answer1.setTextContent("Dat is correct!", 0);
			scene.repaint();
		}else if (arg0.getActionCommand().equals("button3klik")){
			answer3.setBackground(Color.red);
			answer3.setTextContent("Fout, het juiste antwoord was: " + answer, 0);
			answer1.setBackground(Color.green);
			answer1.setTextContent("Dat is correct!", 0);
			scene.repaint();
		}else if (arg0.getActionCommand().equals("button4klik")){
			answer4.setBackground(Color.red);
			answer4.setTextContent("Fout, het juiste antwoord was: " + answer, 0);
			answer1.setBackground(Color.green);
			answer1.setTextContent("Dat is correct!", 0);
			scene.repaint();
		}else if(arg0.getActionCommand().equals("hulplijn")){
			scene.remove(answer2); 
			scene.remove(answer4);
			scene.remove(hulplijn);
			answer1.setFocusTraversal(null, null, answer3, answer3);
			answer3.setFocusTraversal(null, null, answer1, answer1);
			scene.repaint();
		}
		System.out.println(arg0.getActionCommand());
	}
}
