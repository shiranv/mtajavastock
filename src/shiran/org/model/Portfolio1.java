package shiran.org.model;

import java.util.Date;

public class Portfolio1 {

	private static final int MAX_PORTFOLIO_SIZE =5;

	private String title=" show portfolio: ";

	private Stock[] stocks; 
	private StockStatus[] stocksStatus;
	private int portfolioSize=0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	//copy c'tor1
	public Portfolio1(Portfolio1 portfolio){
		setTitle(portfolio.getTitle());
		setPortfolioSize(portfolio.getPortfolioSize());

		Stock stocksS[] = new Stock[stocks.length];  
		for (int i = 0; i < stocksS.length; i++)  
			stocksS[i] = stocks[i];  

	}

	public Portfolio1(){
		stocks=new Stock[MAX_PORTFOLIO_SIZE];
		stocksStatus=new StockStatus[MAX_PORTFOLIO_SIZE];
	}	


	public void addStock(Stock stock){
		stocks[portfolioSize]= stock/*new Stock(stock)*/; 
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

		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public float getCurrentBid() {
			return currentBid;
		}
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		public float getCurrentAsk() {
			return currentAsk;
		}
		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}


		public StockStatus(StockStatus stockStatus){
			setSymbol(stockStatus.getSymbol());
			setCurrentBid(stockStatus.getCurrentBid());
			setCurrentAsk(stockStatus.getCurrentAsk());
			date=new Date(stockStatus.date.getTime());
			setRecommendation(stockStatus.getRecommendation());
			setStockQuantity(stockStatus.getStockQuantity());

		}
	}

	
}




