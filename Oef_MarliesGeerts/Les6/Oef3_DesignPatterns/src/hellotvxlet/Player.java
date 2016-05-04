package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;

public class Player extends SpriteObserver  {
 Image mijnimg;
    
    public Player(int x, int y) {
        super(x, y);
        mijnimg = this.getToolkit().getImage("send.png");
        MediaTracker mt = new MediaTracker(this);  //wachten tot image geladen is
        mt.addImage(mijnimg, 1);
        
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setResizeMode(Image.SCALE_FAST);
        this.setSize(mijnimg.getWidth(this)/2, mijnimg.getHeight(this)/2);
    }

    public void Update(int tijd) {
    }
    
    
}
