package objects;

import java.awt.Rectangle;

import objects.ObjectBase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character extends ObjectBase{
	protected Texture texture;
	
	protected int speedX;
	protected int speedY;
	
	public Character(){
		bounds = new Rectangle();
		
		speedX = 100;
		speedY = 100;
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		
	}
	
	@Override
	public void update(float deltaTime){
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			bounds.x -= deltaTime * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			bounds.x += deltaTime * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			bounds.y += deltaTime * speedY;
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			bounds.y -= deltaTime * speedY;
	}
	
	@Override
	public void dispose(){
		if(texture != null){
			texture.dispose();
		}
	}
}
