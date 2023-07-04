package gb.diploma.pj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		List<Panzer> newEnemies = IntStream.range(0, 15).mapToObj(i -> {
										int x = MathUtils.random(Gdx.graphics.getWidth());
										int y = MathUtils.random(Gdx.graphics.getHeight());
										return new Panzer(x, y, "enemy-right.png");
										}).collect(Collectors.toList());
		enemies.addAll(newEnemies);
	}
	/*Метод отрисовки кадра */
	@Override
	public void render () {
		me.moveTo(inputProccessor.getDirection());
		me.rotateTo(inputProccessor.getMousePosition());
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		me.render(batch);
		enemies.forEach(enemy -> {enemy.render(batch);});

		batch.end();
	}
	/*Метод очистки памяти, удаления приложения */
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
	}
}
