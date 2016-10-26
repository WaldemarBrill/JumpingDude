package util;

import org.newdawn.slick.geom.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import java.util.List;

public class Enemy {
	
	private int type;
	private float x;
	private float y;
	private float size;
	private float distX;
	private float distY;
	private float movementSpeed;
	private float movementX;
	private float movementY;
	private boolean direction;	//
	private boolean reverse;
	private Color color;
	
	private Shape[] body;
	private Shape hitbox;
	
	public Enemy(int type, float x, float y, float size, float distX, float distY, boolean direction, float movementSpeed) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.size = size;
		this.distX = distX;
		this.distY = distY;
		this.direction = direction;
		this.movementSpeed = movementSpeed;
		this.movementX = 1/(distX+distY)*distX*movementSpeed;
		this.movementY = 1/(distX+distY)*distY*movementSpeed;
		
		
		switch (type) {
		case 0:
			color = Color.gray;
			body = new Shape[1];
			body[0] = new Rectangle(x, y, size, size/4f);
			hitbox = new Rectangle(x, y, size, size/4f);
			break;
		case 1:
		case 2:
			color = Color.red;
			body = new Shape[1];
			body[0] = new Rectangle(x, y, size, size);
			hitbox = new Rectangle(x, y, size, size);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
	
	public Shape[] getBody() {
		return body;
	}
	public Shape getHitbox() {
		return hitbox;
	}
	public int getType() {
		return type;
	}
	
	public void move() {
		switch (type) {
		case 0:
		case 1:
			reverse = false;
			if (distX > distY) {
				if (hitbox.getX() > (x+distX) || hitbox.getX() < x) {
					reverse = true;
				}
			} else {
				if (hitbox.getY() > y+distY || hitbox.getY() < y) {
					reverse = true;
				}
			}
			if (reverse) {
				direction = !direction;
			}
			if (direction) {
				moveRight();
				moveDown();
			} else {
				moveLeft();
				moveUp();
			}
			break;
		case 2:
			reverse = false;
			if (distX > distY) {
				if (hitbox.getX() < x-distX || hitbox.getX() > x) {
					reverse = true;
				}
			} else {
				if (hitbox.getY() < y-distY || hitbox.getY() > y) {
					reverse = true;
				}
			}
			if (reverse) {
				direction = !direction;
			}
			if (direction) {
				moveLeft();
				moveUp();
			} else {
				moveRight();
				moveDown();
			}
			break;
		default:
			break;
		}
		
		
		
	}
	
	private void moveUp() {
		for (Shape s : body) {
			s.setCenterY(s.getCenterY() - movementY);
		}
		hitbox.setCenterY(hitbox.getCenterY() - movementY);
	}
	private void moveDown() {
		for (Shape s : body) {
			s.setCenterY(s.getCenterY() + movementY);
		}
		hitbox.setCenterY(hitbox.getCenterY() + movementY);
	}
	private void moveLeft() {
		for (Shape s : body) {
			s.setCenterX(s.getCenterX() - movementX);
		}
		hitbox.setCenterX(hitbox.getCenterX() - movementX);
	}
	private void moveRight() {
		for (Shape s : body) {
			s.setCenterX(s.getCenterX() + movementX);
		}
		hitbox.setCenterX(hitbox.getCenterX() + movementX);
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		for (Shape s : body) {
			g.fill(s);
			g.draw(s);
		}
		g.setColor(Color.green);
		g.draw(hitbox);
		g.setColor(Color.white);
	}
}
