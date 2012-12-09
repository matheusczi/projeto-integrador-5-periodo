package buttons.actions;

import canvas.CanvasController;

public class ToogleSound extends Actionable{
	CanvasController controller;
	
	public ToogleSound(CanvasController controller){
		super("Toogle Sound");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.toogleEffectSound();
	}
}
