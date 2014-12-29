package shiran.org.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shiran.org.model.Portfolio;
import shiran.org.model.Stock;
import shiran.org.service.PortfolioService;

@SuppressWarnings("serial")

	public class PortfolioServlet extends HttpServlet {
		
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			resp.setContentType("text/html");
			
			PortfolioService portfolioService = new PortfolioService();
			Portfolio portfolio1 = portfolioService.getPortfolio();
			//ÈPortfolio portfolio2=new Portfolio(portfolio1);

			
			/**
			 * print portfolio1 details
			 *Shiran Vazana , December 2014.
			 */
		    resp.getWriter().println(portfolio1.getHtmlString());
	
		    
		}
}
