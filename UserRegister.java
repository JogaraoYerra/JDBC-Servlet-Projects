

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("n1");
		String password=request.getParameter("n2");
		String email=request.getParameter("n3");
		String ugender=request.getParameter("gender");
		long mobileno=Long.parseLong(request.getParameter("n4"));
		String address=request.getParameter("n5");
		String statee=request.getParameter("state");
		
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mdb","mdb");
			PreparedStatement ps=con.prepareStatement("insert into UserRegister values (?,?,?,?,?,?,?)");
			
			
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,ugender);
			ps.setLong(5,mobileno);
			ps.setString(6,address);
			ps.setString(7,statee);
			
			
			int i=ps.executeUpdate();
			out.print(i+"Record inserted");
			con.close();
			}
		catch(Exception ex)
		{
			out.print(ex);
		}
			

		}
}

