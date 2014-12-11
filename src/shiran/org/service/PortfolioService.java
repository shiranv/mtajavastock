package shiran.org.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import shiran.org.model.Portfolio;
import shiran.org.model.Stock;
/**
 * this class manage our Stock Portfolio and update his value. 
 * @author vazana Shiran, December 2014
 *
 */
public class PortfolioService {

	public Portfolio getPortfolio(){
		Portfolio myPortfolio = new Portfolio();
	
		
		
		//1
		Stock Stock1=new Stock();
		Stock1.setSymbol("PIH");
		Stock1.setAsk(12.4f);
		Stock1.setBid(13.1f);
		
		Calendar c =Calendar.getInstance();
		c.set(2014, 10, 15, 0, 0,0);
		Date date=c.getTime();
	    Stock1.setDate(date);
		myPortfolio.addStock(Stock1);
		
		//2
		Stock Stock2=new Stock();
		Stock2.setSymbol("AAL");
		Stock2.setAsk(5.5f);
		Stock2.setBid(5.78f);
		
		
		Calendar d =Calendar.getInstance();
		d.set(2014, 10, 15, 0, 0,0);
		Date date2=d.getTime();
		Stock2.setDate(date2);
		myPortfolio.addStock(Stock2);
		//3
		Stock Stock3=new Stock();
		Stock3.setSymbol("CAAS");
		Stock3.setAsk(31.5f);
		Stock3.setBid(31.2f);
		
		Calendar e =Calendar.getInstance();
		e.set(2014, 10, 15, 0, 0,0);;
		Date date3=c.getTime();
		Stock3.setDate(date3);
		myPortfolio.addStock(Stock3);
		
		return myPortfolio;
	}

}
