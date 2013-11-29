package presentationlayer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import servicelayer.ServiceImple;
import servicelayer.ServiceInf;

public class DoLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		String role = req.getParameter("role");
		User us = new User();
		us.setUsername(user);
		us.setPassword(pass);
		ServiceInf sinf = new ServiceImple();
		String bls=sinf.storeUser(us);
		if(bls.equals("insert successfull"))
		{
			if(role.contentEquals("Admin"))
			{
				
				System.out.println("postlogin1");
				resp.sendRedirect("postlogin1.html");
				return;
			}
			else if(!(role.contentEquals("Admin")))
			{
				
				System.out.println("postlogin");
		         resp.sendRedirect("postlogin.html");
		         return;
			}
		}
		
		
	
		/*String status= doRedirection(bls,role);
		RequestDispatcher rd = req.getRequestDispatcher(status);
		rd.forward(req, resp);
	}
		public String doRedirection(String bls,String role)
		{
			String pagename=null;
			if(bls.equals("insert successfull"))
			{
				if((role.contentEquals("Admin")))
				{    System.out.println("postlogin page ");
				     pagename="postlogin.html";
				}
				else if(role.contentEquals("Admin"))
				{
					 System.out.println("postlogin page "); 
					pagename="postlogin.html";
				}
			}
			return pagename;
		}
		*/
	

	
	}	
}
