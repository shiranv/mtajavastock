package shiran.org.model;

import java.util.Date;

import shiran.org.Stock;

public class Portfolio {

	private static final int MAX_PORTFOLIO_SIZE =5;

	private String title="exe 5 - show portfolio: ";

	private Stock[] stocks; 
	private StockStatus[] stocksStatus;
	int portfolioSize=0;

	public Portfolio(){
		stocks=new Stock[MAX_PORTFOLIO_SIZE];
		stocksStatus=new StockStatus[MAX_PORTFOLIO_SIZE];
	}	

	public void addStock(Stock stock){
		stocks[portfolioSize]=stock; 
		portfolioSize++;
	}

	public  Stock[] getStocks(){
		return stocks;
	}

	public String getHtmlString(){
		String retVal = new String();
		retVal += "<h1>"+title+"</h1>";
		for (int i = 0; i < portfolioSize; i++) {
			retVal += stocks[i].getHtmlDescription();
		}
		return retVal;
	}

	public class StockStatus{
		private static final int DO_NOTHING=0;
		private static final int BUY=1;
		private static final int SELL=2;
		
		private String symbol;
		private float currentBid;
		private float currentAsk;
		private Date date; 
		private int recommendation; 
		private int stockQuantity;
	}
}
