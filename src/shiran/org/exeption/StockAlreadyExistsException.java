package shiran.org.exeption;
/**
 * exception to be thrown when a stock already exists
 * @author vazana
 *
 */
public class StockAlreadyExistsException extends Exception{
	
	//private static final long serialVersionUID = 1L;

	public StockAlreadyExistsException(String symbol) {
		super("Sorry, stock " + symbol + " already exists!");
	}
}
