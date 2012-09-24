package canvas;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Application;

//TODO deixar classe com os metodos virtuais, e não pure virtuais

// http://code.google.com/p/libgdx/wiki/InputEvent
public abstract class Canvas implements InputProcessor{
	protected Application application;
	
	public Canvas(Application application){
		this.application = application;
	}
	
	public abstract void render(SpriteBatch spriteBatch);
	
	public abstract void update(float deltaTime);
	
	// TODO deixar como função virtual.
	public abstract void resize(int width, int height);
	
	// TODO deixar como função virtual.
	public abstract void pause();
	
	// TODO deixar como função virtual.
	public abstract void resume();
	
	// TODO deixar como função virtual.
	public abstract void dispose();
	
}
