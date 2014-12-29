package shiran.org.model;

import java.util.Date;

public class Portfolio {

	public enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};
	private static final int MAX_PORTFOLIO_SIZE =5;
	private String title=" Shiran's Portfolio ! ";
	private Stock[] stocks; 
	private StockStatus[] stocksStatus;
	private int portfolioSize=0;
	private float balance=0;


	public Portfolio(){
		stocks=new Stock[MAX_PORTFOLIO_SIZE];
		stocksStatus=new StockStatus[MAX_PORTFOLIO_SIZE];
	}

	/**
	 * My copy constructor
	 * @param Portfolio
	 */
	public Portfolio(Portfolio portfolio){
		setTitle(portfolio.getTitle());
		portfolioSize=portfolio.portfolioSize;
		setBalance(portfolio.getBalance());

		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];

				for(int i = 0; i < portfolioSize; i++)
					{
						stocks[i] = new Stock(portfolio.stocks[i]);
						stocksStatus[i]=new StockStatus(portfolio.stocks[i]);
					}
		
	}


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

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * adding a new stock to the portfolio.
	 * @param stock
	 */


	public void addStock(Stock stock){

		boolean flag=true;
		for(int i=0;i<portfolioSize;i++){
			if(stock.getSymbol()==stocksStatus[i].getSymbol()){
				System.out.println("you already have "+stock.getSymbol()+" stock, please enter another stock symbol.");
				flag=false;
				break;
			}
		}
		if (portfolioSize >= (MAX_PORTFOLIO_SIZE)&&flag==true){
			System.out.println("can't add new stock,portfolio can only have "+ MAX_PORTFOLIO_SIZE+" stocks!");
		}


		else if(portfolioSize< MAX_PORTFOLIO_SIZE && flag==true){
			stocks[portfolioSize] = stock;
			stocksStatus[portfolioSize] = new StockStatus(stock.getSymbol(), stock.getAsk(), stock.getBid(), stock.getDate());
			//portfolioSize++;

						stocksStatus[portfolioSize].setAsk(stocks[portfolioSize].getAsk());
						stocksStatus[portfolioSize].setBid(stocks[portfolioSize].getBid());
						stocksStatus[portfolioSize].setSymbol(stocks[portfolioSize].getSymbol());
						stocksStatus[portfolioSize].setDate(stocks[portfolioSize].getDate());
						stocksStatus[portfolioSize].setRecommendation(ALGO_RECOMMENDATION.DO_NOTHING);
						stocksStatus[portfolioSize].setStockQuantity(0);
						portfolioSize++;
			System.out.println("Stock "+stocks[portfolioSize-1].getSymbol()+" added successfuly!");
		}
	}

	public boolean removeStock (String symbol) {
		boolean flag=true; 
		int temp;

		if (placeOfStock(symbol)== -2){
			System.out.println("the stock "+symbol+ " doesn't exsit in your portfolio. please enter a valid stock symbol. ");
			flag=false; 
		}
		else if (placeOfStock(symbol)!= -2)
		{
			temp=placeOfStock(symbol);
			sellStock(symbol, -1);

			if(placeOfStock(symbol)!= (portfolioSize-1))
			{
				stocks[placeOfStock(symbol)]=stocks[portfolioSize-1]; 
				stocks[portfolioSize-1]=null;

				stocksStatus[temp]=stocksStatus[portfolioSize-1];
				stocksStatus[portfolioSize-1]=null;
			}
			else if(placeOfStock(symbol)==(portfolioSize-1))
			{
				stocks[portfolioSize-1]=null; 
				stocksStatus[portfolioSize-1]=null;
			}
			portfolioSize--;
			System.out.println("Stock " + symbol +" removed successfuly!");
			flag=true; 
		}
		return flag;
	}

	/**
	 * this method sells  stocks.
	 * @return
	 */
	public boolean sellStock(String symbol, int quantity)
	{
		boolean flag=true;
		if(placeOfStock(symbol)==-2){
			System.out.println("there is no stock with that name, please enter a valid name. ");
			flag=false; 
		}
		else if(stocksStatus[placeOfStock(symbol)].getStockQuantity()>=quantity&&(quantity!=-1)&& flag==true){
			balance=balance+(quantity * stocksStatus[placeOfStock(symbol)].getBid());
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()-quantity);
			System.out.println("the stock "+symbol+" sold successfuly");
			flag=true;
		}
		else if(stocksStatus[placeOfStock(symbol)].getStockQuantity()<quantity && placeOfStock(symbol)!=-2 ){
			System.out.println("Not enough stocks to sell ");
			flag=false;
		}

		else if(quantity==(-1)&&flag==true){
			balance=balance+(stocksStatus[placeOfStock(symbol)].getStockQuantity() * stocksStatus[placeOfStock(symbol)].getBid());
			stocksStatus[placeOfStock(symbol)].setStockQuantity(0);
			System.out.println("the stock "+symbol+" sold successfuly(all)");
			flag=true;
		}
		else if(quantity<(-1)){
			System.out.println("this quantity is not legal, please enter a quantity bigger than 0");
			flag=false;
		}
		return flag;
	}

	/**
	 * this method buys stocks.
	 * @return
	 */
	public boolean buyStock(String symbol,int quantity){
		boolean flag=true;

		//		for(int i=0;i<portfolioSize;i++){
		//			if(symbol==stocksStatus[i].getSymbol()/* && stocksStatus[i]!=null */){
		//				System.out.println("you already have "+symbol+" stock, please enter another stock symbol.");
		//				flag=false;
		//				break;
		//			}
		//		}
		// there is a problem with that loop because when i added a stock i also added her to the stocksStatus array. 
		// so that flag always will change to be false, and then i can't to buy this stock because it already added in addStock method.
		if(placeOfStock(symbol)==-2){
			System.out.println("there is no stock with that name, please enter valid name. ");
			flag=false;
		}
		if(quantity<-1){
			System.out.println("this quantity is not legal, please enter a quantity bigger than 0");
			flag=false;
		}

		else if(balance<stocks[placeOfStock(symbol)].getAsk()*quantity){
			System.out.println("Not enough balance to complete purchase");
			flag=false;
		}
		else if (balance>=stocks[placeOfStock(symbol)].getAsk()*quantity && flag==true){

			balance=balance-stocks[placeOfStock(symbol)].getAsk()*quantity;
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()+quantity);
			System.out.println("you bought the stock "+symbol+" !");
			return true;
		}
		else if(quantity==-1)
		{
			quantity=(int) (balance/stocksStatus[placeOfStock(symbol)].getAsk());
			balance=stocksStatus[placeOfStock(symbol)].getAsk()-quantity;
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()+quantity);
			System.out.println("you bought the stock"+symbol+" !");
			flag=true;
		}

		return flag;
	}

	/**
	 * this method returns total value of all stocks.
	 * @return
	 */
	public float getStocksValue(){
		float valueOfAllStocks=0;
		for (int i=0; i<portfolioSize;i++){
			if(stocksStatus[i]!=null){
				valueOfAllStocks=(stocksStatus[i].getBid()*stocksStatus[i].getStockQuantity())+valueOfAllStocks;
			}
		}
		return valueOfAllStocks;
	}

	/**
	 *  this method returns value of balance.
	 * @return
	 */
	public float getCurrentBalance(){
		return balance;
	}

	/**
	 * this method returns the sum of all stocks's value and portfolio balance.
	 * @return
	 */
	public float getTotalValue(){
		float totalValue;
		totalValue=getStocksValue()+getCurrentBalance();
		return totalValue;
	}


	/**
	 * this method checks if there is a stock in our portfolio and where.
	 * @param symbol
	 * @return
	 */
	public int placeOfStock(String symbol){
		int index=-2;
		for(int i=0;i<portfolioSize;i++){
			if(stocks[i].getSymbol()==symbol){
				index=i;
				break;
			}
		}
		return index;
	}

	public  Stock[] getStocks(){
		return stocks;
	}

	/**
	 * the method returns in html: 
	 * in bold: the title of the stock
	 * in bold: stock symbol
	 * not in bold - the value of the Stock
	 * with spaces
	 * Shiran vazana. December 2014
	 * @return
	 */
	public String getHtmlString(){
		String retVal = new String();
		retVal += "<h1>"+title+"</h1>";
		for (int i = 0; i < portfolioSize; i++) {
			retVal += stocks[i].getHtmlDescription();
		}
		retVal+="<b>Total Portfolio Value: </b>"+getTotalValue()+"$, "+"<b>Total Stocks Value: </b>"+ getStocksValue()+"$, "+"<b>Balance: </b>"+getCurrentBalance()+"$. "; 
		return retVal;
	}

	/**
	 * this method updates the balance.
	 * @param amount
	 * @return
	 */
	public float updateBalance(float amount){
		if(amount>0){
			balance= balance+amount;
		}
		else if (balance+amount<0){
			balance=0;
		}
		else if(amount==0){
			System.out.println("the value of the balance has not changed!");
		}

		return balance; 
	}

