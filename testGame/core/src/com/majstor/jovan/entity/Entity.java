package com.majstor.jovan.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Texture texture;
	protected Vector2 position, direction;
	protected ColorEnum color;
	
	public ColorEnum getColor() {
		return color;
	}

	public Entity(Texture texture, Vector2 position, Vector2 direction, ColorEnum color) {
		this.texture = texture;
		this.position = position;
		this.direction = direction;
		this.color = color;
	}
	
	public abstract void update();
	
	public void render(SpriteBatch sb) {
		sb.draw(texture, position.x, position.y);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
	}
	
	public void setDirection(float x, float y) {
		direction.set(x, y);
		direction.scl(Gdx.graphics.getDeltaTime());
	}
}
