package hellotvxlet;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TimerTask;
import org.havi.ui.HStaticText;

public class Subject extends TimerTask implements SubjectInterface {
	ArrayList oblijst = new ArrayList();
	int tijd = 0;
	static boolean isPlaying = true;
	public void run() {
		if (isPlaying) {
			tijd++;
			for (int i = 0; i < oblijst.size(); i++) {
				((ObserverInterface)oblijst.get(i)).Update(tijd);
			}
			CollisionDetection();
		}
	}

	public void Register(ObserverInterface ob) {
		oblijst.add(ob);
	}

	public void Unregister(ObserverInterface ob) {
		oblijst.remove(ob);
	}
	
	public void CollisionDetection(){
		for(int i = 0; i<oblijst.size();i++){
			Object sprite = oblijst.get(i);
			if (sprite.getClass()==Player.class) {
				for (int j = 0; j < oblijst.size(); j++) {
					Object sprite2 = oblijst.get(j);
					if (sprite2.getClass() == EnemyRocket.class) {
						Rectangle r2 = ((EnemyRocket)sprite2).getBounds();
						Rectangle r1 = ((Player)sprite).getBounds();
						if (r2.intersects(r1)) {
							System.out.println("GAME OVER!!!");
							HelloTVXlet.getScene().add(new HStaticText("GAME OVER!!!",250,250,250,250));
							isPlaying= false;
						}
					}
				}
			}
		}
	}
	
}
