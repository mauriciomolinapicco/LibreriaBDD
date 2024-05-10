package LibreriaBDD;

public class BDDException extends Exception {
	public BDDException() {
	}
	
	public BDDException(String message) {
		super(message);
	}
	
	public BDDException(Throwable cause) {
		super(cause);
	}
	
	public BDDException(String message, Throwable cause) {
		super(message, cause);
	}
}
