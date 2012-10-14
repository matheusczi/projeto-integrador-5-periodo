package core;

import canvas.CanvasController;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Application implements ApplicationListener{
	private CanvasController canvasController;
	private SpriteBatch spriteBatch;
	
	public void create(){
		spriteBatch = new SpriteBatch();
		canvasController = new CanvasController();
	}
	
	public void render(){
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		canvasController.getCanvas().update(Gdx.graphics.getDeltaTime());
		
		spriteBatch.begin();
		canvasController.getCanvas().render(spriteBatch);
		spriteBatch.end();
	}
	
	public void resize(int width, int height){
		canvasController.getCanvas().resize(width, height);
	}
	
	public void pause(){
		canvasController.getCanvas().pause();
	}
	
	public void resume(){
		canvasController.getCanvas().resume();
	}
	
	public void dispose(){
		canvasController.dispose();
	}
}