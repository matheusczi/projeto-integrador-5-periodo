package canvas;

import parser.LevelParser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class CanvasProgress extends CanvasBase{
	
	public CanvasProgress(CanvasController controller){
		super(controller);
		
	}
	
	@Override
	public boolean keyTyped(char character) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			System.out.println("CanvasSplash Enter");
			CanvasGame.getInstance().setLevel(LevelParser.loadLevel("level1", "res/data/levels.json"));
			controller.setCanvasByName(CanvasController.CANVAS_GAME);
		}
		return super.keyTyped(character);
	}
}
