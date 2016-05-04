package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;

public class Enemy extends SpriteObserver {
    Image mijnimg;
    int direction = 1;
    Random rnd;
    static int aantalEnemies;
    
    public Enemy(int x, int y) {
        super(x, y);
        mijnimg = this.getToolkit().getImage("schip2.png");
        MediaTracker mt = new MediaTracker(this);  //wachten tot image geladen is
        mt.addImage(mijnimg, 1);
        
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
        aantalEnemies++; 
        rnd = new Random();
        rnd.setSeed(aantalEnemies);
    }
    
    public void Update(int tijd) {
      int x = this.getX();
      int y = this.getY();
      x = x + direction;
      if (x >= 720 - mijnimg.getWidth(this)) direction = -1;
      if (x <= 0) direction = 1;
      this.setLocation(x, y);       
      
      if(rnd.nextInt(500) == 250) {        
          EnemyRocket rocket = new EnemyRocket(x+20,y+50);
          HelloTVXlet.getScene().add(rocket);
          HelloTVXlet.getPublisher().Register(rocket);
      }
    }
}
