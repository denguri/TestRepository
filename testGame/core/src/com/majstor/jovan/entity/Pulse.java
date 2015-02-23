package com.majstor.jovan.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.majstor.jovan.TestGame;
import com.majstor.jovan.TextureManager;


public class Pulse extends Entity {

	public Pulse(Vector2 pos, ColorEnum color) {
		super(TextureManager.PULSE, pos, new Vector2(0, 5), color);
		Pixmap p = new Pixmap(500, 5, Pixmap.Format.RGBA8888);
		if (color == ColorEnum.RED)
			p.setColor(Color.RED);
		if (color == ColorEnum.GREEN)
			p.setColor(Color.GREEN);
		if (color == ColorEnum.BLUE)
			p.setColor(Color.BLUE);
		p.fill();
		Texture pulseTexture = new Texture(p);
		this.texture = pulseTexture;
	}

	@Override
	public void update() {
		position.add(direction);
	}
	
	public boolean checkEnd() {
		return position.y >= TestGame.HEIGHT;
	}
	
}