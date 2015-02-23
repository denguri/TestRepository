package com.majstor.jovan.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.majstor.jovan.TestGame;
import com.majstor.jovan.TextureManager;

public class Enemy extends Entity {

	public Enemy(Vector2 position, Vector2 direction) {
		super(TextureManager.ENEMY, position, direction);
	}

	@Override
	public void update() {
		position.add(direction);
		
		if (position.y <= -TextureManager.ENEMY.getHeight()) {
			float x = MathUtils.random(0, TestGame.WIDTH - TextureManager.ENEMY.getWidth());
			position.set(x, TestGame.HEIGHT);
		}
	}
	
}
