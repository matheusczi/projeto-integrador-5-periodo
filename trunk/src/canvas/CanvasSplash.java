package canvas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import core.Main;

public class CanvasSplash extends CanvasBase{
	ShapeRenderer renderer;
	
	public CanvasSplash(CanvasController controller){
		super(controller);
		renderer = new ShapeRenderer();
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		renderer.begin(ShapeType.FilledRectangle);
		renderer.setColor(1, 0.8f, 0, 1);
		renderer.filledRect(0, 0, Main.width, Main.height);
		renderer.end();
		super.render(spriteBatch);
	}
	
	@Override
	public boolean keyTyped(char character){
		controller.setCanvasByName(CanvasController.CANVAS_MENU);
		return super.keyTyped(character);
	}
}
