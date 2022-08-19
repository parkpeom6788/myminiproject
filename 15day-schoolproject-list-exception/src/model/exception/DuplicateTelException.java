package model.exception;

public class DuplicateTelException  extends Exception {
	private static final long serialVersionUID = 7593654778364501359L;
	public DuplicateTelException() {
		super();
	}
	public DuplicateTelException(String message) {
		super(message);
	}
}
