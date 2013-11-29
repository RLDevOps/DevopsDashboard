package presentationlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class GetAmId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe",
				"/c",
				"node  C:\\Users\\ashutoshs.RLLABINDIA\\Documents\\ec2\\node_modules\\ec2\\bin\\ec2 DescribeKeyPairs");
		
		Process ps = builder.start();
		BufferedReader br = null;
		String str = null;
		StringBuilder sBuilder = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			while ((str = br.readLine()) != null) {
				sBuilder.append(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		JSONParser parser = new JSONParser();
		PrintWriter out = null;
		
		try {
			Object obj = parser.parse(sBuilder.toString());
			JSONObject json = (JSONObject) obj;
			String requestId=(String) json.get("requestId");
			JSONArray array = (JSONArray) json.get("keySet");
			List<String> ls = null;
			 out = resp.getWriter();
			for(int i=0;i<array.size();i++){
				JSONObject obj1 = (JSONObject) array.get(i);
				String keyName = (String) obj1.get("keyName");
				 //ls = new ArrayList<String>();
				//ls.add(keyName);
				System.out.println("KeyName --->>>" + keyName );
				
				try {
					
					out.write(keyName+',');
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			out.close();
			
		}
		

	}
		
}
