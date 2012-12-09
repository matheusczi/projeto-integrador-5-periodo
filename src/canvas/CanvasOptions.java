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
		drawables.add(new Button(new GoToMenu(controller), controller.getButtonTexture5(), controller.getButtonTexture6(), new Rectangle(Main.width - 120, Main.height - 80, 50, 50)));

		
		drawables.add(new Button(new ToogleBackgroundSound(controller), controller.getButtonTexture5(), controller.getButtonTexture6(), new Rectangle(70, 50, 100, 100)));
		drawables.add(new Button(new ToogleEffectSound(controller), controller.getButtonTexture5(), controller.getButtonTexture6(), new Rectangle(70, 180, 100, 100)));
		drawables.add(new Button(new ToogleSound(controller), controller.getButtonTexture5(), controller.getButtonTexture6(), new Rectangle(70, 310, 100, 100)));
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(controller.getBackGroundTexture3(), 0, 0);
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
