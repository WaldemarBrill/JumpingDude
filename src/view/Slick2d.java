package view;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;
import level.*;

public class Slick2d extends BasicGame {
	private AppGameContainer app;
	
	private int trys = 0;
	private int levelNumber = 7;
	private int startDelay = 0;
	private int time = 0;
	private Level lvl;
	public static boolean DEAD;
	public static boolean LEVELUP;
	
	public Slick2d() {
		super("WaldisWunderWelt");
	}
	
	@Override
	public void init(GameContainer gc) {
		if (gc instanceof AppGameContainer) {
			app = (AppGameContainer) gc;
		}
		startDelay = 60;
		DEAD = false;
		LEVELUP = false;
		switch (levelNumber) {
		case 0:
			lvl = new Level_0();
			break;
		case 1:
			lvl = new Level_1();
			break;
		case 2:
			lvl = new Level_2();
			break;
		case 3:
			lvl = new Level_3();
			break;
		case 4:
			lvl = new Level_4();
			break;
		case 5:
			lvl = new Level_5();
			break;
		case 6:
			lvl = new Level_6();
			break;
		case 7:
			lvl = new Level_7();
			break;
		default:
			break;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		if (!DEAD) {
			lvl.render(gc, g);
		} else {
			g.setColor(Color.white);
			g.drawString("You DIED!", 750f, 400f);
			g.drawString("Restart with 'R'", 730f, 450f);
		}
		if (startDelay > 0) {
			g.setColor(Color.white);
			g.drawString("Starting Delay: " + startDelay, 400f, 100f);
		}
		g.setColor(Color.white);
		g.drawString("Trys: "+trys, 10f, 50f);
		String s = String.format("Time: %.2f", (time/60f));
		g.drawString(s, 10f, 75f);
	}

	@Override
	public void update(GameContainer gc, int delta) {
		if (startDelay <= 0) {
			if (!DEAD) {
				time++;
				lvl.update(gc);
				if (LEVELUP) {
					if (app != null) {
						try {
							levelNumber += 1;
							app.setDisplayMode(1600, 900, false);
							app.reinit();
						} catch (Exception e) {
							Log.error(e);
						}
					}
				}
			}
		} else {
			startDelay--;
		}
	}
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			System.exit(0);
		}
		if (key == Input.KEY_R) {
			if (app != null) {
				try {
					app.setDisplayMode(1600, 900, false);
					app.reinit();
					trys++;
				} catch (Exception e) {
					Log.error(e);
				}
			}
		}
	}
}
