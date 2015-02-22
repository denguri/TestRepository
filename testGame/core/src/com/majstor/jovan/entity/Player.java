package com.majstor.jovan.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.majstor.jovan.TestGame;
import com.majstor.jovan.TextureManager;
import com.majstor.jovan.camera.OrthoCamera;


public class Player extends Entity {

	private final EntityManager entityManager;
	private final OrthoCamera camera;
	private long lastFire;
	
	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager, OrthoCamera camera) {
		super(TextureManager.PLAYER, pos, direction);
		this.entityManager = entityManager;
		this.camera = camera;
	}

	@Override
	public void update() {
		position.add(direction);
		
		int dir = 0;
		if (Gdx.input.isTouched()) {
			Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
			if (touch.x > TestGame.WIDTH / 2)
				dir = 2;
			else
				dir = 1;
		}
		
		if (Gdx.input.isKeyPressed(Keys.A) || dir == 1) //left
			setDirection(-300, 0);
		else if (Gdx.input.isKeyPressed(Keys.D) || dir == 2) //right
			setDirection(300, 0);
		else 
			setDirection(0, 0);
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (System.currentTimeMillis() - lastFire >= 350) {
				entityManager.addEntity(new Pulse(position.cpy().add(TextureManager.PLAYER.getWidth()/2 - TextureManager.PULSE.getWidth()/2, TextureManager.PLAYER.getHeight())));
				lastFire = System.currentTimeMillis();
			}
		}
	}

}
