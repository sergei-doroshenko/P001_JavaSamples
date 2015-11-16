package _09_NIO2;

import java.io.IOException;
import java.nio.file.*;

public class _9_9_FileCopy {
	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("usage: _9_9_FileCopy <source-path> <destination-path>");
			System.exit(1);
		}
		Path pathSource = Paths.get(args[0]);
		Path pathDestination = Paths.get(args[1]);
		try {
			Files.copy(pathSource, pathDestination);
			System.out.println("Source file copied successfully");		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}