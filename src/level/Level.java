package level;

import java.util.ArrayList;

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

}
