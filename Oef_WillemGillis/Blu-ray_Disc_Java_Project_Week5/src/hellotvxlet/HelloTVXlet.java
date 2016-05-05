package hellotvxlet;

import java.awt.event.*;
import javax.tv.xlet.*;
import org.davic.resources.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {
	HScene scene;
	private HScreen screen;
	private HBackgroundDevice bgDevice;
	private HBackgroundConfigTemplate bgTemplate;
	private HStillImageBackgroundConfiguration bgConfiguration;
	private HBackgroundImage[] agroundimg = {new HBackgroundImage("pizza1.m2v"), new HBackgroundImage("pizza2.m2v"), new HBackgroundImage("pizza3.m2v"),new HBackgroundImage("pizza4.m2v")};
	private char agroundImageIndex = 0;
	private String order = "Order:\n";
	private HStaticText label = new HStaticText(order, 370,70,400,300);
	
	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
		System.out.println("pauseXlet");
		for (int i = 0; i < agroundimg.length; i++) {
			agroundimg[i].flush();	
			System.out.println(i + " was flushed");
		}
	}

	public void initXlet(XletContext ctx) throws XletStateChangeException {
		scene = HSceneFactory.getInstance().getDefaultHScene();
		
		screen = HScreen.getDefaultHScreen();
		bgDevice = screen.getDefaultHBackgroundDevice();
		if(bgDevice.reserveDevice(this)){
			System.out.println("BackgroundImage device was reserved");
		}else{
			System.out.println("BackgroundImage device cannot be reserved");
		}
		
		bgTemplate = new HBackgroundConfigTemplate();
		bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
		bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
		try {
			bgDevice.setBackgroundConfiguration(bgConfiguration);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void pauseXlet() {
		System.out.println("pauseXlet");
	}

	public void startXlet() throws XletStateChangeException {
		System.out.println("startXlet");	
		label.setVerticalAlignment(HStaticText.VALIGN_TOP);
		label.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
		scene.add(label);
		scene.validate();
		scene.setVisible(true);
		
		for (int i = 0; i < agroundimg.length; i++) {
			agroundimg[i].load(this);	
		}

		EventManager manager = EventManager.getInstance();
		UserEventRepository repository = new UserEventRepository("Voorbeeld");
		repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
		repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
		repository.addKey(org.havi.ui.event.HRcEvent.VK_ENTER);
		manager.addUserEventListener(this, repository);
	}

	public boolean requestRelease(ResourceProxy proxy, Object requestData) {
		return false;
	}

	public void release(ResourceProxy proxy) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void notifyRelease(ResourceProxy proxy) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void imageLoaded(HBackgroundImageEvent e) {
		try {
			bgConfiguration.displayImage(agroundimg[0]);
		} catch (Exception s) {
			System.out.println(s.toString());
		}	
	}

	public void imageLoadFailed(HBackgroundImageEvent e) {
		System.out.println("Image kan niet geladen worden.");
	}

	public void userEventReceived(UserEvent e) {
		if(e.getType() == KeyEvent.KEY_PRESSED){
			switch(e.getCode()){
				case HRcEvent.VK_LEFT:
					System.out.println("VK_LEFT is PRESSED");
					--agroundImageIndex;
					break;
				case HRcEvent.VK_RIGHT:
					System.out.println("VK_RIGHT is PRESSED");
					++agroundImageIndex;
					break;
				case HRcEvent.VK_ENTER:
					switch(agroundImageIndex){
						case 0:
							order += "Pizza: Meat Lover's     4.99$\n";
							break;
						case 1:
							order += "Pizza: Pepperoni Lover's     4.99$\n";
							break;
						case 2:
							order += "Pizza: Cheese Lover's     4.99$\n";
							break;
						case 3:
							order += "Pizza: Vegi Lover's     4.99$\n";
							break;
					}
					label.setTextContent(order, HStaticText.NORMAL_STATE);
					scene.repaint();
					break;
			}
			if (e.getCode() == HRcEvent.VK_LEFT || e.getCode() == HRcEvent.VK_RIGHT) {
				agroundImageIndex%= 4;
				System.out.println((int)agroundImageIndex + " is active");
				try {
					bgConfiguration.displayImage(agroundimg[agroundImageIndex]);
				} catch (Exception s) {
					System.out.println(s.toString());
				}
			}
		}
	}
}
