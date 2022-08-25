

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BigNumber
 */
@WebServlet("/BigNumber")
public class BigNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigNumber() {
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
		
		int num1=Integer.parseInt(request.getParameter("fnum"));
		int num2=Integer.parseInt(request.getParameter("snum"));
		int num3=Integer.parseInt(request.getParameter("tnum"));
		
		if(num1>num2&&num1<num3) {
			out.print("Biggest of two Number is"+num1);
			
		}
		else if(num2>num3) {
			out.print("Biggest of two number is"+num2);
		}
		else {
			out.print("Biggest of two number is "+num3);
		}
		
		
		
	}

}
