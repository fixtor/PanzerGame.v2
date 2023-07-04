package gb.diploma.pj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class KeyboardAdapter extends InputAdapter {

	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;
	private boolean downPressed;
	private boolean mouseLeftButtonPressed;
	private final Vector2 direction = new Vector2();

	public Vector2 getMousePosition() {
		return mousePosition;
	}

	private final Vector2 mousePosition = new Vector2();

	@Override
	public boolean keyDown(int keycode) {
		if( keycode == Input.Keys.A) leftPressed = true;
		if( keycode == Input.Keys.W) upPressed = true;
		if( keycode == Input.Keys.S) downPressed = true;
		if( keycode == Input.Keys.D) rightPressed = true;

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if( keycode == Input.Keys.A) leftPressed = false;
		if( keycode == Input.Keys.W) upPressed = false;
		if( keycode == Input.Keys.S) downPressed = false;
		if( keycode == Input.Keys.D) rightPressed= false;

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		mousePosition.set(screenX,
						  Gdx.graphics.getHeight() - screenY); // выравниваем область указателя мыши
		return false;
	}

	public Vector2 getDirection(){
		direction.set(0, 0);
		if (leftPressed)    direction.add(-5, 0);
		if (rightPressed)   direction.add(5, 0);
		if (upPressed)      direction.add(0, 5);
		if (downPressed)    direction.add(0, -5);

		return direction;
	}
}
