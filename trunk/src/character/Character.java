package character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import character.CharacterBase;

public class Character extends CharacterBase{
	protected Texture texture;
	protected TextureRegion[] textures;
	protected Animation animation;
	protected TextureRegion currentFrame;
	
	protected int animationFramesColumns;
	protected int animationFramesRows;
	
	protected float stateTime;
	
	protected int speedX;
	protected int speedY;
	
	public Character() {
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
			X -= Gdx.graphics.getDeltaTime() * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			X += Gdx.graphics.getDeltaTime() * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			Y += Gdx.graphics.getDeltaTime() * speedY;
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			Y -= Gdx.graphics.getDeltaTime() * speedY;
	}

}
