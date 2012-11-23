#!/usr/bin/python

import argparse
import xml.etree.ElementTree as ET
import json

FLOOR = ' '
WALL = '#'
PACKAGE = '$'
GOAL = '.'
PACKAGE_ON_GOAL = '*'
SOKOBAN = '@'
SOKOBAN_ON_GOAL = '+'

SOKOBAN_START_POSITION = {"x":0, "y":0}
CURRENT_CELL = {"x":0, "y":0}


def read_file(filename):
	tree = ET.parse(filename)
	root = tree.getroot()
	level_collection = root.find("LevelCollection")
	return level_collection

def createJSON(obj):
	return json.dumps(obj, indent=4)

def write_file(filename, output):
	f = open(filename, 'w+')
	f.write(output)
	f.flush()
	f.close()
	return

def convert(root,level_name=None):
	global SOKOBAN_START_POSITION
	global CURRENT_CELL
	levels = {}

	for lvl in root:
		CURRENT_CELL["y"] = 0
		CURRENT_CELL["x"] = 0		
		id = lvl.get("Id")
		print("Id "+id)
		
		if ((level_name != id and not level_name) or level_name == id) and int(id) < 33:
			width = int(lvl.get("Width"))
			height = int(lvl.get("Height"))
			
			grid = {"rows":height, "columns":width, "block":"block", "target":"target", "map":[]}

			for line in lvl:
				CURRENT_CELL["y"] += 1
				CURRENT_CELL["x"] = 0
				for cell in line.text:
					CURRENT_CELL["x"] += 1
					tile = createTile(cell)
					grid["map"].append(tile)
				for i in range(CURRENT_CELL["x"], width):
					CURRENT_CELL["x"] += 1
					tile = createTile(FLOOR)
					grid["map"].append(tile)

			character = createCharacter()
			character["startPosition"]["x"] = SOKOBAN_START_POSITION["x"]
			character["startPosition"]["y"] = SOKOBAN_START_POSITION["y"]

			levels["level"+str(int(id)+3)] = {"score":createScore(), "tiles":{}, "character":character, "grid":grid}

	return levels

def createTile(cell):
	global SOKOBAN_START_POSITION
	global CURRENT_CELL
	tile = {}
	if cell == FLOOR:
		tile = {"tile":"ground", "hasBlock":False, "isBlockTarget":False, "walkable":True}
	if cell == WALL:
		tile = {"tile":"wall", "hasBlock":False, "isBlockTarget":False, "walkable":False}
	if cell == PACKAGE:
		tile = {"tile":"ground", "hasBlock":True, "isBlockTarget":False, "walkable":True}
	if cell == GOAL:
		tile = {"tile":"ground", "hasBlock":False, "isBlockTarget":True, "walkable":True}
	if cell == PACKAGE_ON_GOAL:
		tile = {"tile":"ground", "hasBlock":True, "isBlockTarget":True, "walkable":True}
	if cell == SOKOBAN:
		tile = {"tile":"ground", "hasBlock":False, "isBlockTarget":False, "walkable":True}
		SOKOBAN_START_POSITION["x"] = CURRENT_CELL["x"]
		SOKOBAN_START_POSITION["y"] = CURRENT_CELL["y"]
	if cell == SOKOBAN_ON_GOAL:
		tile = {"tile":"ground", "hasBlock":False, "isBlockTarget":True, "walkable":True}
		SOKOBAN_START_POSITION["x"] = CURRENT_CELL["x"]
		SOKOBAN_START_POSITION["y"] = CURRENT_CELL["y"]

	return tile

def createScore():
	return {"minSteps":0, "minBoxSteps":0, "topScore":0}

def createCharacter():
	return {"sprite":"", "tile-width":0, "tile-height":0, "rows":0, "columns":0, "keyframes":[], "startPosition":{"x":0, "y":0}}

if __name__ == "__main__":

	parser = argparse.ArgumentParser(description='Convert XML format level to JSON format')
	parser.add_argument('--in_file', dest='in_file', type=str, required=True, help='input xml file')
	parser.add_argument('--out_file', dest='out_file', default='lvl_converter_out.json',type=str, help='output json file')
	parser.add_argument('--level_name', dest='level_name', type=str, default='', help='level name')

	args = parser.parse_args()

	level_name = None

	input_file = args.in_file

	output_file = args.out_file

	if args.level_name:
		level_name = args.level_name

	xml_level = read_file(input_file)

	obj_level = convert(xml_level, level_name)

	json_level = createJSON(obj_level)

	write_file(output_file, json_level)

