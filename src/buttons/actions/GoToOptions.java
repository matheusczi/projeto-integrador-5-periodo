package buttons.actions;

import canvas.CanvasController;

public class GoToOptions extends Actionable{
	CanvasController controller;
	
	public GoToOptions(CanvasController controller){
		super("Options");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.setCanvasByName(CanvasController.CANVAS_OPTIONS);
		super.action();
	}
}
