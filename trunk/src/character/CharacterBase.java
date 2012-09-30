package character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class CharacterBase {
	public int X;
	public int Y;
	
	public abstract void render(SpriteBatch spriteBatch);
	public abstract void update(float deltaTime);
}
