package model.exception;

public class NameCheckException extends Exception {
	private static final long serialVersionUID = -995577169096753799L;
	public NameCheckException() {
		super();
	}
	public NameCheckException(String message) {
		super(message);
	}
}
