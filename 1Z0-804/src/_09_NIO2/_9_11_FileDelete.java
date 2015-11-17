package _09_NIO2;

import java.io.IOException;
import java.nio.file.*;

public class _9_11_FileDelete {
	public static void main(String[] args) {
		if(args.length != 1){
		System.out.println("usage: _9_11_FileDelete <source-path>");
			System.exit(1);
		}
		Path pathSource = Paths.get(args[0]);
		try {
			Files.delete(pathSource);
			System.out.println("File deleted successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
