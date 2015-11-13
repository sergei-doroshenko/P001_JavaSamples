package _09_NIO2;

import java.nio.file.*;
// illustrates how to use compareTo and equals and also shows the difference between the two methods 
class _9_3_PathCompare1 {
	public static void main(String[] args) {
		Path path1 = Paths.get("1Z0-804");
//		Path path2 = Paths.get("D:\\OCPJP7\\programs\\NIO2\\Test");
		Path path2 = Paths.get("/home/sergei/projects/idea_projects/goCourses/1Z0-804");
		// comparing two paths using compareTo() method
		System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2) == 0));
	
		//comparing two paths using equals() method
		System.out.println("path1.equals(path2) is: " + path1.equals(path2));
		
		// comparing two paths using equals() method with absolute path
		System.out.println("path2.equals(path1.toAbsolutePath()) is " 
				+ path2.equals(path1.toAbsolutePath()));

		System.out.println("-----------------------------------------------------------------------------------");
		Path aPath = Paths.get("abc");
		Path bPath = Paths.get("abd");
		System.out.println("\"abc\" path compareTo \"abd\" path: "
				+ aPath.compareTo(bPath)); // compare lexicographically returns -1
		System.out.println("\"abc\".charAt(2) - \"abd\".charAt(2): "
				+ String.valueOf("abc".charAt(2) - "abd".charAt(2))); // c - d = -1

		System.out.println("'c' - 'd': " + String.valueOf('c' - 'd')); // -1
	}
}