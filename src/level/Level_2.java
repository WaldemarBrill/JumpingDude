package level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;

import util.Enemy;
import util.Ground;
import util.Waldi;

public class Level_2 extends Level {
	
	public Level_2() {
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
		waldi.add(new Waldi(1380f, 50f, 20f, 4f));
		
		enemy = new LinkedList<>();
		enemy.add(new Enemy(1, 420f, 400f, 100f, 260f, 0f, true, 1.7f));
		enemy.add(new Enemy(1, 175f, 600f, 50f, 0f, 850f, true, 16f));
		
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(0, 1330f, 0f, 20f, 100f));
		ground.add(new Ground(0, 1350f, 80f, 50f, 20f));
		ground.add(new Ground(0, 1100f, 160f, 20f, 100f));
		ground.add(new Ground(5, 1105f, 155f, 10f, 5f));
		ground.add(new Ground(3, 850f, 160f, 100f, 0f));
		
		ground.add(new Ground(5, 620f, 200f, 40f, 700f));
		ground.add(new Ground(5, 540f, 0f, 40f, 700f));
		
		ground.add(new Ground(3, 250f, 840f, 300f, 0f));
		ground.add(new Ground(0, 0f, 700f, 150f, 70f));
		ground.add(new Ground(10, 5f, 650f, 50f, 50f));
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
