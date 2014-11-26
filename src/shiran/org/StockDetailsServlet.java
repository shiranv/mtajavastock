package shiran.org;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.types.SimpleDate;
//import com.sun.net.httpserver.HttpServer;

public class StockDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html");
			//1
			Stock Stock1=new Stock();
			Stock1.setSymbol("PIH");
			Stock1.setAsk(12.4f);
			Stock1.setBid(13.1f);
			
			Calendar c =Calendar.getInstance();
			c.set(2014, 10, 15);
			Date date=c.getTime();
			Stock1.setDate(date);
		
			resp.getWriter().println(Stock1.getHtmlDescription());
			//2
			Stock Stock2=new Stock();
			Stock2.setSymbol("AAL");
			Stock2.setAsk(5.5f);
			Stock2.setBid(5.78f);
			
			Calendar d =Calendar.getInstance();
			d.set(2014, 10,15);
			Date date2=d.getTime();
			Stock2.setDate(date2);
			
			
			resp.getWriter().println(Stock2.getHtmlDescription());
			
			//3
			Stock Stock3=new Stock();
			Stock3.setSymbol("CAAS");
			Stock3.setAsk(31.5f);
			Stock3.setBid(31.2f);
			
			Calendar e =Calendar.getInstance();
			e.set(2014, 10,15);
			Date date3=c.getTime();
			Stock3.setDate(date3);
			
		
			resp.getWriter().println(Stock3.getHtmlDescription());
			
			
			
			}
	
}
