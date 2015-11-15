package _09_NIO2;

import java.nio.file.*;

// Class to illustrate how to use Path interface and its methods 
public class _9_1_PathInfo1 {
	public static void main(String[] args) {
		// create a Path object by calling static method get() in Paths class 
		Path testFilePath = Paths.get("/home/sergei/projects/idea_projects/goCourses/testfile.txt");
		
		// retrieve basic information about path		
		System.out.println("Printing file information: ");
		System.out.println("\t file name: " + testFilePath.getFileName());
		System.out.println("\t root of the path: " + testFilePath.getRoot());
		System.out.println("\t parent of the target: " + testFilePath.getParent());
		
		// print path elements
		System.out.println("Printing elements of the path: ");
		for(Path element : testFilePath) {
			System.out.println("\t path element: " + element);  
		}
	}
 } 
