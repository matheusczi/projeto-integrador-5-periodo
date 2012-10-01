package level;

import java.util.ArrayList;

public class Level {
	private int rows;
	private int columns;
	private String name;
	
	public Level(){
		rows = 0;
		columns = 0;
		name = "";
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
