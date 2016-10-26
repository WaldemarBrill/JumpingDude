package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import java.util.List;
import java.util.LinkedList;

import util.Enemy;
import util.Ground;
import util.Waldi;

public class Level_4 extends Level {
	
	public Level_4() {
		init();
	}
	private List<Ground> ground1;
	private List<Ground> ground2;
	private int counter;

	@Override
	public void init() {
		keyW = false;
		keyS = false;
		keyA = false;
		keyD = false;
		keySpace = false;
		counter = 0;
		
		waldi = new LinkedList<>();
		waldi.add(new Waldi(20f, 75f, 20f, 4f));
		
		enemy = new LinkedList<>();
		enemy.add(new Enemy(0, 0f, 100f, 75f, 180f, 0f, true, 2f));
		enemy.add(new Enemy(2, 0f, 900f, 1600f, 0f, 900f, true, 0.14f));
		enemy.add(new Enemy(1, 500f, 250f, 50f, 0f, 240f, true, 3f));
		
		ground = new LinkedList<>();
		ground1 = new LinkedList<>();
		ground2 = new LinkedList<>();
		
		ground1.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground1.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground1.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground1.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground1.add(new Ground(0, 75f, 0f, 30f, 750f));
		ground1.add(new Ground(0, 275f, 300f, 40f, 600f));
		
		ground1.add(new Ground(0, 315f, 260f, 300f, 40f));
		ground1.add(new Ground(5, 615f, 180f, 25f, 120f));
		ground1.add(new Ground(5, 700f, 0f, 25f, 500f));
		
		ground1.add(new Ground(0, 345f, 500f, 355f, 60f));
		
		ground1.add(new Ground(3, 650f, 800f, 160f, 0f));
		ground1.add(new Ground(0, 980f, 740f, 720f, 160f));
		ground1.add(new Ground(5, 1585f, 5f, 10f, 735f));
		
		ground1.add(new Ground(10, 1535f, 5f, 50f, 50f));
		
		
		
		ground2.add(new Ground(0, 0f, 0f, 1600f, 5f));
		ground2.add(new Ground(0, 0f, 0f, 5f, 900f));
		ground2.add(new Ground(0, 1595f, 0f, 5f, 900f));
		ground2.add(new Ground(4, 0f, 895f, 1600f, 5f));
		
		ground2.add(new Ground(0, 75f, 0f, 30f, 750f));
		ground2.add(new Ground(0, 275f, 300f, 40f, 600f));
		
		ground2.add(new Ground(0, 315f, 260f, 300f, 40f));
		ground2.add(new Ground(5, 615f, 180f, 25f, 120f));
		ground2.add(new Ground(5, 700f, 0f, 25f, 500f));
		
		ground2.add(new Ground(0, 345f, 500f, 355f, 60f));
		
		ground2.add(new Ground(3, 650f, 800f, 160f, 0f));
		ground2.add(new Ground(0, 980f, 740f, 720f, 160f));
		ground2.add(new Ground(5, 1585f, 5f, 10f, 735f));
		
		ground2.add(new Ground(10, 1535f, 5f, 50f, 50f));
		
		
		
		ground1.add(new Ground(3, 1200f, 650f, 75f, 10f));	ground2.add(new Ground(3, 1200f, 650f, 75f, 10f));
		ground1.add(new Ground(3, 1350f, 650f, 75f, 10f));	ground2.add(new Ground(3, 1350f, 650f, 75f, 10f));
		ground1.add(new Ground(3, 1000f, 550f, 75f, 10f));	ground2.add(new Ground(3, 1100f, 550f, 75f, 10f));
		ground1.add(new Ground(3, 1275f, 550f, 75f, 10f));	ground2.add(new Ground(3, 1375f, 550f, 75f, 10f));
		ground1.add(new Ground(3, 975f, 450f, 75f, 10f));	ground2.add(new Ground(3, 1135f, 450f, 75f, 10f));
		ground1.add(new Ground(3, 1400f, 450f, 75f, 10f));	ground2.add(new Ground(3, 1260f, 450f, 75f, 10f));
		ground1.add(new Ground(3, 1300f, 350f, 75f, 10f));	ground2.add(new Ground(3, 1390f, 350f, 75f, 10f));
		ground1.add(new Ground(3, 1175f, 350f, 75f, 10f));	ground2.add(new Ground(3, 1020f, 350f, 75f, 10f));
		ground1.add(new Ground(3, 1135f, 250f, 75f, 10f));	ground2.add(new Ground(3, 970f, 250f, 75f, 10f));
		ground1.add(new Ground(3, 1242f, 250f, 75f, 10f));	ground2.add(new Ground(3, 1280f, 250f, 75f, 10f));
		ground1.add(new Ground(3, 1190f, 150f, 75f, 10f));	ground2.add(new Ground(3, 1111f, 150f, 75f, 10f));
		ground1.add(new Ground(3, 1390f, 150f, 75f, 10f));	ground2.add(new Ground(3, 1490f, 150f, 75f, 10f));
		ground1.add(new Ground(3, 1250f, 50f, 75f, 10f));	ground2.add(new Ground(3, 1350f, 50f, 75f, 10f));
		ground1.add(new Ground(3, 1450f, 50f, 75f, 10f));	ground2.add(new Ground(3, 1450f, 50f, 75f, 10f));
		ground1.add(new Ground(0, 1535f, 55f, 50f, 10f));	ground2.add(new Ground(0, 1525f, 5f, 10f, 50f));
		
		
		
		ground = ground1;
	}
	@Override
	public void render(GameContainer gc, Graphics g) {
		drawWaldi(g);
		drawGround(g);
		drawEnemy(g);
	}

	@Override
	public void update(GameContainer gc) {
		if (counter <= 480) {
			counter++;
		} else {
			counter = 0;
		}
		if (counter == 0) {
			ground = ground1;
		}
		if (counter == 240) {
			ground = ground2;
		}
		
		keyPressed(gc);
		collisionDetectionWaldiGround();
		collisionDetectionWaldiEnemy();
		movementWaldi();
		movementEnemy();
	}

}
