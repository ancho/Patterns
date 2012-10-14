package core;

public class IllegalOperationException extends RuntimeException {

	private static final long serialVersionUID = -5651823945876054925L;
	
	final static String DEFAULTMESSAGE = "Operation nicht erlaubt.";
	
	public IllegalOperationException(String message) {
		
		super(DEFAULTMESSAGE + " " + message);
	}

}
