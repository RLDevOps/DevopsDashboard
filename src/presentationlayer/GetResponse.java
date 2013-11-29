package presentationlayer;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicelayer.ServiceImple;
import servicelayer.ServiceInf;

public class GetResponse extends HttpServlet{

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
		ServiceInf sinf = new ServiceImple();
		List lstkeyName=sinf.getKeyName();
		PrintWriter out = resp.getWriter();
		out.write(lstkeyName.toString().trim().substring(1, lstkeyName.toString().length()-1));
	}

}
