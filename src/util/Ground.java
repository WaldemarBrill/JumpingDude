package util;

import org.newdawn.slick.geom.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

public class Ground {
	
	private int type;	//0=Full Block,  1=SlideUp,  2=SlideDown,  3=Plate,  4=Spike
	private Shape tileBlock;
	private Color color = Color.gray;
	
	public Ground(int type, float x, float y, float length, float height) {
		this.type = type;
		if (type == 0) {
			color = Color.gray;
			tileBlock = new Rectangle(x, y, length, height);
		} else if (type == 1) {
			color = Color.green;
			Polygon p = new Polygon();
			p.addPoint(x, y+height);
			p.addPoint(x+length, y+height);
			p.addPoint(x+length, y);
			tileBlock = p;
		} else if (type == 2) {
			color = Color.green;
			Polygon p = new Polygon();
			p.addPoint(x, y);
			p.addPoint(x, y+height);
			p.addPoint(x+length, y+height);
			tileBlock = p;
		} else if (type == 3) {
			color = Color.orange;
			tileBlock = new Line(x, y, length, 0f, false);
		} else if (type == 4) {
			color = Color.red;
			Polygon p = new Polygon();
			p.addPoint(x, y+height);
			p.addPoint(x+length, y+height);
			p.addPoint(x+length*0.9f, y);
			p.addPoint(x+length*0.8f, y+height*0.5f);
			p.addPoint(x+length*0.7f, y);
			p.addPoint(x+length*0.6f, y+height*0.5f);
			p.addPoint(x+length*0.5f, y);
			p.addPoint(x+length*0.4f, y+height*0.5f);
			p.addPoint(x+length*0.3f, y);
			p.addPoint(x+length*0.2f, y+height*0.5f);
			p.addPoint(x+length*0.1f, y);
			tileBlock = p;
		} else if (type == 5) {
			color = Color.red;
			tileBlock = new Rectangle(x, y, length, height);
		} else if (type == 10) {
			color = Color.green;
			float f = 4f;
			Polygon p = new Polygon();
			p.addPoint(x, y);
			p.addPoint(x+length, y);
			p.addPoint(x+length, y+height);
			p.addPoint(x, y+height);
			p.addPoint(x, y+f);
			p.addPoint(x+f, y+f);
			p.addPoint(x+f, y+height-f);
			p.addPoint(x+length-f, y+height-f);
			p.addPoint(x+length-f, y+f);
			p.addPoint(x, y+f);
			tileBlock = p;
		}
	}
	
	public int getType() {
		return type;
	}
	
	public Shape giveShape() {
		return tileBlock;
	}
	
	public void moveUp(float delta) {
		tileBlock.setCenterY(tileBlock.getCenterY() - delta);
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fill(tileBlock);
		g.draw(tileBlock);
	}
}
