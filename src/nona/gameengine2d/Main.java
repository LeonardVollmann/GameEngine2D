package nona.gameengine2d;

import nona.gameengine2d.core.CoreEngine;

public class Main {

	public static void main(String[] args) {
		CoreEngine engine = new CoreEngine(720, 540, "2D Game Engine", 60);
		
		engine.start();
	}
	
}