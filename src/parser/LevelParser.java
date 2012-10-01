package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import json.JSONTokener;
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
				
				jsonLevel = object.getJSONObject(key);
				
				level = new Level();
				level.setName(jsonLevel.getString("name"));
				

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
