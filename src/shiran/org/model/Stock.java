package shiran.org.model;

import java.sql.Date;
/**
 * here we define the members of every Stock
 * @author Vazana Shiran, December 2014.
 *
 */
public class Stock {
	private String symbol;
	private float ask; 
	private float bid; 
	private java.util.Date date;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}  
	/**
	 * the method returns in html: 
	 * in bold: stock name
	 * not in bold - the value of the Stock
	 * with spaces
	 * Shiran vazana. December 2014
	 * @return
	 */
	public String getHtmlDescription(){
		String res= "<b>Stock Symbol</b>: " +getSymbol()+" <b>Ask</b>: " + getAsk() + " <b>Bid: </b>"+ getBid()+ " <b>Date:</b> "+ getDate() + "<br>";
		return res;
				
	}
	/**
	 * copy c'tor of Stock
	 * @param stock
	 */
	public Stock(Stock stock){
		setSymbol(stock.getSymbol());
		setAsk(stock.getAsk());
		setBid(stock.getBid());
		date=new Date (stock.date.getTime());
		
	}
	public Stock() {
		// TODO Auto-generated constructor stub
	}
}
