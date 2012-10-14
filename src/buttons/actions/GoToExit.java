package buttons.actions;

import canvas.CanvasController;

public class GoToExit extends Actionable{
	CanvasController controller;
	
	public GoToExit(CanvasController controller){
		super("Exit");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		//Gdx.app.exit();
		System.exit(0);
		super.action();
	}
}
