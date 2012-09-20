package drawable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationDrawableTest{
	protected Texture texture;
	protected TextureRegion[] textures;
	protected Animation animation;
	protected TextureRegion currentFrame;
	
	protected int animationFramesColumns;
	protected int animationFramesRows;
	
	protected float stateTime;
	
	protected int x;
	protected int y;
	
	protected int speedX;
	protected int speedY;
	
	public AnimationDrawableTest(String imagePath){
		animationFramesColumns = 4;
		animationFramesRows = 4;
		
		texture = new Texture(Gdx.files.internal(imagePath));
		TextureRegion[][] splitedTextures = TextureRegion.split(texture, texture.getWidth() / animationFramesColumns, texture.getHeight() / animationFramesRows);
		textures = new TextureRegion[animationFramesColumns * animationFramesRows];
		int index = 0;
		for(int i = 0; i < animationFramesRows; i++){
			for(int j = 0; j < animationFramesColumns; j++){
				textures[index++] = splitedTextures[i][j];
			}
		}
		
		animation = new Animation(0.025f, textures);
		stateTime = 0f;
		
		x = 0;
		y = 0;
		
		speedX = 100;
		speedY = 100;
	}
	
	public void render(SpriteBatch spriteBatch) {
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		spriteBatch.draw(currentFrame, x, y);
	}
	
	public void update() {
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			x -= Gdx.graphics.getDeltaTime() * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			x += Gdx.graphics.getDeltaTime() * speedX;
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			y += Gdx.graphics.getDeltaTime() * speedY;
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			y -= Gdx.graphics.getDeltaTime() * speedY;
		
	}
}
