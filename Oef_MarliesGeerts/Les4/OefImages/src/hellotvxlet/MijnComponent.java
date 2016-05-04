package hellotvxlet;

import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;

public class MijnComponent extends HComponent {

    int w;
    int h;
    int x; 
    int y;
    Image schipimg;
    
    public MijnComponent(int posx, int posy) {
               
        try {
            schipimg = this.getToolkit().getImage("schip.png"); //zetten in porgram files/technotrend/tt-mhp-browser/fileoio/dsmcc/0.0.0/
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schipimg, 0); //image, volgnummer
        
         try {
            mt.waitForAll(); 
         }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
        
        w = schipimg.getWidth(null);
        h = schipimg.getHeight(null);
        x = posx;
        y = posy;
        this.setBounds(posx,posy,w,h);
        
        
    }
    
    public void paint(Graphics q) {        
        q.drawImage(schipimg, 0, 0, null);
    }
    
    public void SetPosition(int posx, int posy) {
        x += posx;
        y += posy;
        this.setBounds(x,y,w,h); 
    
    }
}
