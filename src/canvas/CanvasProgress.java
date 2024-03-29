package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import objects.ObjectBase;
import buttons.Button;
import buttons.actions.GoToMenu;
import buttons.actions.levels.GoToLevel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class CanvasProgress extends CanvasBase{
	private ArrayList<ObjectBase> drawables;
	
	public CanvasProgress(CanvasController controller){
		super(controller);
		
		drawables = new ArrayList<ObjectBase>();
		Texture button1 = controller.getButtonTexture7();
		Texture button2 = controller.getButtonTexture8();
		
		drawables.add(new Button(new GoToLevel(controller, "Level 1", "level1", "res/data/levels.json"), button1, button2, new Rectangle(110, 120, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 2", "level2", "res/data/levels.json"), button1, button2, new Rectangle(110, 160, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 3", "level3", "res/data/levels.json"), button1, button2, new Rectangle(110, 200, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 4", "level4", "res/data/levels.json"), button1, button2, new Rectangle(110, 240, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 5", "level5", "res/data/levels.json"), button1, button2, new Rectangle(110, 280, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 6", "level6", "res/data/levels.json"), button1, button2, new Rectangle(110, 320, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 7", "level7", "res/data/levels.json"), button1, button2, new Rectangle(110, 360, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 8", "level8", "res/data/levels.json"), button1, button2, new Rectangle(300, 120, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 9", "level9", "res/data/levels.json"), button1, button2, new Rectangle(300, 160, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 10", "level10", "res/data/levels.json"), button1, button2, new Rectangle(300, 200, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 11", "level11", "res/data/levels.json"), button1, button2, new Rectangle(300, 240, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 12", "level12", "res/data/levels.json"), button1, button2, new Rectangle(300, 280, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 13", "level13", "res/data/levels.json"), button1, button2, new Rectangle(300, 320, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 14", "level14", "res/data/levels.json"), button1, button2, new Rectangle(300, 360, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 15", "level15", "res/data/levels.json"), button1, button2, new Rectangle(490, 120, 50, 30)));
		drawables.add(new Button(new GoToLevel(controller, "Level 16", "level16", "res/data/levels.json"), button1, button2, new Rectangle(490, 160, 50, 30)));
		// drawables.add(new Button(new GoToLevel(controller, "Level 17", "level17", "res/data/levels.json"), button1, button2, new Rectangle(100, 250, 100, 50)));
		// drawables.add(new Button(new GoToLevel(controller, "Level 18", "level18", "res/data/levels.json"), button1, button2, new Rectangle(100, 250, 100, 50)));
		// drawables.add(new Button(new GoToLevel(controller, "Level 19", "level19", "res/data/levels.json"), button1, button2, new Rectangle(100, 250, 100, 50)));
		// drawables.add(new Button(new GoToLevel(controller, "Level 20", "level20", "res/data/levels.json"), button1, button2, new Rectangle(100, 250, 100, 50)));
		drawables.add(new Button(new GoToMenu(controller), button1, button2, new Rectangle(490, 350, 50, 40)));
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(controller.getBackGroundTexture4(), 0, 0);
		for(ObjectBase drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	@Override
	public void update(float deltaTime){
		for(ObjectBase drawable : drawables){
			ObjectBase temporaryDrawable = drawable;
			temporaryDrawable.update(deltaTime);
			
			// if(temporaryDrawable instanceof Level){
			// if(((Level)temporaryDrawable).hasWon()){
			//
			// }
			// }
		}
	}
	
	@Override
	public void dispose(){
		for(ObjectBase drawable : drawables){
			drawable.dispose();
		}
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button){
		for(ObjectBase drawable : drawables){
			drawable.touchDown(x, y, pointer, button);
		}
		return super.touchDown(x, y, pointer, button);
	}
	
	@Override
	public boolean touchMoved(int x, int y){
		for(ObjectBase drawable : drawables){
			drawable.touchMove(x, y);
		}
		return super.touchMoved(x, y);
	}
}
