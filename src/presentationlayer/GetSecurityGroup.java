package presentationlayer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetSecurityGroup extends HttpServlet {

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
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe",
				"/c",
				"node  C:\\Users\\ashutoshs.RLLABINDIA\\Documents\\ec2\\node_modules\\ec2\\bin\\ec2 DescribeSecurityGroups");
		
		Process ps = builder.start();
		String str=null;
		StringBuilder sBuilder = new StringBuilder();
		BufferedReader br=null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			while((str=br.readLine()) != null)
			{
				System.out.println(str);
				sBuilder.append(str);
			}
			
			JSONParser par = new JSONParser();
			pw=resp.getWriter();
		  
				Object obj = par.parse(sBuilder.toString());
				JSONObject jobj = (JSONObject)  obj;
				JSONArray array = (JSONArray) jobj.get("securityGroupInfo");
				for(int i=0;i<array.size();i++){
				JSONObject jobj1 = (JSONObject) array.get(i);
				String GroupID = (String)jobj1.get("groupId");
				System.out.println("GroupID:" + GroupID);
				pw.write(GroupID+',');
				}     
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(br!=null)
			{
				br.close();
				pw.close();
			}
		}
		
		
		
		
			

	}

}
