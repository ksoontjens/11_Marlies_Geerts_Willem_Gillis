package hellotvxlet;

import java.awt.event.*;
import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.dvb.event.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {
    HScene scene;
	int m_PosX = 300;
	int m_PosY = 300;
	
	MijnComponent mc = new MijnComponent(150,150,100,100);
	MijnComponentImage mci = new MijnComponentImage("icon128-2x.png", m_PosX,m_PosY);
	MijnComponentImage mci2 = new MijnComponentImage("hggreenNEU.jpg", 0,0);
	
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
		scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
		System.out.println("startXlet");
		
		scene.add(mc);
		scene.add(mci);
		scene.add(mci2);
		scene.validate();
		scene.setVisible(true);
		
		EventManager manager = EventManager.getInstance();
		UserEventRepository repository = new UserEventRepository("Voorbeeld");
		repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
		repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
		repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
		repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
		manager.addUserEventListener(this, repository);
		
		MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(objMijnTimerTask, 0, 17);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

	public void userEventReceived(UserEvent e) {
		if(e.getType() == KeyEvent.KEY_PRESSED){
			System.out.println("Pushed Button");
			switch(e.getCode()){
				case HRcEvent.VK_UP:
					System.out.println("VK_UP is PRESSED");
					mci.setPosition(m_PosX, --m_PosY);
					break;
				case HRcEvent.VK_DOWN:
					System.out.println("VK_DOWN is PRESSED");
					mci.setPosition(m_PosX, ++m_PosY);
					break;
				case HRcEvent.VK_LEFT:
					System.out.println("VK_LEFT is PRESSED");
					mci.setPosition(--m_PosX, m_PosY);
					break;
				case HRcEvent.VK_RIGHT:
					System.out.println("VK_RIGHT is PRESSED");
					mci.setPosition(++m_PosX, m_PosY);
					break;
			}
			scene.repaint();
		}
	}
	
	public void Callback(){
		mci2.moveDown();
	}
}
