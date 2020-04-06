package wio;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("Arquivo.txt");
		try {
			boolean newFile = file.createNewFile();
			System.out.println(newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
