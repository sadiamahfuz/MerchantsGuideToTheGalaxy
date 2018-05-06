/**
 * 
 */
package main.java;

/**
 * Exception to notify of errors in an Intergalactic Number
 * @author mahfuzs
 */
public class IntergalacticNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public IntergalacticNumberException() {
	}

	public IntergalacticNumberException(String message) {
		super(message);
	}

	public IntergalacticNumberException(Throwable cause) {
		super(cause);
	}

	public IntergalacticNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public IntergalacticNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
