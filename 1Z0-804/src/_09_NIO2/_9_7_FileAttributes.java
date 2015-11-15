package _09_NIO2;

import java.io.IOException;
import java.nio.file.*;

class _9_7_FileAttributes {
	public static void main(String[] args) {
		Path path = Paths.get(args[0]);
		try {
			Object object = Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS);
			System.out.println("Creation time: " + object);
			
			object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
			System.out.println("Last modified time: " + object);
			
			object = Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS);
			System.out.println("Size: " + object);
			
			object = Files.getAttribute(path, "dos:hidden", LinkOption.NOFOLLOW_LINKS);
			System.out.println("isHidden: " + object);
			
			object = Files.getAttribute(path, "isDirectory", LinkOption.NOFOLLOW_LINKS);
			System.out.println("isDirectory: " + object);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
