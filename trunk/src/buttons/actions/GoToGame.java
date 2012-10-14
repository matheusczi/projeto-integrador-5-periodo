package buttons.actions;

import canvas.CanvasController;

public class GoToGame extends Actionable{
	CanvasController controller;
	
	public GoToGame(CanvasController controller){
		super("Start Game");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.setCanvasByName(CanvasController.CANVAS_GAME);
		super.action();
	}
}
