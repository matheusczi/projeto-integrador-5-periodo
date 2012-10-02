package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import json.JSONTokener;
import level.Cell;
import level.Level;

public class LevelParser {
	
	public static Level loadLevel(String id, String filename){
		JSONTokener tokener = null;
		Level level = null;
		try {
			tokener = new JSONTokener(new FileInputStream(filename));
			JSONObject object = new JSONObject(tokener);
			JSONArray objectKeys = object.names();
			JSONObject jsonLevel = null;
			
			int length = objectKeys.length();
			
			String key = "";
			for(int i = 0; i < length; i++){
				key = objectKeys.getString(i);
				
				if(key!=id)
					continue;
				
				//assets stuff
				
				
				//grid and map stuff
				jsonLevel = object.getJSONObject(key);
				JSONObject grid = jsonLevel.getJSONObject("grid");
				int rows = grid.getInt("rows");
				int columns = grid.getInt("columns");
				level = new Level(rows, columns, jsonLevel.getString("name"));
				JSONArray map = grid.getJSONArray("map");
				JSONObject jcell = null;
				Cell cell = null;
				for(int j=0; j < map.length(); j++){
					jcell = map.getJSONObject(j);
					cell = new Cell(jcell.getString("tile"),
							jcell.getBoolean("hasBlock"),
							jcell.getBoolean("isBlockTarget"),
							jcell.getBoolean("walkable"));
					
					level.setCell(j%rows, (int) Math.floor(j/rows), cell);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
