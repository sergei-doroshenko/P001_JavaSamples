package _11_ExceptionsAndAssertions;

// A simple program without exception handling code
class _11_1_Echo {
	public static void main(String []args) {
		if(args.length == 0) { 
			// no arguments passed – display an error to the user
			/*System.out.println("Error: No input passed to echo command... ");
			System.exit(-1);*/
			// no arguments passed - throw an exception
			throw new IllegalStateException("No input passed to echo command");
		} else {
			for(String str : args) {
				// command line arguments are separated and passed as an array
				// print them by adding a space between the array elements 
				System.out.print(str + " "); 
			}
		}
	}
}