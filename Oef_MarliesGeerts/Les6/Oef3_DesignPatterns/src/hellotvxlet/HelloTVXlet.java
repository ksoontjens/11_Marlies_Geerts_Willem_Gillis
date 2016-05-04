package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet{

    static HScene scene;
    static Subject publisher;  
    
    public static HScene getScene() {
        return scene;
    }
    
    public static Subject getPublisher() {
        return publisher;
    }
    
    public void initXlet(XletContext ctx)  {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        //SpriteObserver[] spritesArr = new SpriteObserver[3];
        //SpriteObserver sprite1 = new SpriteObserver(100,200);
        //scene.add(sprite1);
        //Enemy enemy1 = new Enemy(100,100);
        //scene.add(enemy1);
        
        publisher = new Subject();
        Timer time1 = new Timer();
        time1.scheduleAtFixedRate(publisher, 0, 10); //timertask, starttijd, tijd tussen elke tik
        
        //publisher.Register(sprite1);
        //publisher.Register(enemy1);
        Player pl = new Player(500,500);
        scene.add(pl);
        publisher.Register(pl);
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++) {
                Enemy enemy = new Enemy(150*i,150*j);
                scene.add(enemy);
                publisher.Register(enemy);
            }
        }
        
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() {
    }
    
    public void pauseXlet() {
    }

     public void destroyXlet(boolean unconditional) {
    }      
    }




