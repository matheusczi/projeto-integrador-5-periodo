package buttons.actions;

import canvas.CanvasController;

public class GoToProgress extends Actionable{
	CanvasController controller;
	
	public GoToProgress(CanvasController controller){
		super("Level Progress");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.setCanvasByName(CanvasController.CANVAS_PROGRESS);
		super.action();
	}
}
