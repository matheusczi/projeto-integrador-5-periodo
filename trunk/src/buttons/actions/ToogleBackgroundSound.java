package buttons.actions;

import canvas.CanvasController;

public class ToogleBackgroundSound extends Actionable{
	CanvasController controller;
	
	public ToogleBackgroundSound(CanvasController controller){
		super("Toogle Background Sound");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.toogleBackgroundSound();
	}
}
