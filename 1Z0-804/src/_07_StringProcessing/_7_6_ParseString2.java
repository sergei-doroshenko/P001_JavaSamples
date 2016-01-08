package _07_StringProcessing;

public class _7_6_ParseString2 {
	public static void main(String[] args) {
		String str = "c:\\work\\programs\\parser";
		String [] dirList = str.split("\\\\");
		for (String aDirList : dirList) {
			System.out.println(aDirList);
		}
	}
}
