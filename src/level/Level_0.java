package level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.LinkedList;
import util.Ground;
import util.Waldi;

public class Level_0 extends Level {
	
	public Level_0() {
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
		waldi.add(new Waldi(60f, 450f, 20f, 4f));
		
		ground = new LinkedList<>();
		ground.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground.add(new Ground(0, 50f, 500f, 300f, 400f));
		ground.add(new Ground(0, 150f, 400f, 50f, 100f));
		ground.add(new Ground(0, 350f, 250f, 100f, 650f));
		
		ground.add(new Ground(3, 125f, 350f, 175f, 0f));
		ground.add(new Ground(0, 450f, 750f, 150f, 100f));
		ground.add(new Ground(0, 550f, 0f, 50f, 650f));
		
		ground.add(new Ground(0, 600f, 550f, 75f, 20f));
		ground.add(new Ground(0, 675f, 550f, 10f, 200f));
		
		ground.add(new Ground(0, 800f, 750f, 200f, 150f));
		ground.add(new Ground(4, 1000f, 840f, 300f, 60f));
		
		ground.add(new Ground(3, 1150f, 720f, 100f, 0f));
		ground.add(new Ground(3, 1000f, 600f, 80f, 0f));
		ground.add(new Ground(3, 850f, 480f, 60f, 0f));
		ground.add(new Ground(3, 720f, 360f, 40f, 0f));
		ground.add(new Ground(3, 880f, 270f, 20f, 0f));
		ground.add(new Ground(3, 1100f, 240f, 10f, 0f));
		
		ground.add(new Ground(0, 1300f, 200f, 300f, 700f));
		ground.add(new Ground(10, 1500f, 150f, 50f, 50f));
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
