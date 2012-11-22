package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import objects.ObjectBase;

import buttons.Button;
import buttons.actions.GoToMenu;
import buttons.actions.levels.GoToLevel1;
import buttons.actions.levels.GoToLevel2;
import buttons.actions.levels.GoToLevel3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class CanvasProgress extends CanvasBase{
	private ArrayList<ObjectBase> drawables;
	
	public CanvasProgress(CanvasController controller){
		super(controller);
		
		drawables = new ArrayList<ObjectBase>();
		Texture button1 = controller.getButtonTexture5();
		Texture button2 = controller.getButtonTexture6();
		
		drawables.add(new Button(new GoToLevel1(controller), button1, button2, new Rectangle(100, 50, 100, 50)));
		drawables.add(new Button(new GoToLevel2(controller), button1, button2, new Rectangle(100, 150, 100, 50)));
		drawables.add(new Button(new GoToLevel3(controller), button1, button2, new Rectangle(100, 250, 100, 50)));
		drawables.add(new Button(new GoToMenu(controller), button1, button2, new Rectangle(Main.width - 120, Main.height - 80, 50, 50)));
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(controller.getBackGroundTexture2(), 0, 0);
		for(ObjectBase drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	@Override
	public void update(float deltaTime){
		for(ObjectBase drawable : drawables){
			ObjectBase temporaryDrawable = drawable;
			temporaryDrawable.update(deltaTime);
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
