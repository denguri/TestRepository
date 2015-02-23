package com.majstor.jovan.entity;

import com.badlogic.gdx.math.Vector2;
import com.majstor.jovan.TestGame;
import com.majstor.jovan.TextureManager;


public class Pulse extends Entity {

	public Pulse(Vector2 pos) {
		super(TextureManager.PULSE, pos, new Vector2(0, 5));
	}

	@Override
	public void update() {
		position.add(direction);
	}
	
	public boolean checkEnd() {
		return position.y >= TestGame.HEIGHT;
	}
	
}