//	/**
//	 * inner class
//	 * @author vazana shiran
//	 *
// */
//	public class StockStatus{
//
//		private String symbol;
//		private float currentBid;
//		private float currentAsk;
//		private Date date; 
//		private ALGO_RECOMMENDATION recommendation; 
//		private int stockQuantity;
//
//		public String getSymbol() {
//			return symbol;
//		}
//		public void setSymbol(String symbol) {
//			this.symbol = symbol;
//		}
//		public float getCurrentBid() {
//			return currentBid;
//		}
//		public void setCurrentBid(float currentBid) {
//			this.currentBid = currentBid;
//		}
//		public float getCurrentAsk() {
//			return currentAsk;
//		}
//		public void setCurrentAsk(float currentAsk) {
//			this.currentAsk = currentAsk;
//		}
//		public Date getDate() {
//			return date;
//		}
//		public void setDate(Date date) {
//			this.date = date;
//		}
//		public ALGO_RECOMMENDATION getRecommendation() {
//			return recommendation;
//		}
//		public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
//			this.recommendation = recommendation;
//		}
//		public int getStockQuantity() {
//			return stockQuantity;
//		}
//		public void setStockQuantity(int stockQuantity) {
//			this.stockQuantity = stockQuantity;
//		}
//
//
//		/**
//		 * copy c'tor for stockStatus
//		 * @param stockStatus
//		 */
//		public StockStatus(StockStatus stockStatus){
//			setSymbol(stockStatus.getSymbol());
//			setCurrentBid(stockStatus.getCurrentBid());
//			setCurrentAsk(stockStatus.getCurrentAsk());
//			date=new Date(stockStatus.date.getTime());
//			setRecommendation(stockStatus.getRecommendation());
//			setStockQuantity(stockStatus.getStockQuantity());
//
//		}
//		public StockStatus(Stock stock) {
//			// TODO Auto-generated constructor stub
//		}
//		public StockStatus(String symbol2, float ask, float bid, Date date2) {
//			// TODO Auto-generated constructor stub
//		}
//
//	}

}




