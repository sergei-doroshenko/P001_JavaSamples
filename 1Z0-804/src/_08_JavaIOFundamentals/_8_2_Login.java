package _08_JavaIOFundamentals;

import java.io.Console;
import java.util.Arrays;

// code to illustrate the use of readPassword method 
public class _8_2_Login {
	public static void main(String []args) {
		Console console = System.console();
		if(console != null) {
			String userName;
			char[] password;

			userName = console.readLine("Enter your username: ");

			// typed characters for password will not be displayed in the screen 
			password = console.readPassword("Enter password: ");

			// password is a char[]: convert it to a String first before comparing contents
			if(userName.equals("scrat") && new String(password).equals("nuts")) {
				// we're hardcoding username and password here for
				// illustration, don’t do such hardcoding in pratice!
				console.printf("login successful!");
			} else {
				console.printf("restart application and try again"); 
			}
			// "empty" the password since its use is over 
			Arrays.fill(password, ' '); 
		} else {
			System.out.println("Console error");
		}
	}
}