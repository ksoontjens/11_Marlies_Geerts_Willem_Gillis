package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.event.HRcEvent;

public class HelloTVXlet implements Xlet, UserEventListener{

    HScene scene;
    MijnComponent mc;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent(50,50);
        scene.add(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
      EventManager manager = EventManager.getInstance();
      
      UserEventRepository repository = new UserEventRepository("Pijltjes"); //wat we alemaal willen gebruiken komt hierin
      
      repository.addKey(HRcEvent.VK_UP);
      repository.addKey(HRcEvent.VK_DOWN);
      repository.addKey(HRcEvent.VK_LEFT);
      repository.addKey(HRcEvent.VK_RIGHT);
      
      manager.addUserEventListener(this, repository);
      
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED) { //Als een key wordt ingeduwd.
         switch (e.getCode()) {
             case HRcEvent.VK_UP:
                 System.out.println("Up pressed");
                 mc.SetPosition(0,-10);
                 break;
             case HRcEvent.VK_DOWN:
                  System.out.println("Down pressed");
                  mc.SetPosition(0,10);
                  break;
              case HRcEvent.VK_LEFT:
                  System.out.println("Left pressed");
                  mc.SetPosition(-10,0);
                  break;
              case HRcEvent.VK_RIGHT:
                  System.out.println("Right pressed");
                  mc.SetPosition(10,0);
                  break;  
        }
        }
    }

}

