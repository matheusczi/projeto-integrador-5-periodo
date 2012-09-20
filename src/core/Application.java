package core;

import canvas.CanvasController;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Application implements ApplicationListener{
	private CanvasController canvasController;
	private SpriteBatch spriteBatch;
	
	public void create() {
		spriteBatch = new SpriteBatch();
		
		canvasController = new CanvasController(this);
	}
	
	public void render() {
		canvasController.getCanvas().update(Gdx.graphics.getDeltaTime());
		spriteBatch.begin();
		canvasController.getCanvas().render(spriteBatch);
		spriteBatch.end();		
	}
	
	public void resize(int width, int height) {

	}
	
	public void pause() {

	}
	
	public void resume() {

	}
	
	public void dispose() {

	}
}