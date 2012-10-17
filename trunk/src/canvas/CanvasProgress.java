package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import objects.ObjectBase;

import buttons.Button;
import buttons.actions.GoToLevel1;
import buttons.actions.GoToMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CanvasProgress extends CanvasBase{
	private ArrayList<ObjectBase> drawables;
	
	public CanvasProgress(CanvasController controller){
		super(controller);
		
		drawables = new ArrayList<ObjectBase>();
		Texture button1 = new Texture(Gdx.files.internal("res/image_files/buttons/button1.png"));
		Texture button2 = new Texture(Gdx.files.internal("res/image_files/buttons/button2.png"));
		
		drawables.add(new Button(new GoToLevel1(controller), button1, button2, new Rectangle(100, 80, 100, 100)));
		drawables.add(new Button(new GoToMenu(controller), button1, button2, new Rectangle(100, 320, 100, 100)));
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