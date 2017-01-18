package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;

import util.Enemy;
import util.Ground;
import util.Waldi;

public class Level_7 extends Level {
	
	public Level_7() {
		init();
	}

	@Override
	public void init() {
		keyW = false;
		keyS = false;
		keyA = false;
		keyD = false;
		keySpace = false;
		
		waldi = new LinkedList<>();
		waldi.add(new Waldi(320f, 50f, 20f, 4f));
		
		enemy = new LinkedList<>();
		enemy.add(new Enemy(0, 200f, 800f, 50f, 0f, 150f, true, 7f));
		enemy.add(new Enemy(0, 300f, 800f, 50f, 0f, 150f, true, 7f));
		enemy.add(new Enemy(0, 400f, 800f, 50f, 0f, 150f, true, 7f));
		enemy.add(new Enemy(0, 500f, 800f, 50f, 0f, 150f, true, 7f));
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(3, 250f, 100f, 80f, 0f));
		
		ground.add(new Ground(5, 200f, 5f, 50f, 345f));
		ground.add(new Ground(5, 600f, 5f, 50f, 645f));
		ground.add(new Ground(4, 300f, 180f, 300f, 30f));
		ground.add(new Ground(4, 5f, 330f, 340f, 30f));
		ground.add(new Ground(4, 5f, 430f, 535f, 30f));
		
		ground.add(new Ground(0, 600f, 650f, 50f, 100f));
		ground.add(new Ground(0, 400f, 580f, 20f, 100f));
		ground.add(new Ground(5, 405f, 575f, 10f, 10f));
		ground.add(new Ground(3, 120f, 570f, 100f, 0f));
		ground.add(new Ground(5, 120f, 750f, 530f, 50f));
		ground.add(new Ground(5, 120f, 575f, 50f, 175f));
		
		ground.add(new Ground(3, 5f, 890f, 800f, 0f));
	}
	@Override
	public void render(GameContainer gc, Graphics g) {
		drawWaldi(g);
		drawGround(g);
		drawEnemy(g);
	}

	@Override
	public void update(GameContainer gc) {
		keyPressed(gc);
		collisionDetectionWaldiGround();
		collisionDetectionWaldiEnemy();
		movementWaldi();
		movementEnemy();
	}

}
