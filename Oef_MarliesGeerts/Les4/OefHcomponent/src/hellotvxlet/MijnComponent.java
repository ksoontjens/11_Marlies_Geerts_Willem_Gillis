package hellotvxlet;

import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;

public class MijnComponent extends HComponent {

    int w;
    int h;
    
    public MijnComponent(int posx, int posy, int width, int height) {
        w = width;
        h = height;
        this.setBounds(posx,posy,width+5,height+5);
       
        
    }
    
    public void paint(Graphics q) {
        q.setColor(new DVBColor(0,0,0,179));
        q.fillRoundRect(5, 5, w, h, 20, 20);
        
        q.setColor(new DVBColor(10,10,100,179));
        q.fillRoundRect(0, 0, w, h, 20, 20);  
        
        q.setColor(new DVBColor(255,255,0,179));
        q.drawString("Een tekst", 15, 20);
    }
}
