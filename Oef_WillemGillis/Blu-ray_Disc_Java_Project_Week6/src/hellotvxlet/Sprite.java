package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HStaticIcon;
import org.havi.ui.HVisible;

public abstract class Sprite extends HStaticIcon implements ObserverInterface{
	public Sprite(int x, int y){
		super();
		this.setLocation(x, y);
	}
}
