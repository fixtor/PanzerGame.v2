package gb.diploma.pj;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Panzer {
	private final float size = 64; //pixels
	private final float halfSize = size/2; //half_pixels
	private final Vector2 position = new Vector2();
	private final Vector2 angle = new Vector2();
	private final TextureRegion textureRegion;

	private final Texture texture;

	public Panzer(float x, float y) {
		this(x, y, "player-top.png");
	}

	public Panzer(float x, float y, String textureName ) {
		texture = new Texture(textureName);
		this.textureRegion = new TextureRegion(texture);
		position.set(x, y);
	}

	/**
	 *
	 * @param batch
	 */
	public void render(Batch batch){
		batch.draw(
				textureRegion,
				position.x,
				position.y,
				halfSize,
				halfSize,
				size,
				size,
				1,
				1,
				angle.angleDeg() - 90);
	}

	public void dispose(){
		texture.dispose();
	}
	/**
	 *
	 * @param direction
	 */
	public void moveTo(Vector2 direction){
		position.add(direction);
	}

	public void rotateTo(Vector2 mousePosition) {
		angle.set(mousePosition).sub(position.x + halfSize, position.y + halfSize);
	}
}
