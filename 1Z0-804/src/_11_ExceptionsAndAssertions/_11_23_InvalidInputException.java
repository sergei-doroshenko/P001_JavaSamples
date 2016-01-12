package _11_ExceptionsAndAssertions;

// a custom "unchecked exception" that is meant to be thrown 
// when the input provided by the user is invalid 
class _11_23_InvalidInputException extends RuntimeException {
	// default constructor 
	public _11_23_InvalidInputException() {
		super();
	}

	// constructor that takes the String detailed information we pass while 
	// raising an exception
	public _11_23_InvalidInputException(String str) {
		super(str);
	}

	// constructor that remembers the cause of the exception and 
	// throws the new exception
	public _11_23_InvalidInputException(Throwable originalException) {
		super(originalException);
	}

	// first argument takes detailed information string created while 
	// raising an exception
	// and the second argument is to remember the cause of the exception 
	public _11_23_InvalidInputException(String str, Throwable originalException) {
		super(str, originalException);
	}
}