

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpInvoice
 */
@WebServlet("/EmpInvoice")
public class EmpInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int empnum=Integer.parseInt(request.getParameter("enum"));
		String empname=request.getParameter("ename");
		double empsal=Double.parseDouble("esal");
		
		double ta;
		double da;
		double pf;
		double grosssalary=0;
		double netsalary=0;
		
		if(empsal>30000 ) {
			ta=empsal*9/100;
			da=empsal*11/100;
			pf=empsal*17/100;
		}
		else if(empsal>=30000 && empsal<60000) {
			ta=empsal*11/100;
			da=empsal*17/100;
			pf=empsal*19.25/100;
		}
		else {
			ta=empsal*13/100;
			da=empsal*19/100;
			pf=empsal*23.25/100;
		}
		grosssalary=empsal+ta+da+pf;
		netsalary=grosssalary-pf;

	try{
		
		Class.forName("jdbc.oracle.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mdb","mdb");
		PreparedStatement ps=con.prepareStatement("insert into empInvoice values (?,?,?,?,?,?,?,?)");
		
		ps.setInt(1,empnum);
		ps.setString(2,empname);
		ps.setDouble(3,empsal);
		ps.setDouble(4,ta);
		ps.setDouble(5,da);
		ps.setDouble(6,pf);
		ps.setDouble(7,grosssalary);
		ps.setDouble(8,netsalary);
		
		int i=ps.executeUpdate();
		out.print(i+"Record inserted");
		con.close();
		}
	catch(Exception ex){
		out.print(ex);
	}
		
	}
}
