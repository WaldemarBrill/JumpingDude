package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;

import util.Enemy;
import util.Ground;
import util.Waldi;

public class Level_3 extends Level {
	
	public Level_3() {
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
		waldi.add(new Waldi(50f, 750f, 20f, 4f));
		
		enemy = new LinkedList<>();
		enemy.add(new Enemy(1, 100f, 715f, 85f, 1410f, 0f, true, 12f));
		enemy.add(new Enemy(2, 1510f, 715f, 85f, 1510f, 0f, true, 12f));
		enemy.add(new Enemy(0, 1100f, 100f, 100f, 0f, 480f, true, 4f));
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(0, 0f, 800f, 1600f, 200f));
		ground.add(new Ground(4, 5f, 400f, 1545f, 200f));
		ground.add(new Ground(3, 1550f, 700f, 45f, 0f));
		ground.add(new Ground(3, 1550f, 600f, 45f, 0f));
		
		ground.add(new Ground(3, 1350f, 385f, 100f, 0f));
		ground.add(new Ground(3, 550f, 460f, 150f, 0f));
		ground.add(new Ground(3, 230f, 440f, 170f, 0f));
		ground.add(new Ground(10, 135f, 350f, 50f, 50f));
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
