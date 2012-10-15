package buttons.actions;

import parser.LevelParser;
import canvas.CanvasController;

public class GoToLevel1 extends Actionable{
	CanvasController controller;
	
	public GoToLevel1(CanvasController controller){
		super("Level 1");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.getCanvasGame().setLevel(LevelParser.loadLevel(controller, "level1", "res/data/levels.json"));
		controller.setCanvasByName(CanvasController.CANVAS_GAME);
		super.action();
	}
}
