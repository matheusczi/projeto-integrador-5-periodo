package buttons.actions;

import canvas.CanvasController;

public class GoToMenu extends Actionable{
	CanvasController controller;
	
	public GoToMenu(CanvasController controller){
		super("Menu");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.setCanvasByName(CanvasController.CANVAS_MENU);
		super.action();
	}
}
