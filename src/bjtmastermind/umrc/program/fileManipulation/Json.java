package bjtmastermind.umrc.program.fileManipulation;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bjtmastermind.umrc.program.Main;

public class Json {

	public static void main(String dir, String use) {
		File rootFolder = new File(Main.fileCopied+"/");
		JSONParser jp = new JSONParser();
		List<String> rFrom = new ArrayList<>();
		List<String> rTo = new ArrayList<>();
		List<String> mFrom = new ArrayList<>();
		List<String> mTo = new ArrayList<>();
		File renameFrom;
		File renameTo;
		File moveFrom;
		File moveTo;
		String remove;
		String make;

		try {
			File f = new File(Json.class.getResource("/jsons/"+dir+"/"+use).getFile());
			JSONObject jo = (JSONObject) jp.parse(new FileReader(f));

			if(dir == "renames") {
				JSONArray rename = (JSONArray) jo.get("rename");
				for(int i = 0; i < rename.size(); i++) {
					JSONObject jo1 = (JSONObject) rename.get(i);
					rFrom.add(jo1.get("from").toString());
					rTo.add(jo1.get("to").toString());
				}
				for(int i = 0; i < rFrom.size(); i++) {
					renameFrom = new File(rootFolder+"/"+rFrom.get(i));
					renameTo = new File(rootFolder+"/"+rTo.get(i));
					renameFrom.renameTo(renameTo);
				}
			} else if(dir == "moves") {
				JSONArray move = (JSONArray) jo.get("move");
				for(int i = 0; i < move.size(); i++) {
					JSONObject jo1 = (JSONObject) move.get(i);
					mFrom.add(jo1.get("from").toString());
					mTo.add(jo1.get("to").toString());
				}
				for(int i = 0; i < mFrom.size(); i++) {
					moveFrom = new File(rootFolder+"/"+mFrom.get(i));
					moveTo = new File(rootFolder+"/"+mTo.get(i));
					try {
						Files.move(moveFrom.toPath(), moveTo.toPath());
					} catch(NoSuchFileException e) {}
				}
			} else if(dir == "deletes") {
				JSONArray delete = (JSONArray) jo.get("delete");
				for (int i = 0; i < delete.size(); i++) {
					remove = delete.get(i).toString();
					File remove1 = new File(rootFolder+"/"+remove);
					recursiveDelete(remove1);					
				}
			} else if(dir == "creates") {
				JSONArray create = (JSONArray) jo.get("create");
				for (int i = 0; i < create.size(); i++) {
					make = create.get(i).toString();
					File make1 = new File(rootFolder+"/"+make);
					make1.mkdir();
				}
				if(Main.FromType == 2 && Main.ToType == 1) {
					File from = new File(rootFolder+".zip");
					File to = new File(rootFolder.toString());
					from.renameTo(to);
				}
			} else {
				System.out.println("Error: Could not find json file selected.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/**
 * This utility class can be used to delete 
 * folders recursively in java
 * @author pankaj
 * https://www.journaldev.com/833/java-delete-directory-folder
 * Modified to be a method by BJTMastermind
 */
	private static void recursiveDelete(File file) {
		if (!file.exists())
			return;
	        
	    if (file.isDirectory()) {
	        for (File f : file.listFiles()) {
	        	recursiveDelete(f);
	        }
	    }
	    file.delete();
	}
}