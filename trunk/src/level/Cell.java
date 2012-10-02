package level;

public class Cell {
	public String tile;
	public boolean hasBlock;
	public boolean isBlockTarget;
	public boolean isWalkable;
	
	public Cell(String tile, boolean hasBlock, boolean isBlockTarget, boolean isWalkable){
		this.tile = tile;
		this.hasBlock = hasBlock;
		this.isBlockTarget = isBlockTarget;
		this.isWalkable = isWalkable;
	}
	
	public Cell(){
		
	}
}
