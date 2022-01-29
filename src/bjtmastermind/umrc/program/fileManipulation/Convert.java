package bjtmastermind.umrc.program.fileManipulation;

import bjtmastermind.umrc.program.Main;
import bjtmastermind.umrc.program.display.Dialog;

public class Convert extends Main {

	@SuppressWarnings("unused")
	public static void ResourceToTexture() throws Exception {
		FileManipulation.copy(file, fileCopied);
		FileManipulation.tga_to_png();
		/*FileManipulation.crop();
		//FileManipulation.stitch();
		FileManipulation.convert_pack();
		Json.main("creates", "jr2bt.json");
		Json.main("renames", "jr2jt.json");
		Json.main("moves", "jr2jt.json");
		Json.main("deletes", "jr2bt.json");
		Zip.zip();
		Dialog dialog = new Dialog();
		Dialog.convertDone();*/
	}

	@SuppressWarnings("unused")
	public static void ResourceToBedrock() throws Exception {
		FileManipulation.copy(file, fileCopied);
		FileManipulation.convert_pack();
		Json.main("creates", "jr2bt.json");
		Json.main("renames", "jr2bt.json");
		Json.main("moves", "jr2bt.json");
		Json.main("deletes", "jr2bt.json");
		Zip.zip();
		Dialog dialog = new Dialog();
		Dialog.convertDone();
	}

	@SuppressWarnings("unused")
	public static void TextureToResource() throws Exception {
		Zip.unzip();
		FileManipulation.unstitch();
		FileManipulation.convert_pack();
		Json.main("creates", "jt2jr.json");
		Json.main("renames", "jt2jr.json");
		Json.main("moves", "jt2jr.json");
		Json.main("deletes", "jt2jr.json");
		Dialog dialog = new Dialog();
		Dialog.convertDone();
	}

	@SuppressWarnings("unused")
	public static void TextureToBedrock() throws Exception {
		Zip.unzip();
		FileManipulation.unstitch();
		FileManipulation.convert_pack();
		Json.main("creates", "jt2bt.json");
		Json.main("renames", "jt2bt.json");
		Json.main("moves", "jt2bt.json");
		Json.main("deletes", "jt2bt.json");
		Zip.zip();
		Dialog dialog = new Dialog();
		Dialog.convertDone();
	}

	@SuppressWarnings("unused")
	public static void BedrockToResource() throws Exception {
		if(file.isFile()) Zip.unzip();
		if(file.isDirectory()) FileManipulation.copy(file, fileCopied);
		FileManipulation.convert_pack();
		Json.main("creates", "bt2jr.json");
		Json.main("renames", "bt2jr.json");
		Json.main("moves", "bt2jr.json");
		Json.main("deletes", "bt2jr.json");
		Dialog dialog = new Dialog();
		Dialog.convertDone();
	}

	@SuppressWarnings("unused")
	public static void BedrockToTexture() throws Exception {
		if(file.isFile()) Zip.unzip();
		if(file.isDirectory()) FileManipulation.copy(file, fileCopied);
		FileManipulation.crop();
		FileManipulation.stitch();
		FileManipulation.convert_pack();
		Json.main("creates", "bt2jt.json");
		Json.main("renames", "bt2jt.json");
		Json.main("moves", "bt2jt.json");
		Json.main("deletes", "bt2jt.json");
		Zip.zip();
		Dialog dialog = new Dialog();
		Dialog.convertDone();
	}
}
