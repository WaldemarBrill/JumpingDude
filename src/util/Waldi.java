package util;

import org.newdawn.slick.geom.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import java.util.List;
import util.Ground;
import view.Slick2d;
import util.Enemy;

public class Waldi {
	private boolean jumping = false;
	private boolean jumpable = false;
	private boolean jumpableLeft = false;
	private boolean jumpableRight = false;
	
	private float gameSpeed;
	private float jumpForce;
	private float wallJumpLeft;
	private float wallJumpRight;
	
	
	
	
	
	
	
	
	
	
	
	private boolean collisionUp = false;
	private boolean collisionLeft = false;
	private boolean collisionRight = false;
	private boolean collisionDown = false;
	private boolean[] collisionCollection;
	
	private boolean collisionUpEnemy = false;
	private boolean collisionLeftEnemy = false;
	private boolean collisionRightEnemy = false;
	private boolean collisionDownEnemy = false;
	
	private Rectangle hitboxTop;
	private Rectangle hitboxLeft;
	private Rectangle hitboxRight;
	private Rectangle hitboxBot;
	private Shape[] hitboxCollection;
	
	private Line armLeft;
	private Line armRight;
	private Line belly;
	private Circle head;
	private Line legLeft;
	private Line legRight;
	private Shape[] body;

	private float xCentral;
	private float yCentral;
	private float size;
	private float armHeight;
	private float armLength;
	private float legDepart;
	private float delta;
	
	public Waldi(float x, float y, float pSize, float d) {
		jumpable = false;
		jumping = false;
		jumpableLeft = false;
		jumpableRight = false;
		jumpForce = 0f;
		wallJumpLeft = 0f;
		wallJumpRight = 0f;
		gameSpeed = d;
		
		xCentral = x;
		yCentral = y;
		size = pSize*0.7f;
		armHeight = d;
		armLength = size*0.5f;
		legDepart = size*0.5f;
		delta = d+2f;
		
		collisionCollection = new boolean[4];
		collisionCollection[0] = collisionUp;
		collisionCollection[1] = collisionLeft;
		collisionCollection[2] = collisionRight;
		collisionCollection[3] = collisionDown;
		
		armLeft = new Line(xCentral, yCentral, -armLength , -armHeight, false);
		armRight = new Line(xCentral, yCentral, armLength, -armHeight, false);
		belly = new Line(xCentral, (yCentral-size*0.5f), 0f, (size*1.5f), false);
		head = new Circle(xCentral, yCentral-(size), (size*0.5f));
		legLeft = new Line(xCentral, yCentral+(size), -legDepart, size, false);
		legRight = new Line(xCentral, yCentral+(size), legDepart, size, false);	
		
		body = new Shape[6];
		body[0] = armLeft;
		body[1] = armRight;
		body[2] = belly;
		body[3] = head;
		body[4] = legLeft;
		body[5] = legRight;
		
		hitboxTop = new Rectangle(xCentral-size*0.5f+delta, yCentral-size-size*0.5f, size-delta*2f, delta);
		hitboxLeft = new Rectangle(xCentral-armLength, yCentral-size-size*0.5f+delta, armLength, size*3f+size*0.5f-delta*2f);
		hitboxRight = new Rectangle(xCentral, yCentral-size-size*0.5f+delta, armLength, size*3f+size*0.5f-delta*2f);
		hitboxBot = new Rectangle(xCentral-legDepart+delta*0.5f, yCentral+size+size-delta, legDepart*2f-delta, delta);
		
		hitboxCollection = new Shape[4];
		hitboxCollection[0] = hitboxTop;
		hitboxCollection[1] = hitboxLeft;
		hitboxCollection[2] = hitboxRight;
		hitboxCollection[3] = hitboxBot;
	}
	
	public Shape[] getBody() {
		return body;
	}
	public void setBody(Shape[] body) {
		this.body = body;
	}
	
	public boolean isCollisionLeft() {
		return collisionLeft;
	}
	public void setCollisionLeft(boolean collisionLeft) {
		this.collisionLeft = collisionLeft;
	}
	
	public boolean isCollisionRight() {
		return collisionRight;
	}
	public void setCollisionRight(boolean collisionRight) {
		this.collisionRight = collisionRight;
	}
	
	public boolean isCollisionUp() {
		return collisionUp;
	}
	public void setCollisionUp(boolean collisionUp) {
		this.collisionUp = collisionUp;
	}
	
	public boolean isCollisionDown() {
		return collisionDown;
	}
	public void setCollisionDown(boolean collisionDown) {
		this.collisionDown = collisionDown;
	}
	
