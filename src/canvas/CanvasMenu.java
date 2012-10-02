package canvas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class CanvasMenu extends CanvasBase{
	
	public CanvasMenu(CanvasController controller){
		super(controller);
		
	}
	
	@Override
	public boolean keyTyped(char character) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			System.out.println("CanvasMenu Enter");
			controller.setCanvasByName(CanvasController.CANVAS_PROGRESS);
		}
		return super.keyTyped(character);
	}
}
