package shiran.org.servlet;

import java.io.IOException;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shiran.org.Stock;
import shiran.org.model.Portfolio;
import shiran.org.service.PortfolioService;

@SuppressWarnings("serial")
	public class PortfolioServlet extends HttpServlet {
		
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			resp.setContentType("text/html");
			
			PortfolioService portfolioService = new PortfolioService();
			Portfolio portfolio = portfolioService.getPortfolio();
			Stock[] stocks = portfolio.getStocks();
			
			   		
		    resp.getWriter().println(portfolio.getHtmlString());
				
		}
}
