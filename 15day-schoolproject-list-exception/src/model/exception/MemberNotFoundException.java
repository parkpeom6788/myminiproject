package model.exception;
public class MemberNotFoundException extends Exception {
	private static final long serialVersionUID = 5693013068808009552L;
	public MemberNotFoundException() {
		super();
	}
	public MemberNotFoundException(String message) {
		super(message);
	}
}
