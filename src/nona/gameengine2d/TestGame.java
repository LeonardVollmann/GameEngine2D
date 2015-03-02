package nona.gameengine2d;

import nona.gameengine2d.components.FreeMove;
import nona.gameengine2d.components.PrimitiveRenderer;
import nona.gameengine2d.core.Game;
import nona.gameengine2d.entity.Entity;
import nona.gameengine2d.graphics.primitives.Rectangle;

public class TestGame extends Game {
	
	public TestGame() {
		super();
	}
	
	@Override
	public void init() {
		root.addChild(new Entity().addComponent(new PrimitiveRenderer(new Rectangle(1.0f, 1.0f))).addComponent(new FreeMove(1.0f)));
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
	}

}
