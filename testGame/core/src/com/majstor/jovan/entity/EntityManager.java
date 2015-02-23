package com.majstor.jovan.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.majstor.jovan.TestGame;
import com.majstor.jovan.TextureManager;
import com.majstor.jovan.camera.OrthoCamera;
import com.majstor.jovan.screen.GameOverScreen;
import com.majstor.jovan.screen.ScreenManager;


public class EntityManager {

	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	private static final String TAG = "EntityManager";
	
	public EntityManager(int amount, OrthoCamera camera) {
		player = new Player(new Vector2(230, 15), new Vector2(0, 0), this, camera, ColorEnum.NONE);
		for (int i = 0; i < amount; i++) {
			float x = MathUtils.random(0, TestGame.WIDTH - TextureManager.ENEMY.getWidth());
			float y = MathUtils.random(TestGame.HEIGHT, TestGame.HEIGHT * 3);
			float speed = MathUtils.random(2, 5);
			int color = MathUtils.random(0, 2);
			addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed), ColorEnum.getColor(color)));
		}
	}
	
	public void update() {
		for (Entity e : entities)
			e.update();
		for (Pulse m : getPulses())
			if (m.checkEnd())
				entities.removeValue(m, false);
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb) {
		for (Entity e : entities)
			e.render(sb);
		player.render(sb);
	}
	
	private void checkCollisions() {
		for (Enemy e : getEnemies()) {
			for (Pulse m : getPulses()) {
				if (e.getBounds().overlaps(m.getBounds()) && m.getColor() == e.getColor()) {
					entities.removeValue(e, false);
					entities.removeValue(m, false);
					if (gameOver())
						ScreenManager.setScreen(new GameOverScreen(true));
				}
			}
			if (e.getBounds().overlaps(player.getBounds())) {
				ScreenManager.setScreen(new GameOverScreen(false));
			}
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
		Gdx.app.log(TAG, entity.getColor().toString());
	}
	
	private Array<Enemy> getEnemies() {
		Array<Enemy> ret = new Array<Enemy>();
		for (Entity e : entities)
			if (e instanceof Enemy)
				ret.add((Enemy)e);
		return ret;
	}
	
	public Array<Pulse> getPulses() {
		Array<Pulse> ret = new Array<Pulse>();
		for (Entity e : entities)
			if (e instanceof Pulse)
				ret.add((Pulse)e);
		return ret;
	}
	
	public boolean gameOver() {
		return getEnemies().size <= 0;
	}
	
}
