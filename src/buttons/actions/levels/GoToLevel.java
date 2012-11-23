package buttons.actions.levels;

import buttons.actions.Actionable;
import parser.LevelParser;
import canvas.CanvasController;

public class GoToLevel extends Actionable{
	CanvasController controller;
	String _lvl_name;
	String _lvl_id;
	String _lvl_source;
	

	public GoToLevel(CanvasController controller, String lvl_name, String lvl_id, String lvl_source){
		super(lvl_name);
		
		_lvl_name = lvl_name;
		_lvl_id = lvl_id;
		_lvl_source = lvl_source;
		
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.getCanvasGame().setLevel(LevelParser.loadLevel(controller, _lvl_id, _lvl_source));
		controller.setCanvasByName(CanvasController.CANVAS_GAME);
		super.action();
	}
}
