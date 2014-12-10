package shiran.org.servlet;

import java.io.IOException;



//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shiran.org.model.Portfolio1;

import shiran.org.model.Stock;

import shiran.org.service.PortfolioService;

@SuppressWarnings("serial")
	public class PortfolioServlet extends HttpServlet {
		
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			resp.setContentType("text/html");
			
			PortfolioService portfolioService = new PortfolioService();
			Portfolio1 portfolio = portfolioService.getPortfolio();
			Stock[] stocks = portfolio.getStocks();
			//Portfolio1 portfolio2=new Portfolio1(portfolio);
			
		    resp.getWriter().println(portfolio.getHtmlString());
		    //resp.getWriter().println(portfolio2.getHtmlString());
		    

		}
}
