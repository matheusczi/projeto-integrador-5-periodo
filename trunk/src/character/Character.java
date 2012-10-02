package character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import character.CharacterBase;

public class Character extends CharacterBase{
	protected Texture texture;
	
	protected int speedX;
	protected int speedY;
	
	public Character(){
		X = 0;
		Y = 0;
		
		speedX = 100;
		speedY = 100;
	}
	
	@Override
	public void render(SpriteBatch spriteBatch) {

	}
	
	@Override
	public void update(float deltaTime) {
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			X -= deltaTime * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			X += deltaTime * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			Y += deltaTime * speedY;
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			Y -= deltaTime * speedY;
	}
	
	@Override
	public void dispose() {
		if(texture != null){
			texture.dispose();
		}
	}
}
