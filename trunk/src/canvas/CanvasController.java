package canvas;

import com.badlogic.gdx.Gdx;

public class CanvasController{
	public static final String CANVAS_SPLASH = "Canvas Splash";
	public static final String CANVAS_MENU = "Canvas Menu";
	public static final String CANVAS_OPTIONS = "Canvas Options";
	public static final String CANVAS_PROGRESS = "Canvas Progress";
	public static final String CANVAS_GAME = "Canvas Game";
	
	private CanvasBase activeCanvas;
	private CanvasSplash canvasSplash;
	private CanvasMenu canvasMenu;
	private CanvasOptions canvasOptions;
	private CanvasProgress canvasProgress;
	private CanvasGame canvasGame;
	
	public CanvasController(){
		canvasSplash = new CanvasSplash(this);
		canvasMenu = new CanvasMenu(this);
		canvasOptions = new CanvasOptions(this);
		canvasProgress = new CanvasProgress(this);
		canvasGame = new CanvasGame(this);
		activeCanvas = canvasSplash;
	}
	
	public CanvasBase getCanvas(){
		Gdx.input.setInputProcessor(activeCanvas);
		return activeCanvas;
	}
	
	public CanvasGame getCanvasGame(){
		return canvasGame;
	}
	
	public CanvasBase setCanvasByName(String name){
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
	
	public void dispose(){
		canvasSplash.dispose();
		canvasMenu.dispose();
		canvasOptions.dispose();
		canvasProgress.dispose();
		canvasGame.dispose();
	}
}
