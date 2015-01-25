package shiran.org.exception;
/**
 * This exception to be thrown when the portfolio balance becomes
negative.
 * @author vazana
 *
 */
public class BalanceException extends Exception{

	private static final long serialVersionUID = 1L;

	public BalanceException() {
		super("Out of balance!");
	}
	
	public BalanceException(String message) {
		super(message);
	}

}
