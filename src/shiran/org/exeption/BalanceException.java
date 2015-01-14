package shiran.org.exeption;
/**
 * This exception to be thrown when the portfolio balance becomes
negative.
 * @author vazana
 *
 */
public class BalanceException extends Exception{

	private static final long serialVersionUID = 1L;

	public BalanceException() {
		super("balance can't be negative / you don't have enough money to buy this stock ");
	}
}
