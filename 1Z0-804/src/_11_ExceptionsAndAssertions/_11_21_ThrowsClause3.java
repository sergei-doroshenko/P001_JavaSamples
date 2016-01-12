package _11_ExceptionsAndAssertions;

import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.AccountNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class _11_21_ThrowsClause3 {
	// since this method does not handle FileNotFoundException, 
	// the method must declare this exception in the throws clause 
	public int readIntFromFile() throws FileNotFoundException {
		Scanner consoleScanner = new Scanner(new File("integer.txt")); 
		return consoleScanner.nextInt(); 
	}

	public void read() throws IOException {
		throw null;
	}

	public void login() {
		try {
			if (true) {
				throw new AccountExpiredException();
			} else {
				throw new AccountNotFoundException();
			}

		} catch (AccountExpiredException | AccountNotFoundException e) {

		}
	}

	// since readIntFromFile() throws FileNotFoundException and main() does not handle 
	// it, the main() method declares this exception in its throws cause 
	public static void main(String []args) throws FileNotFoundException {
		System.out.println("Reading an integer from the file 'integer.txt': ");
		System.out.println("You typed the integer value: " + new _11_21_ThrowsClause3().readIntFromFile());
	}
}