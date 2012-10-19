package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import buttons.Button;
import buttons.actions.GoToExit;
import buttons.actions.GoToOptions;
import buttons.actions.GoToProgress;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import objects.ObjectBase;

public class CanvasMenu extends CanvasBase{
	private ArrayList<ObjectBase> drawables;

	Texture background = new Texture(Gdx.files.internal("res/image_files/background.jpg"));
	
	public CanvasMenu(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
		Texture button1 = new Texture(Gdx.files.internal("res/image_files/buttons/button5.png"));
		Texture button2 = new Texture(Gdx.files.internal("res/image_files/buttons/button3.png"));
		
		drawables.add(new Button(new GoToOptions(controller), button1, button2, new Rectangle(100, 80, 100, 100)));
		drawables.add(new Button(new GoToProgress(controller), button1, button2, new Rectangle(100, 200, 100, 100)));
		drawables.add(new Button(new GoToExit(controller), button1, button2, new Rectangle(100, 320, 100, 100)));
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(background, 0, 0);
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
