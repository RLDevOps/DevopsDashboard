package presentationlayer;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import servicelayer.CallApi;
import servicelayer.ServiceImple;
import servicelayer.ServiceInf;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Aws;
import dto.Instancetype;

@SuppressWarnings("serial")
public class DoApiCall extends HttpServlet {

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
		String aki = req.getParameter("aki");
		String sak =req.getParameter("sak");
		String ep = req.getParameter("ep");
		//System.out.println("aki is "+aki);
		//System.out.println("servelet called");
		Aws mykey = new Aws(); 
		mykey.setKey(aki);
		mykey.setSecret(sak);
		mykey.setEndpoint(ep);
		//writeAws(mykey);
		CallApi api = new CallApi();
		
		ServiceInf sinf = new ServiceImple();
		List<String> lst = (ArrayList<String>)sinf.getInstances();
		resp.setStatus(200);
		PrintWriter out = resp.getWriter();
		System.out.println("KList : " +lst.toString() + "--- " + lst.size());
		out.write(lst.toString().trim().substring(1, lst.toString().length()-1));
		List lstImageId = sinf.getImageId();
		String jObj=JSONValue.toJSONString(lstImageId);
		System.out.println(jObj);
		//out.write();
		out.close();
	}
	
	private void writeAws(Aws mykey)
	{
		Gson gson = new Gson();
		String str = gson.toJson(mykey);
		FileWriter fw=null;
		File fl  = new File("C:\\Users\\ashutoshs.RLLABINDIA\\Documents\\ec2\\node_modules\\ec2\\bin\\undefined\\2.aws");
		try {
			 fw = new FileWriter(fl);
			fw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
