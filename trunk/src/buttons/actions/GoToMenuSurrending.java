package buttons.actions;

import canvas.CanvasController;

public class GoToMenuSurrending extends Actionable{
	CanvasController controller;
	
	public GoToMenuSurrending(CanvasController controller){
		super("Surrender");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.setCanvasByName(CanvasController.CANVAS_MENU);
		super.action();
	}
}
