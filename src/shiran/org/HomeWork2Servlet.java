package shiran.org;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HomeWork2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		int num1,num2,num3;
		num1=4;
		num2=3;
		num3=7;
		int result=(num1+num2)*num3;
		String resultStr = new String("<h1>Result of: (" +num1+"+"+num2+ ")*"+num3+"="+result+"<h1>");

		resp.getWriter().println(resultStr);

		//1
		int radius=50;
		double pi=Math.PI;
		double area=radius*radius*pi;
		String line1 = new String( "calculation 1: Area of circle with radius "+radius+" is: "+area+" square cm.");

		//2
		int angleB=30;
		int hypotenuseLength=50;
		double radians=Math.toRadians(angleB);
		double opp=radians*hypotenuseLength;
		String line2 = new String( "calculation 2: Length of opposite where angle B: "+ opp);
		//3
		int base=20;
		int exp=13;
		long result2=1;

		for(int i=0;i<exp;i++)
		{
			result2 = result2*base;
		}
		String line3 = new String( "calculation 3: Power of 20 with exp of 13 is : "+ result2);


		String resultStr3 = line1 + "<br>" + line2 + "<br>" +line3;
		resp.getWriter().println(resultStr3);
	}
}
