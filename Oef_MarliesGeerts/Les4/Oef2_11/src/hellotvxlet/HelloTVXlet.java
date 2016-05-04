package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet {

    HScene scene;
    MijnComponent mc;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent();
        scene.add(mc);
        
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void Scroll() {
        mc.Scroll();
    }
    
    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
      
      }
    }




