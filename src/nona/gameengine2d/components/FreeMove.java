package nona.gameengine2d.components;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.entity.EntityComponent;
import nona.gameengine2d.input.Keyboard;
import nona.gameengine2d.maths.Vector3f;

public class FreeMove extends EntityComponent {
	
	private float speed;
	
	public FreeMove(float speed) {
		this.speed = speed;
	}
	
	@Override
	public void update(Transform transform, float delta) {
		final float moveAmt = speed * delta;
		
		if (Keyboard.getKey(Keyboard.KEY_UP) || Keyboard.getKey(Keyboard.KEY_W)) {
			move(transform, 0.0f, moveAmt);
		}
		if (Keyboard.getKey(Keyboard.KEY_DOWN) || Keyboard.getKey(Keyboard.KEY_S)) {
			move(transform, 0.0f, -moveAmt);
		}
		if (Keyboard.getKey(Keyboard.KEY_LEFT) || Keyboard.getKey(Keyboard.KEY_A)) {
			move(transform, -moveAmt, 0.0f);
		}
		if (Keyboard.getKey(Keyboard.KEY_RIGHT) || Keyboard.getKey(Keyboard.KEY_D)) {
			move(transform, moveAmt, 0.0f);
		}
	}
	
	private void move(Transform transform, float x, float y) {
		transform.getTranslation().add(new Vector3f(x, y, 0.0f));
	}
	
}
