package hellotvxlet;

import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;

public class MijnComponent extends HComponent {

    int w;
    int h;
    int y = 0;
    Image skyimg;
    
    public MijnComponent() {
               
        try {
            skyimg = this.getToolkit().getImage("sterren.jpg"); 
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(skyimg, 0);
        
         try {
            mt.waitForAll(); 
         }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
        
        w = skyimg.getWidth(null);
        h = skyimg.getHeight(null);
        this.setBounds(0,0,w,h);
        
        
    }
    
    public void paint(Graphics q) {        
        q.drawImage(skyimg, 0, 0, null);
    }
    
    public void Scroll() {
        y-=2;
        y = y%(h-600);
                
        this.setBounds(0,y,w,h);
    }
    }
