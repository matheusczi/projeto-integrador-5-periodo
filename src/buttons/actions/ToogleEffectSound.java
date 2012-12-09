package buttons.actions;

import canvas.CanvasController;

public class ToogleEffectSound extends Actionable{
	CanvasController controller;
	
	public ToogleEffectSound(CanvasController controller){
		super("Toogle Effect Sound");
		this.controller = controller;
	}
	
	@Override
	public void action(){
		controller.toogleEffectSound();
	}
}
