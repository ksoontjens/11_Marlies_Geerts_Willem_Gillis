package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HStaticIcon;
import org.havi.ui.HVisible;

public abstract class SpriteObserver extends HStaticIcon implements ObserverInterface { //abstract omdat update methode hier nu niet meer in zit, en dan moet die niet meer erin staan

    public SpriteObserver(int x, int y){
        super(); //constructor van de superklasse aanroepen. Moet je eerst doen als je overerft.
        this.setLocation(x,y);
        this.setSize(50,50);
        this.setBackground(Color.YELLOW);
        this.setBackgroundMode(HVisible.BACKGROUND_FILL);
    }

  //  public void Update(int tijd) {
    //  int x = this.getX();
      //int y = this.getY();
      //x++;
      //this.setLocation(x, y);       
    //}
}
