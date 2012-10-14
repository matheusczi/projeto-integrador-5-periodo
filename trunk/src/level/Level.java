package level;

import utils.CommonResources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	private int rows;
	private int columns;
	private String name;
	private Cell block;
	private Cell target;
	private int playerStartX;
	private int playerStartY;
	private Cell[][] grid;
	
	private int cell_width = 40;
	private int cell_height = 40;
	
	public Level(int rows, int columns, String name){
		this.rows = rows;
		this.columns = columns;
		this.name = name;
		this.grid = new Cell[rows][columns];
		block = null;
		target = null;
		playerStartX = 0;
		playerStartY = 0;
	}

	public void setBlock(Cell b){
		block = b;
	}
	
	public void setTarget(Cell t){
		target = t;
	}
	
	public void setStartPosition(int x, int y){
		playerStartX = x;
		playerStartY = y;
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
				spriteBatch.draw(t, i*cell_width, j*cell_height);
				if(c.isBlockTarget){
					spriteBatch.draw(res.assets.get(target.tile), i*cell_width, j*cell_height);
				}
				if(c.hasBlock){
					spriteBatch.draw(res.assets.get(block.tile), i*cell_width, j*cell_height);
				}
			}
		}
	}
	
}
