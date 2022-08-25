

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
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
		
		String name=request.getParameter("sname");
	    int subj1=Integer.parseInt(request.getParameter("sub1"));
	    int subj2=Integer.parseInt(request.getParameter("sub2"));
	    int subj3=Integer.parseInt(request.getParameter("sub3"));
	    int Total=subj1+subj2+subj3;
	    float average=Total/3;
	    
	    
	    if(average>=70) {
	    	out.print("A grade");
	    }
	    else if(average>=60) {
	    	out.print("b grade");
	    }
	    else if (average>=50){
	    	out.print("c grade");
	    }
	    else {
	    	out.print("fail");
	    }
	}

}
