package com.majstor.jovan.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.majstor.jovan.TestGame;
import com.majstor.jovan.TextureManager;

public class Enemy extends Entity {

	public Enemy(Vector2 position, Vector2 direction, ColorEnum color) {
		super(TextureManager.ENEMY, position, direction, color);
		Pixmap p = new Pixmap(20, 20, Pixmap.Format.RGBA8888);
		if (color == ColorEnum.RED)
			p.setColor(Color.RED);
		if (color == ColorEnum.GREEN)
			p.setColor(Color.GREEN);
		if (color == ColorEnum.BLUE)
			p.setColor(Color.BLUE);
		p.fill();
		Texture enemyTexture = new Texture(p);
		this.texture = enemyTexture;
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
