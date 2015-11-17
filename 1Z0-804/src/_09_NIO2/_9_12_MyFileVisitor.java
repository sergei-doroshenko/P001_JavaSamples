package _09_NIO2;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class _9_12_MyFileVisitor extends SimpleFileVisitor<Path> {

	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
		System.out.println("file name:" + path.getFileName());
		return FileVisitResult.CONTINUE;	
	}

	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes){
		System.out.println("----------Directory name:" + path + "----------");
		return FileVisitResult.CONTINUE;
	}
}
