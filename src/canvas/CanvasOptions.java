package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import objects.ObjectBase;
import buttons.Button;
import buttons.actions.GoToMenu;
import buttons.actions.ToogleBackgroundSound;
import buttons.actions.ToogleEffectSound;
import buttons.actions.ToogleSound;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class CanvasOptions extends CanvasBase{
	private ArrayList<ObjectBase> drawables;
	
	public CanvasOptions(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
		drawables.add(new Button(new GoToMenu(controller), controller.getButtonTexture9(), controller.getButtonTexture10(), new Rectangle(240, 320, 50, 30)));

		
		drawables.add(new Button(new ToogleBackgroundSound(controller), controller.getButtonTexture9(), controller.getButtonTexture10(), new Rectangle(240, 130, 50, 30)));
		drawables.add(new Button(new ToogleEffectSound(controller), controller.getButtonTexture9(), controller.getButtonTexture10(), new Rectangle(240, 170, 50, 30)));
		drawables.add(new Button(new ToogleSound(controller), controller.getButtonTexture9(), controller.getButtonTexture10(), new Rectangle(240, 210, 50, 30)));
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(controller.getBackGroundTexture5(), 0, 0);
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
