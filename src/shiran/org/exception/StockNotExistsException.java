package shiran.org.exception;
/**
 *  exception to be thrown when a stock doesn’t exist.

 * @author vazana
 *
 */
public class StockNotExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StockNotExistsException(String symbol) {
		super("Stock " + symbol + " not exists!");
	}

}
