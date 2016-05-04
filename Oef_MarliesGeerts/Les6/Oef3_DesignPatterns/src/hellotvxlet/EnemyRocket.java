/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

public class EnemyRocket  extends SpriteObserver {
    Image mijnimg;
    
    public EnemyRocket(int x, int y) {
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
      int x = this.getX();
      int y = this.getY();
      y++;
      
      this.setLocation(x, y);  
      
      if (y > 576) {  //Indien van scherm af, verwijder het. Anders te veel objecten die nog blijven bestaan buiten het scherm
          HelloTVXlet.getScene().remove(this);
          HelloTVXlet.getPublisher().Unregister(this);
      }
      
      
    }
}
