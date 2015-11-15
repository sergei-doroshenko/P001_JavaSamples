package _09_NIO2;

import java.nio.file.*;

class _9_6_FilePermissions {
	public static void main(String[] args) {
		Path path = Paths.get(args[0]);
		System.out.printf( "Readable: %b, Writable: %b, Executable: %b ", 
				Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path)); 
	}
}