	public Rectangle getHitboxTop() {
		return hitboxTop;
	}

	public void setHitboxTop(Rectangle hitboxTop) {
		this.hitboxTop = hitboxTop;
	}

	public Rectangle getHitboxLeft() {
		return hitboxLeft;
	}

	public void setHitboxLeft(Rectangle hitboxLeft) {
		this.hitboxLeft = hitboxLeft;
	}

	public Rectangle getHitboxRight() {
		return hitboxRight;
	}

	public void setHitboxRight(Rectangle hitboxRight) {
		this.hitboxRight = hitboxRight;
	}

	public Rectangle getHitboxBot() {
		return hitboxBot;
	}

	public void setHitboxBot(Rectangle hitboxBot) {
		this.hitboxBot = hitboxBot;
	}
	
	public Shape[] getHitboxCollection() {
		return hitboxCollection;
	}
	
	public void applyGravity(float delta) {
		if (!collisionDown) {
			moveDown(delta*1.5f);
		}
	}
	public void moveUp(float delta) {
		for (Shape s : body) {
			s.setCenterY(s.getCenterY() - delta);
		}
		for (Shape s : hitboxCollection) {
			s.setCenterY(s.getCenterY() - delta);
		}
	}
	public void moveDown(float delta) {
		for (Shape s : body) {
			s.setCenterY(s.getCenterY() + delta);
		}
		for (Shape s : hitboxCollection) {
			s.setCenterY(s.getCenterY() + delta);
		}
	}
	public void moveLeft(float delta) {
		for (Shape s : body) {
			s.setCenterX(s.getCenterX() - delta);
		}
		for (Shape s : hitboxCollection) {
			s.setCenterX(s.getCenterX() - delta);
		}
	}
	public void moveRight(float delta) {
		for (Shape s : body) {
			s.setCenterX(s.getCenterX() + delta);
		}
		for (Shape s : hitboxCollection) {
			s.setCenterX(s.getCenterX() + delta);
		}
	}
	public void paint(Graphics g) {
		g.setColor(Color.white);
		for (Shape s : body) {
			g.draw(s);
		}
//		g.setColor(Color.green);
//		for (Shape s : hitboxCollection) {
//			g.draw(s);
//		}
//		g.setColor(Color.white);
	}

	
	
	
	
	
	
	
	
	
	
