package canvas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import core.Main;

public class CanvasSplash extends CanvasBase{
	ShapeRenderer renderer;
	private float timerCount;
	
	public CanvasSplash(CanvasController controller){
		super(controller);
		renderer = new ShapeRenderer();
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		renderer.begin(ShapeType.FilledRectangle);
		renderer.setColor(0.0f, 0.1f, 0.05f, 1);
		renderer.filledRect(0, 0, Main.width, Main.height);
		renderer.end();
		super.render(spriteBatch);
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
	public boolean keyTyped(char character){
		goToProgressCanvas();
		return super.keyTyped(character);
	}
	
	private void goToProgressCanvas(){
		controller.playBackgroundSound();
		controller.setCanvasByName(CanvasController.CANVAS_MENU);
	}
}
