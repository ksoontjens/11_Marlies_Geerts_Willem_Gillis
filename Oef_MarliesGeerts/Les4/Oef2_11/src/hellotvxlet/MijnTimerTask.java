package hellotvxlet;

import java.util.TimerTask;

public class MijnTimerTask  extends TimerTask{

    HelloTVXlet xlet;
    
    public MijnTimerTask(HelloTVXlet x) {
       xlet = x;
    }
    
    public void run() {
        System.out.println("Timer Method.");
        xlet.Scroll();
    }

}
