package canvas;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// keyboard information:
// http://code.google.com/p/libgdx/wiki/InputEvent
// http://libgdx.l33tlabs.org/docs/api/com/badlogic/gdx/Input.Keys.html
public class CanvasBase implements InputProcessor{
	protected CanvasController controller;
	
	public CanvasBase(CanvasController controller){
		this.controller = controller;
	}
	
	public void render(SpriteBatch spriteBatch){

	}
	
	public void update(float deltaTime){

	}
	
	public void resize(int width, int height){

	}
	
	public void pause(){

	}
	
	public void resume(){

	}
	
	public void dispose(){

	}
	
	@Override
	public boolean keyDown(int keycode){
		return false;
	}
	
	@Override
	public boolean keyTyped(char character){
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode){
		return false;
	}
	
	@Override
	public boolean scrolled(int amount){
		return false;
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button){
		return false;
	}
	
	@Override
	public boolean touchDragged(int x, int y, int pointer){
		return false;
	}
	
	@Override
	public boolean touchMoved(int x, int y){
		return false;
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button){
		return false;
	}
}
