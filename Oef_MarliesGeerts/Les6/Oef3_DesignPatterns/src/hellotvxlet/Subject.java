package hellotvxlet;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TimerTask;
import org.havi.ui.HStaticText;

public class Subject extends TimerTask implements SubjectInterface{

    ArrayList obList = new ArrayList(); //is geen type gespecifieerd. Moet dus op het einde, als je er obj uithaalt, casten.
    int tijd = 0;
    
    public void run() {
        tijd++;
        for(int i = 0; i < obList.size(); i++){
           ((ObserverInterface)obList.get(i)).Update(tijd);
        }
        doCollisionDetectionPlayer();
    }

    public void doCollisionDetectionPlayer() {
        for(int i = 0; i < obList.size(); i++){
            Object sprite = obList.get(i);
            if(sprite.getClass() == Player.class) {
                for(int j = 0; j < obList.size(); j++)   {
                    Object sprite2 = obList.get(j);
                    if(sprite2.getClass() == EnemyRocket.class) {
                        Rectangle r2 = ((EnemyRocket)sprite2).getBounds();
                        Rectangle r1 = ((Player)sprite).getBounds();
                        if(r2.intersects(r1)) {
                            HelloTVXlet.getScene().add(new HStaticText("GAME OVER", 200,200,200,200));
                            System.out.println("Game over.");
                        }
                    }
                }
            }
        }
    }
    
    public void Register(ObserverInterface ob) {
        obList.add(ob);
    }

    public void Unregister(ObserverInterface ob) {
        obList.remove(ob);
    }

}
