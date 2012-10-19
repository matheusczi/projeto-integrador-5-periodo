package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import buttons.Button;
import buttons.actions.GoToExit;
import buttons.actions.GoToOptions;
import buttons.actions.GoToProgress;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

import objects.ObjectBase;

public class CanvasMenu extends CanvasBase{
	private ArrayList<ObjectBase> drawables;
	
	public CanvasMenu(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
		
		Texture button1 = controller.getButtonTexture3();
		Texture button2 = controller.getButtonTexture4();
		
		drawables.add(new Button(new GoToProgress(controller), button1, button2, new Rectangle(70, 50, 100, 100)));
		drawables.add(new Button(new GoToOptions(controller), button1, button2, new Rectangle(70, 180, 100, 100)));
		drawables.add(new Button(new GoToExit(controller), button1, button2, new Rectangle(Main.width - 120, Main.height - 80, 50, 50)));
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
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
