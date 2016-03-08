package cn.cjtblog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.cjtblog.domain.Image;

public class FileUtil {

	public static void saveFile(String filePath, String fileName, byte[] bytes) {
		String fileFullName = filePath + fileName;
		saveFile(fileFullName, bytes);
	}

	public static void makeDir(String nodeDir) {
		File dir = new File(Image.SAVEIMAGEDIR + nodeDir);
		if (dir.exists()) {
			System.out.println(dir.getAbsolutePath() + " is exist");
			return;
		}
		if (!dir.mkdirs()) {
			System.out.println("mkdir " + nodeDir + "failed");
		} else {
			try {
				System.out.println("mkdir " + dir.getCanonicalPath() + "success");
			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
		}
	}

	public static void saveFile(String fileFullName, byte[] bytes) {
		File file = new File(fileFullName);
		if (file.exists()) {
			System.out.println("file has exitst");
			return;
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (FileOutputStream fileOutput = new FileOutputStream(file)) {
			fileOutput.write(bytes);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void deleteFileByFullName(String fileFullName) {
		File file = new File(fileFullName);
		if (file.exists()) {
			file.delete();
		}
	}
}
