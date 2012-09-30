package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import persistence.ProgressData;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import json.JSONTokener;

public class LoadPersistence {
	
	public static ProgressData load(String filename){
		JSONTokener tokener = null;
		ProgressData data = null;
		try {
			tokener = new JSONTokener(new FileInputStream(filename));
			JSONObject object = new JSONObject(tokener);
			JSONArray objectKeys = object.names();
			JSONObject jsonLevel = null;

			int length = objectKeys.length();
			// change this settings below to read from configuration file
			data = new ProgressData(length*2, (float) 0.75);

			for(int i = 0; i < length; i++){
				String key = objectKeys.getString(i);
				jsonLevel = object.getJSONObject(key);
				data.addEntry(key, jsonLevel.getInt("bestTime"),
						jsonLevel.getInt("bestScore"),
						jsonLevel.getInt("totalTimePlayed"));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
