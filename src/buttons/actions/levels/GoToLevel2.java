package buttons.actions.levels;

import buttons.actions.Actionable;
import parser.LevelParser;
import canvas.CanvasController;

public class GoToLevel2 extends Actionable{
	CanvasController controller;
	
	public GoToLevel2(CanvasController controller){
		super("Level 2");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.getCanvasGame().setLevel(LevelParser.loadLevel(controller, "level2", "res/data/levels.json"));
		controller.setCanvasByName(CanvasController.CANVAS_GAME);
		super.action();
	}
}
