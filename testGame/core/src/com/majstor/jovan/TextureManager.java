package com.majstor.jovan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
	public static Texture PULSE = new Texture(Gdx.files.internal("pulse.png"));
	public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
	public static Texture GAME_OVER = new Texture(Gdx.files.internal("gameover.png"));
	public static Texture GAME_WON = new Texture(Gdx.files.internal("gamewon.jpg"));
}
