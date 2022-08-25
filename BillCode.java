

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BillCode
 */
@WebServlet("/BillCode")
public class BillCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		long Consumerno=Long.parseLong(request.getParameter("cno"));
		String ConsumerName=request.getParameter("cname");
		Float CurrentRead=Float.parseFloat(request.getParameter("cread"));
		Float priviousRead=Float.parseFloat(request.getParameter("pread"));
		
		float unit=CurrentRead-priviousRead;
		float TotalBill=0;
		
		
		if(unit<200) {
			TotalBill=unit+1.75f;
		}
		else if(unit>=200 && unit<400) {
			TotalBill=(199*1.75f)+(unit-199)*3.75f;
		}
		else if(unit>400) {
			TotalBill=(199*1.75f)+(200*3.75f)+(unit-399)*5.75f;
		}
		out.print("Consumer number :"+ Consumerno+"<br>");
		out.print("Consumer name :"+ ConsumerName+"<br>");
		out.print("Current number :"+ Consumerno+"<br>");
		
		out.print("TotalBill :"+ TotalBill+"<br>");
		
		
		
		
	}

}
