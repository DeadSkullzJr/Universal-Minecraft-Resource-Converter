package bjtmastermind.umrc.program.fileManipulation;

import java.io.File;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import bjtmastermind.umrc.program.Main;

public class Zip extends FileManipulation {
	public static void zip() throws ZipException {
		ZipFile zp = new ZipFile(fileCopied+".zip");
		zp.addFolder(fileCopied);
		if(ToType == 3) zip_to_mcpack(new File(fileCopied+".zip"));
	}
	
	public static void unzip() throws ZipException {
		ZipFile zp = new ZipFile(file);
		zp.extractAll(fileCopied.toString());
	}

	private static void zip_to_mcpack(File zip) {
		if (Main.ToType == 3) {
			if (zip.getName().contains(".zip")) {
				File f = new File(zip.getAbsolutePath().substring(0, zip.getAbsolutePath().lastIndexOf("."))+".mcpack");
				zip.renameTo(f);
			}
		}
	}
}