package shiran.org.model;

import java.util.Date;


import java.util.List;

import shiran.org.exception.BalanceException;
import shiran.org.exception.PortfolioFullException;
import shiran.org.exception.StockAlreadyExistsException;
import shiran.org.exception.StockNotExistsException;

public class Portfolio {

	public enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};
	private static final int MAX_PORTFOLIO_SIZE =5;
	private String title=" Shiran's Portfolio ! ";
	private StockStatus[] stocksStatus;
	private int portfolioSize=0;
	private float balance=0;

	public Portfolio(List<StockStatus> st){
	
	}
	
	public Portfolio(){
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
		stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];

				for(int i = 0; i < portfolioSize; i++)
					{
						stocksStatus[i]=new StockStatus(portfolio.stocksStatus[i]);
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


	public void addStock(Stock stock)throws StockAlreadyExistsException, PortfolioFullException {

		boolean flag=true;
		for(int i=0;i<portfolioSize;i++){
			if(stock.getSymbol().equals(stocksStatus[i].getSymbol())){
				System.out.println("you already have "+stock.getSymbol()+" stock, please enter another stock symbol.");
				throw new StockAlreadyExistsException(stock.getSymbol());
			}
		}
		if (portfolioSize >= (MAX_PORTFOLIO_SIZE)&&flag==true){
			
			System.out.println("can't add new stock,portfolio can only have "+ MAX_PORTFOLIO_SIZE+" stocks!");
			throw new PortfolioFullException();
		}


		else if(portfolioSize< MAX_PORTFOLIO_SIZE && flag==true){
			stocksStatus[portfolioSize] = new StockStatus();
			stocksStatus[portfolioSize].setAsk(stock.getAsk());
			stocksStatus[portfolioSize].setBid(stock.getBid());
			stocksStatus[portfolioSize].setSymbol(stock.getSymbol());
			stocksStatus[portfolioSize].setDate(stock.getDate());
			stocksStatus[portfolioSize].setRecommendation(ALGO_RECOMMENDATION.DO_NOTHING);
			stocksStatus[portfolioSize].setStockQuantity(0);
			portfolioSize++;
			System.out.println("Stock "+stocksStatus[portfolioSize-1].getSymbol()+" added successfuly!");
		}
	}

	public void removeStock (String symbol)throws StockNotExistsException {
		boolean flag=true; 

		if (placeOfStock(symbol)== -2){
			System.out.println("the stock "+symbol+ " doesn't exsit in your portfolio. please enter a valid stock symbol. ");
			flag=false; 
			throw new StockNotExistsException(symbol);
		}
		else if (placeOfStock(symbol)!= -2)
		{
			sellStock(symbol, -1);

			if(placeOfStock(symbol)!= (portfolioSize-1))
			{

				stocksStatus[placeOfStock(symbol)]=stocksStatus[portfolioSize-1];
				stocksStatus[portfolioSize-1]=null;
			}
			else if(placeOfStock(symbol)==(portfolioSize-1))
			{
				stocksStatus[portfolioSize-1]=null;
			}
			portfolioSize--;
			System.out.println("Stock " + symbol +" removed successfuly!");
			flag=true; 
		}
		//return flag;
	}

	/**
	 * this method sells  stocks.
	 * @return
	 */
	public void sellStock(String symbol, int quantity)throws StockNotExistsException
	{
		boolean flag=true;
		if(placeOfStock(symbol)==-2){
			System.out.println("there is no stock with that name, please enter a valid name. ");
			flag=false;
			throw new StockNotExistsException(symbol);
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
		//return flag;
	}

	/**
	 * this method buys stocks.
	 * @return
	 */
	public void buyStock(String symbol,int quantity)throws BalanceException,StockNotExistsException{
		boolean flag=true;

//				for(int i=0;i<portfolioSize;i++){
//					if(symbol==stocksStatus[i].getSymbol()/* && stocksStatus[i]!=null */){
//						System.out.println("you already have "+symbol+" stock, please enter another stock symbol.");
//						flag=false;
//						break;
//					}
//				}
		// there is a problem with that loop because when i added a stock i also added her to the stocksStatus array. 
		// so that flag always will change to be false, and then i can't to buy this stock because it already added in addStock method.
		if(placeOfStock(symbol)==-2){
			System.out.println("there is no stock with that name, please enter valid name. ");
			flag=false;
			throw new StockNotExistsException(symbol);
		}
		if(quantity<-1){
			System.out.println("this quantity is not legal, please enter a quantity bigger than 0");
			flag=false;
		}

		else if(balance<stocksStatus[placeOfStock(symbol)].getAsk()*quantity){
			System.out.println("Not enough balance to complete purchase");
			flag=false;
			throw new BalanceException();
		}
		else if (balance>=stocksStatus[placeOfStock(symbol)].getAsk()*quantity && flag==true){

			balance=balance-stocksStatus[placeOfStock(symbol)].getAsk()*quantity;
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()+quantity);
			System.out.println("you bought the stock "+symbol+" !");
			//return true;
		}
		else if(quantity==-1)
		{
			quantity=(int) (balance/stocksStatus[placeOfStock(symbol)].getAsk());
			balance=stocksStatus[placeOfStock(symbol)].getAsk()-quantity;
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()+quantity);
			System.out.println("you bought the stock"+symbol+" !");
			flag=true;
		}

		//return flag;
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
			if(stocksStatus[i]!=null){
				if (stocksStatus[i].getSymbol().equals(symbol)){ 
				index=i;
				break;
				}
			}
		}
		return index;
	}


	public  StockStatus[] getStocks(){
		return stocksStatus;
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
			retVal += stocksStatus[i].getHtmlDescription();
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

}
