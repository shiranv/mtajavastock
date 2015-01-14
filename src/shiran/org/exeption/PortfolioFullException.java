package shiran.org.exeption;
/**
 * This exception to be thrown when adding more stocks than
allowed
 * @author vazana
 *
 */
public class PortfolioFullException extends Exception {
	
	//private static final long serialVersionUID = 1L;

	public PortfolioFullException() {
		super("You had reached maximum portfolio size!");
	}
}
