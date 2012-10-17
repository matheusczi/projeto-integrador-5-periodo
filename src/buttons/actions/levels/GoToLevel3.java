package buttons.actions.levels;

import buttons.actions.Actionable;
import parser.LevelParser;
import canvas.CanvasController;

public class GoToLevel3 extends Actionable{
	CanvasController controller;
	
	public GoToLevel3(CanvasController controller){
		super("Level 3");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.getCanvasGame().setLevel(LevelParser.loadLevel(controller, "level3", "res/data/levels.json"));
		controller.setCanvasByName(CanvasController.CANVAS_GAME);
		super.action();
	}
}
