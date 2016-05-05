/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;
/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
	int m_PosX;
	int m_PosY;
	int m_Width;
	int m_Height;
	int m_Shadow = 5;
	
	public MijnComponent(int posX, int posY, int width, int height){
		m_PosX = posX;
		m_PosY = posY;
		m_Width = width;
		m_Height = height;
		this.setBounds(m_PosX,m_PosY,m_Width+m_Shadow,m_Height+m_Shadow);
	}
	public void paint(Graphics g){
		g.setColor(new DVBColor(0,0,0,40));
		g.fillRoundRect(0,m_Shadow,m_Width,m_Height, 10, 10);
		g.setColor(new DVBColor(0,0,255,150));
		g.fillRoundRect(m_Shadow,0,m_Width,m_Height, 10, 10);
		g.setColor(new DVBColor(255,255,0,200));
		g.drawString("Tekst1", 0, 50);
	}
}
