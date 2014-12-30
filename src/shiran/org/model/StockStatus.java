package shiran.org.model;

import shiran.org.model.Portfolio.ALGO_RECOMMENDATION;

public class StockStatus extends Stock{
	
	private ALGO_RECOMMENDATION recommendation; 
	private int stockQuantity;
	
	/**
	 * c'tor for StockStatus
	 */
	public StockStatus(){
		super();
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
	
	/**
	 * getters & setters
	 * @return
	 */
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
