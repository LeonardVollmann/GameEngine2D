package nona.gameengine2d;

import nona.gameengine2d.core.CoreEngine;
import nona.gameengine2d.core.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new TestGame();
		CoreEngine engine = new CoreEngine(720, 540, "2D Game Engine", 60, game);
		
		engine.start();
	}
	
}