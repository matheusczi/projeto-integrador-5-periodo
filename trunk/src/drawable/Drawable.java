package drawable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Drawable{
	
	public abstract void render(SpriteBatch spriteBatch);
	
	public abstract void update(float deltaTime);
	
}
