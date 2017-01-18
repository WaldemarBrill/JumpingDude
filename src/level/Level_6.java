package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;

import util.Enemy;
import util.Ground;
import util.Waldi;

public class Level_6 extends Level {
	
	public Level_6() {
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
		waldi.add(new Waldi(20f, 230f, 20f, 4f));
		
		enemy = new LinkedList<>();
		enemy.add(new Enemy(1, 150f, 0f, 100f, 0f, 350f, true, 3f));
		enemy.add(new Enemy(1, 150f, 650f, 100f, 350f, 0f, true, 3f));
		enemy.add(new Enemy(2, 800f, 700f, 100f, 0f, 350f, true, 3f));
		
		enemy.add(new Enemy(1, 950f, 300f, 100f, 0f, 300f, true, 7f));
		enemy.add(new Enemy(2, 1050f, 600f, 100f, 0f, 300f, true, 7f));
		enemy.add(new Enemy(1, 1150f, 300f, 100f, 0f, 300f, true, 7f));
		enemy.add(new Enemy(2, 1250f, 600f, 100f, 0f, 300f, true, 7f));
		enemy.add(new Enemy(1, 1350f, 300f, 100f, 0f, 300f, true, 7f));
		enemy.add(new Enemy(2, 1450f, 600f, 100f, 0f, 300f, true, 7f));
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(0, 0f, 300f, 150f, 600f));
		ground.add(new Ground(0, 150f, 750f, 250f, 50f));
		ground.add(new Ground(0, 600f, 780f, 200f, 50f));
		ground.add(new Ground(0, 900f, 600f, 50f, 200f));
		ground.add(new Ground(5, 250f, 200f, 350f, 350f));
		
		ground.add(new Ground(3, 950f, 700f, 650f, 0f));
		
		ground.add(new Ground(10, 1545f, 650f, 50f, 50f));
		
		
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
