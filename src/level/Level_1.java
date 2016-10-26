package level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;
import util.Ground;
import util.Waldi;

public class Level_1 extends Level {
	
	public Level_1() {
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
		waldi.add(new Waldi(20f, 50f, 20f, 4f));
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(0, 0f, 150f, 100f, 750f));
		ground.add(new Ground(0, 200f, 0f, 30f, 750f));
		ground.add(new Ground(4, 100f, 250f, 50f, 20f));
		ground.add(new Ground(4, 150f, 375f, 50f, 20f));
		ground.add(new Ground(4, 100f, 500f, 50f, 20f));
		ground.add(new Ground(4, 150f, 625f, 50f, 20f));
		
		ground.add(new Ground(3, 230f, 750f, 70f, 0f));
		ground.add(new Ground(3, 400f, 500f, 100, 0f));
		
		ground.add(new Ground(0, 975f, 880f, 300, 10f));
		ground.add(new Ground(0, 1400f, 700f, 20f, 100f));
		ground.add(new Ground(0, 1250f, 580f, 20f, 120f));
		ground.add(new Ground(0, 1400f, 460f, 20f, 120f));
		ground.add(new Ground(5, 1400f, 580f, 20f, 120f));
		ground.add(new Ground(5, 1250f, 560f, 20f, 20f));
		ground.add(new Ground(5, 1250f, 700f, 20f, 20f));
		
		ground.add(new Ground(3, 850f, 475f, 400f, 0f));
		ground.add(new Ground(10, 850f, 425f, 50f, 50f));
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		drawWaldi(g);
		drawGround(g);
	}

	@Override
	public void update(GameContainer gc) {
		keyPressed(gc);
		collisionDetectionWaldiGround();
		movementWaldi();
	}

}
