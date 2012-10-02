package canvas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class CanvasSplash extends CanvasBase{
	
	public CanvasSplash(CanvasController controller){
		super(controller);
		System.out.println("CanvasSplash");
	}
	
	@Override
	public boolean keyTyped(char character) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			System.out.println("CanvasSplash Enter");
			controller.setCanvasByName(CanvasController.CANVAS_MENU);
		}
		return super.keyTyped(character);
	}
}
