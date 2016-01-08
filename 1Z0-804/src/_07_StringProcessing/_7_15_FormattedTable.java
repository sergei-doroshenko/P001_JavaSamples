package _07_StringProcessing;

// This program demonstrates the use of format specifiers in printf 
class _7_15_FormattedTable {
	static void line() {
		System.out.println("-----------------------------------------------------------------");
	}
	static void printHeader() {
		System.out.printf("%-15s \t %s \t %s \t %s \n", 
			"Player", "Matches", "Goals", "Goals per match");

	}
	static void printRow(String player, int matches, int goals) {
		System.out.printf("%-15s \t %5d \t\t %d \t\t %.1f \n", 
			player, matches, goals, ((float)goals/(float)matches));
	}
	public static void main(String[] str) {
		_7_15_FormattedTable.line();
		_7_15_FormattedTable.printHeader();
		_7_15_FormattedTable.line();
		_7_15_FormattedTable.printRow("Demando", 100, 122);
		_7_15_FormattedTable.printRow("Mushi", 80, 100);
		_7_15_FormattedTable.printRow("Peale", 150, 180);
		_7_15_FormattedTable.line();
	}
}