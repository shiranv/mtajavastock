package shiran.org.model;

import java.sql.Date;

import shiran.org.model.Portfolio.ALGO_RECOMMENDATION;

public class StockStatus extends Stock{
	
	private ALGO_RECOMMENDATION recommendation; 
	private int stockQuantity;
	/**
	 * c'tor for StockStatus
	 * @param ask
	 * @param bid
	 * @param symbol
	 * @param date
	 * @param recommendation
	 * @param stockQuantity
	 */
	public StockStatus(float ask,float bid,String symbol, Date date,ALGO_RECOMMENDATION recommendation, int stockQuantity){
		super(ask, bid, symbol,date);
		this.recommendation=recommendation;
		this.stockQuantity=stockQuantity;
	}
	
	/**
	 * copy c'tor for stockStatus class.
	 * @param stockStatus
	 */
		public StockStatus(StockStatus stockStatus){
			super(stockStatus);
			this.stockQuantity=stockStatus.getStockQuantity();
			this.recommendation=stockStatus.getRecommendation();
		}
	
	
	
	public StockStatus(String symbol, float ask, float bid, java.util.Date date) {
		// TODO Auto-generated constructor stub
	}

	public StockStatus(Stock stock) {
		// TODO Auto-generated constructor stub
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


}
