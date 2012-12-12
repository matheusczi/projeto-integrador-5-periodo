package canvas;

import java.util.ArrayList;

import objects.ObjectBase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import core.Main;

public class CanvasSplash extends CanvasBase{
	private float timerCount;
	private ArrayList<ObjectBase> drawables;
	
	public CanvasSplash(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(controller.getBackGroundTexture6(), 0, 0);
		for(ObjectBase drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	@Override
	public void update(float deltaTime){
		timerCount += deltaTime;
		if(timerCount >= 1.75f){
			timerCount = 0.0f;
			goToProgressCanvas();
		}
	}
	@Override
	public void dispose(){
		for(ObjectBase drawable : drawables){
			drawable.dispose();
		}
	}

	@Override
	public boolean keyTyped(char character){
		goToProgressCanvas();
		return super.keyTyped(character);
	}
	
	private void goToProgressCanvas(){
		controller.playBackgroundSound();
		controller.setCanvasByName(CanvasController.CANVAS_MENU);
	}
}
