/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.util.TimerTask;
/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask{
	
	HelloTVXlet m_Xlet;
	public MijnTimerTask(HelloTVXlet xlet){
			m_Xlet = xlet;
		}
	
	public void run(){
		System.out.println("Timer method");
		m_Xlet.Callback();
	}
}
