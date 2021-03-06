package com.majstor.jovan.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.majstor.jovan.camera.OrthoCamera;
import com.majstor.jovan.entity.EntityManager;

public class GameScreen extends Screen {

	private OrthoCamera camera;
	private EntityManager entityManager;
	private boolean pauseState;
	
	@Override
	public boolean isPauseState() {
		return pauseState;
	}

	@Override
	public void create() {
		camera = new OrthoCamera();
		entityManager = new EntityManager(10, camera);
		pauseState = false;
	}

	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		pauseState = true;
	}

	@Override
	public void resume() {
		pauseState = false;
	}

	@Override
	public int type() {
		return 0;
	}

}
