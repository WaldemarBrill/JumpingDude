package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.*;
import java.util.List;
import java.util.LinkedList;

import util.Waldi;
import util.Ground;
import util.Enemy;

public abstract class Level {
	protected boolean keyW;
	protected boolean keyS;
	protected boolean keyA;
	protected boolean keyD;
	protected boolean keySpace;
	
	protected List<Waldi> waldi;
	protected List<Ground> ground;
	protected List<Enemy> enemy;
	
	public abstract void init();
	public abstract void render(GameContainer gc, Graphics g);
	public abstract void update(GameContainer gc);
	
	// ----------------------------------------------------------------------Render Section------------
	protected void drawWaldi(Graphics g) {
		for (Waldi waldi : waldi) {
			waldi.paint(g);
		}
	}
	protected void drawGround(Graphics g) {
		for (Ground ground : ground) {
			ground.paint(g);
		}
	}
	protected void drawEnemy(Graphics g) {
		for (Enemy enemy : enemy) {
			enemy.paint(g);
		}
	}
	
	
	// ----------------------------------------------------------------------Update Section------------
	/*
	 * tasten abfrage
	 * todo: collisions abfrage mit ground
	 * todo: collisions abfrage mit enemy
	 * todo: bewegung
	 * todo: enemy bewegung
	 */
	protected void keyPressed(GameContainer gc) {
		keyW = gc.getInput().isKeyDown(Input.KEY_W);
		keyS = gc.getInput().isKeyDown(Input.KEY_S);
		keyA = gc.getInput().isKeyDown(Input.KEY_A);
		keyD = gc.getInput().isKeyDown(Input.KEY_D);
		keySpace = gc.getInput().isKeyPressed(Input.KEY_SPACE);
	}
	protected boolean collisionDetectionWaldiOneGround(Ground gr) {
		for (Waldi waldi : waldi) {
			return waldi.getCollisionWithGround(gr);
		}
		return false;
	}
	protected void collisionDetectionWaldiGround() {
		for (Waldi waldi : waldi) {
			waldi.setCollisionLeft(ground);
			waldi.setCollisionRight(ground);
			waldi.setCollisionUp(ground);
			waldi.setCollisionDown(ground);
		}
	}
//	protected void collisionDetectionEnemyGround() {
//		for (Enemy enemy : enemy) {
//			enemy.setCollisionUp(ground);
//			enemy.setCollisionDown(ground);
//			enemy.setCollisionLeft(ground);
//			enemy.setCollisionRight(ground);
//		}
//	}
	protected void collisionDetectionWaldiEnemy() {
		for (Waldi waldi : waldi) {
			waldi.setCollisionUpEnemy(enemy);
			waldi.setCollisionDownEnemy(enemy);
			waldi.setCollisionLeftEnemy(enemy);
			waldi.setCollisionRightEnemy(enemy);
		}
	}
	
	protected void movementWaldi() {
		for (Waldi waldi : waldi) {
			waldi.move(keyW, keyS, keyA, keyD, keySpace);
		}
	}
	protected void movementEnemy() {
		for (Enemy e : enemy) {
			e.move();
		}
	}
}
