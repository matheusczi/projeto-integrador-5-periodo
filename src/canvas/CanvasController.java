package canvas;

import core.Application;

public class CanvasController{
	public static final String CANVAS_SPLASH = "Canvas Splash";
	public static final String CANVAS_MENU = "Canvas Menu";
	public static final String CANVAS_OPTIONS = "Canvas Options";
	public static final String CANVAS_PROGRESS = "Canvas Progress";
	public static final String CANVAS_GAME = "Canvas Game";
	
	private Canvas activeCanvas;
	private CanvasSplash canvasSplash;
	private CanvasMenu canvasMenu;
	private CanvasOptions canvasOptions;
	private CanvasProgress canvasProgress;
	private CanvasGame canvasGame;
	
	public CanvasController(Application application){
		if(application != null){
			canvasSplash = new CanvasSplash(application);
			canvasMenu = new CanvasMenu(application);
			canvasOptions = new CanvasOptions(application);
			canvasProgress = new CanvasProgress(application);
			canvasGame = new CanvasGame(application);
			activeCanvas = canvasSplash;
		}
	}
	
	public Canvas getCanvas() {
		return activeCanvas;
	}
	
	public Canvas setCanvasByName(String name) {
		if(name == CANVAS_SPLASH){
			activeCanvas = canvasSplash;
		}else if(name == CANVAS_MENU){
			activeCanvas = canvasMenu;
		}else if(name == CANVAS_OPTIONS){
			activeCanvas = canvasOptions;
		}else if(name == CANVAS_PROGRESS){
			activeCanvas = canvasProgress;
		}else if(name == CANVAS_GAME){
			activeCanvas = canvasGame;
		}
		return activeCanvas;
	}
}