	public void move(boolean w, boolean s, boolean a, boolean d, boolean space) {
		if (jumping && jumpForce > 0f) {
			if (collisionUp || collisionUpEnemy) {
				jumpForce = 1.2f;
			}
			moveUp(gameSpeed*jumpForce);
			jumpForce -= 0.1f;
		}
		if (wallJumpLeft > 0f && (!collisionRight || !collisionRightEnemy)) {
			moveRight(wallJumpLeft*gameSpeed);
		}
		if (wallJumpRight > 0f && (!collisionLeft || !collisionLeftEnemy)) {
			moveLeft(wallJumpRight*gameSpeed);
		}
		wallJumpLeft -= 0.4f;
		wallJumpRight -= 0.4f;
		if (a) {
			if (!collisionLeft && !collisionLeftEnemy) {
				moveLeft(gameSpeed);
			} else {
				if (space && jumping && jumpableLeft) {
					jumpableRight = true;
					jumpableLeft = false;
					jumpForce = 4f;
					wallJumpLeft = 3f;
				}
			}
		}
		if (d) {
			if (!collisionRight && !collisionRightEnemy) {
				moveRight(gameSpeed);
			} else {
				if (space && jumping && jumpableRight) {
					jumpableRight = false;
					jumpableLeft = true;
					jumpForce = 4f;
					wallJumpRight = 3f;
				}
			}
		}
		
		if (collisionDown || collisionDownEnemy) {
			jumping = false;
			jumpable = true;
			jumpableRight = false;
			jumpableLeft = false;
		} else {
			applyGravity(gameSpeed);
		}
		if (space && jumpable) {
			jumpable = false;
			jumping = true;
			jumpForce = 4f;
			jumpableRight = true;
			jumpableLeft = true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setCollisionUp(List<Ground> ground) {
		for (Ground gr : ground) {
			if (hitboxTop.intersects(gr.giveShape())) {
				switch(gr.getType()) {
				case 0:
				case 1:
				case 2:
				case 4:
					collisionUp = true;
					return;
				case 3:
					break;
				case 5:
					Slick2d.DEAD = true;
					break;
				case 10:
					Slick2d.LEVELUP = true;
					break;
				default:
					break;
				}
			}
		}
		collisionUp = false;
	}
	public void setCollisionDown(List<Ground> ground) {
		if (!(jumpForce > 1.0f)) {
			for (Ground gr : ground) {
				if (hitboxBot.intersects(gr.giveShape())) {
					switch (gr.getType()) {
					case 4:
					case 5:
						Slick2d.DEAD = true;
						break;
					case 10:
						Slick2d.LEVELUP = true;
						break;
					default:
						break;
					}
					moveUp(hitboxBot.getMaxY()-gr.giveShape().getMinY());
					if (!hitboxBot.intersects(gr.giveShape())) {
						moveDown(1f);
					}
					collisionDown = true;
					return;
				}
			}
		}
		collisionDown = false;
	}
	public void setCollisionLeft(List<Ground> ground) {
		for (Ground gr : ground) {
			if (hitboxLeft.intersects(gr.giveShape())) {
				switch(gr.getType()) {
				case 0:
				case 1:
				case 2:
					moveRight(gr.giveShape().getMaxX()-hitboxLeft.getMinX());
					if (!hitboxLeft.intersects(gr.giveShape())) {
						moveLeft(1f);
					}
					collisionLeft = true;
					return;
				case 3:
					break;
				case 4:
				case 5:
					Slick2d.DEAD = true;
					break;
				case 10:
					Slick2d.LEVELUP = true;
					break;
				default:
					break;
				}
			}
		}
		collisionLeft = false;
	}
	public void setCollisionRight(List<Ground> ground) {
		for (Ground gr : ground) {
			if (hitboxRight.intersects(gr.giveShape())) {
				switch(gr.getType()) {
				case 0:
				case 1:
				case 2:
					moveLeft(hitboxRight.getMaxX()-gr.giveShape().getMinX());
					if (!hitboxRight.intersects(gr.giveShape())) {
						moveRight(1f);
					}
					collisionRight = true;
					return;
				case 3:
					break;
				case 4:
				case 5:
					Slick2d.DEAD = true;
					break;
				case 10:
					Slick2d.LEVELUP = true;
					break;
				default:
					break;
				}
			}
		}
		collisionRight = false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setCollisionUpEnemy(List<Enemy> enemy) {
		for (Enemy en : enemy) {
			if (hitboxTop.intersects(en.getHitbox())) {
				switch(en.getType()) {
				case 0:
					collisionUpEnemy = true;
					return;
				case 1:
				case 2:
					Slick2d.DEAD = true;
					break;
				default:
					break;
				}
			}
		}
		collisionUpEnemy = false;
	}
	public void setCollisionDownEnemy(List<Enemy> enemy) {
		if (!(jumpForce > 1.0f)) {
			for (Enemy en : enemy) {
				if (hitboxBot.intersects(en.getHitbox())) {
					switch (en.getType()) {
					case 0:
						break;
					case 1:
					case 2:
						Slick2d.DEAD = true;
						break;
					default:
						break;
					}
					moveUp(hitboxBot.getMaxY()-en.getHitbox().getMinY());
					if (!hitboxBot.intersects(en.getHitbox())) {
						moveDown(1f);
					}
					collisionDownEnemy = true;
					return;
				}
			}
		}
		collisionDownEnemy = false;
	}
	public void setCollisionLeftEnemy(List<Enemy> enemy) {
		for (Enemy en : enemy) {
			if (hitboxLeft.intersects(en.getHitbox())) {
				switch(en.getType()) {
				case 0:
					moveRight(en.getHitbox().getMaxX()-hitboxLeft.getMinX());
					if (!hitboxLeft.intersects(en.getHitbox())) {
						moveLeft(1f);
					}
					collisionLeftEnemy = true;
					return;
				case 1:
				case 2:
					Slick2d.DEAD = true;
					break;
				default:
					break;
				}
			}
		}
		collisionLeftEnemy = false;
	}
	public void setCollisionRightEnemy(List<Enemy> enemy) {
		for (Enemy en : enemy) {
			if (hitboxRight.intersects(en.getHitbox())) {
				switch(en.getType()) {
				case 0:
					moveLeft(hitboxRight.getMaxX()-en.getHitbox().getMinX());
					if (!hitboxRight.intersects(en.getHitbox())) {
						moveRight(1f);
					}
					collisionRightEnemy = true;
					return;
				case 1:
				case 2:
					Slick2d.DEAD = true;
					break;
				default:
					break;
				}
			}
		}
		collisionRightEnemy = false;
	}
}
