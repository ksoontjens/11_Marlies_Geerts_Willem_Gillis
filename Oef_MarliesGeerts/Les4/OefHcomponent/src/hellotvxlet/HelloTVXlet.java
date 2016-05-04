package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet{

    HScene scene;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        MijnComponent mc = new MijnComponent(50,50,250,250);
        scene.add(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
        
    }

}

