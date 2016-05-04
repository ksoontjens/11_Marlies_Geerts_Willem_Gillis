package hellotvxlet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    private HScreen screen;
    private HBackgroundDevice bgDevice; 
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage agrondimg2 = new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage agrondimg3 = new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage agrondimg4 = new HBackgroundImage("pizza4.m2v");
    private HBackgroundImage[] images = new HBackgroundImage[4];
    private int activeImg = 0;
    
    private HStaticText order;
    String orderString = "Orderlist: ";
    private String[] pizzaNames = new String[4];
    
     public boolean requestRelease(ResourceProxy proxy, Object requestData) {
         return false;
     }
    public void release(ResourceProxy proxy) { }
    public void notifyRelease(ResourceProxy proxy) { }
    
     public void imageLoaded(HBackgroundImageEvent e) {
        try {
            bgConfiguration.displayImage(images[activeImg]);
        }
        catch (Exception s) {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("An image could not be loaded.");
    }
  
    public void destroyXlet(boolean unconditional)  {
        //agrondimg.flush();
        for (int i = 0; i <4; i++){
            images[i].flush();
        }
    }

    public void initXlet(XletContext ctx)  {
        screen = HScreen.getDefaultHScreen();
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        if(bgDevice.reserveDevice(this)) { //Om hier this te gebruiken, moet je resourceClient interface implementeren.
            System.out.println("BackgroundImage device has been reserved.");
        }
        else {
            System.out.println("BackgroundImage device cannot be reserved.");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED); 
        
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
    
        try {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e){
            System.out.println(e.toString());
        }
        
      //Adding arrows
      EventManager manager = EventManager.getInstance();
      
      UserEventRepository repository = new UserEventRepository("Arrows"); 
      repository.addKey(HRcEvent.VK_LEFT);
      repository.addKey(HRcEvent.VK_RIGHT);
      repository.addKey(HRcEvent.VK_ENTER);
      
      manager.addUserEventListener(this, repository);
      
      //Images to array
      images[0] = agrondimg;
      images[1] = agrondimg2;
      images[2] = agrondimg3;
      images[3] = agrondimg4;  
      
      HScene scene = HSceneFactory.getInstance().getDefaultHScene();
      order= new HStaticText(orderString, 400,50,300,400);
      order.setVerticalAlignment(HStaticText.VALIGN_TOP); //zodat tekst vanboven komt te staan
      order.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
      scene.add(order);
      scene.validate();
      scene.setVisible(true);
      
      pizzaNames[0] = "Meat \t €5,99";
      pizzaNames[1] = "Pepperoni \t €4,99";
      pizzaNames[2] = "Cheese \t €6,99";
      pizzaNames[3] = "Vegi \t €5,99";
      
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED) {
         switch (e.getCode()) {
               case HRcEvent.VK_LEFT:
                  System.out.println("Left pressed");
                  activeImg--;
                  
                  if(activeImg == -1) {activeImg = 3;}
                  //images[activeImg].load(this);
                  
                  try {
                        bgConfiguration.displayImage(images[activeImg]);
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                   }
                  
                  break;
              case HRcEvent.VK_RIGHT:
                  System.out.println("Right pressed");
                  activeImg++;
                  
                  if(activeImg == 4) {activeImg = 0;}
                  //images[activeImg].load(this);
                  
                  try {
                        bgConfiguration.displayImage(images[activeImg]);
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                   }
                  
                  break;
             case HRcEvent.VK_ENTER:
                 orderString += " \n Pizza: " + pizzaNames[activeImg];
                 order.setTextContent(orderString, HStaticText.NORMAL_STATE);
                 break;
                 
        }
        }
    }
    
    
    public void pauseXlet() {
    }

    public void startXlet(){
        //images[activeImg].load(this);
        for (int i = 0; i <4; i++){
          images[i].load(this);
        }
        
    }

 

      
    }




