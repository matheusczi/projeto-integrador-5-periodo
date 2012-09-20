package canvas;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Application;
import drawable.Drawable;

public class CanvasGame extends Canvas{
	private ArrayList<Drawable> drawables;
	
	public CanvasGame(Application application){
		super(application);
		drawables = new ArrayList<Drawable>();
	}
	
	public void render(SpriteBatch spriteBatch) {
		for(Drawable drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	public void update(float deltaTime) {
		for(Drawable drawable : drawables){
			drawable.update(deltaTime);
		}
	}
}
