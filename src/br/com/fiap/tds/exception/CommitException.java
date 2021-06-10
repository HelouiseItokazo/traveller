package br.com.fiap.tds.exception;

public class CommitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4224634033963231506L;
	
	
	public CommitException() {
		super("Erro ao realizar o commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}
}
