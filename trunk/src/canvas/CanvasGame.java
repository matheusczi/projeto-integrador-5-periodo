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

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
