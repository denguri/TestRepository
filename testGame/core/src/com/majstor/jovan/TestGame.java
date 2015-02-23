package com.majstor.jovan;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.majstor.jovan.screen.GameScreen;
import com.majstor.jovan.screen.ScreenManager;

public class TestGame implements ApplicationListener {
	
	public static int WIDTH = 1024, HEIGHT = 768;
	private SpriteBatch batch;
	private GameScreen gameScreen;
	private static final String TAG = "TestGame";

	@Override
	public void create() {
		Gdx.app.log(TAG, "create called!!!");
		batch = new SpriteBatch();
		gameScreen = new GameScreen();
		ScreenManager.setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		Gdx.app.log(TAG, "dispose called!!!");
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
		gameScreen.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);
		
		if (ScreenManager.getCurrentScreen().type() == 1 && Gdx.input.isKeyPressed(Keys.R)) {
			Gdx.app.log(TAG, "Restart game!!!");
			dispose();
			create();
			resize(WIDTH, HEIGHT);
		}
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(TAG, "resize called!!!");
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
