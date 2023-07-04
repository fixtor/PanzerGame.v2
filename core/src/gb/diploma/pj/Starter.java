package gb.diploma.pj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;
	private Panzer me; // Инициализация класса Panzer
	private List<Panzer> enemies = new ArrayList<>();
	private KeyboardAdapter inputProccessor = new KeyboardAdapter();

	/*Метод инициализации приложения */
	@Override
	public void create () {
		Gdx.input.setInputProcessor(inputProccessor);
		batch = new SpriteBatch();
		me = new Panzer(100, 200);

	}
	/*Метод отрисовки кадра */
	@Override
	public void render () {
		me.moveTo(inputProccessor.getDirection());
		me.rotateTo(inputProccessor.getMousePosition());
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		me.render(batch);
		batch.end();
	}
	/*Метод очистки памяти, удаления приложения */
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
	}
}
