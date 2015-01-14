package shiran.org.exeption;
/**
 *  exception to be thrown when a stock doesn’t exist.

 * @author vazana
 *
 */
public class StockNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StockNotExistException(String symbol) {
		super("Stock " + symbol + " not exists!");
	}

}
