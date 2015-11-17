package _09_NIO2;

import java.nio.file.*;
import java.io.*;

public class _9_12_FileTreeWalk {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("usage: FileWalkTree <source-path>");
			System.exit(-1);
		}
		Path pathSource = Paths.get(args[0]);
		try {
			Files.walkFileTree(pathSource, new _9_12_MyFileVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
