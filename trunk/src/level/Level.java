package level;

import java.util.ArrayList;

import utils.CommonResources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	private int rows;
	private int columns;
	private String name;
	private Cell[][] grid;
	
	public Level(int rows, int columns, String name){
		this.rows = rows;
		this.columns = columns;
		this.name = name;
		this.grid = new Cell[rows][columns];
	}

	public void setCell(int x, int y, Cell c){
		this.grid[x][y] = c;
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public String getName() {
		return name;
	}

	public void draw(SpriteBatch spriteBatch){
		CommonResources res = CommonResources.getInstance();
		for(int i=0; i < rows; i++){
			for(int j=0; j< columns; j++){
				Cell c = grid[i][j];
				Texture t = res.assets.get(c.tile);
				spriteBatch.draw(t, i*t.getWidth(), j*t.getHeight());			
			}
		}
	}
	
}
