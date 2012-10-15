package objects;

import java.awt.Rectangle;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class ObjectBase{
	protected Rectangle bounds;
	
	public abstract void render(SpriteBatch spriteBatch);
	
	public abstract void update(float deltaTime);
	
	public void dispose(){

	}
	
	public void keyTyped(char character){

	}
	
	public void touchDown(int x, int y, int pointer, int button){

	}
	
	public void touchMove(int x, int y){

	}
	
	public int getX(){
		return bounds.x;
	}
	
	public int getY(){
		return bounds.y;
	}
	
	public void setX(int x){
		bounds.x = x;
	}
	
	public void setY(int y){
		bounds.y = y;
	}
	
	public int getWidth(){
		return bounds.width;
	}
	
	public int getHeight(){
		return bounds.height;
	}
	
	public void setWidth(int width){
		bounds.width = width;
	}
	
	public void setHeight(int height){
		bounds.height = height;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
	
	public void setBounds(Rectangle bounds){
		this.bounds = bounds;
	}
}
