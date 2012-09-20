package canvas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Application;

public abstract class Canvas{
	protected Application application;
	
	public Canvas(Application application){
		this.application = application;
	}
	
	public abstract void render(SpriteBatch spriteBatch);
	
	public abstract void update(float deltaTime);
}
