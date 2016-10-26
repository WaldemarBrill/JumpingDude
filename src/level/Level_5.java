package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;

import util.Enemy;
import util.Ground;
import util.Waldi;

public class Level_5 extends Level {
	
	public Level_5() {
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
		waldi.add(new Waldi(20f, 400f, 20f, 4f));
		
		enemy = new LinkedList<>();
		enemy.add(new Enemy(1, 5f, -1600f, 1590f, 0f, 400f, true, 1.5f));
		enemy.add(new Enemy(1, 5f, 500f, 1590f, 0f, 400f, true, 1.5f));
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(3, 0f, 450f, 50f, 0f));
		
		ground.add(new Ground(5, 5f, 350f, 145f, 10f));
		ground.add(new Ground(0, 5f, 340f, 155f, 10f));
		ground.add(new Ground(5, 150f, 350f, 10f, 325f));
		ground.add(new Ground(0, 160f, 340f, 50f, 325f));
		ground.add(new Ground(5, 160f, 665f, 50f, 10f));
		
		ground.add(new Ground(3, 255f, 700f, 45f, 0f));
		ground.add(new Ground(5, 300f, 500f, 10f, 400f));
		
		ground.add(new Ground(5, 210f, 340f, 840f, 20f));
		ground.add(new Ground(5, 755f, 360f, 10f, 200f));
		ground.add(new Ground(0, 310f, 500f, 150f, 400f));
		ground.add(new Ground(0, 460f, 575f, 150f, 325f));
		ground.add(new Ground(0, 610f, 650f, 300f, 290f));
		ground.add(new Ground(0, 910f, 575f, 150f, 325f));
		ground.add(new Ground(0, 1060f, 500f, 150f, 400f));
		
		ground.add(new Ground(0, 1210f, 200f, 25f, 700f));
		ground.add(new Ground(0, 1235f, 200f, 50f, 10f));
		ground.add(new Ground(0, 1030f, 200f, 20f, 140f));
		
		ground.add(new Ground(0, 1435f, 0f, 160f, 900f));
		ground.add(new Ground(4, 1235f, 300f, 100f, 10f));
		ground.add(new Ground(4, 1335f, 500f, 100f, 10f));
		ground.add(new Ground(4, 1235f, 700f, 100f, 10f));
		
		ground.add(new Ground(10, 1385f, 800f, 50f, 50f));
		
		
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
