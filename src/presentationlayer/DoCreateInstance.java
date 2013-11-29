package presentationlayer;

import java.io.BufferedReader;
import java.io.File;
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

import com.ctc.wstx.io.BufferRecycler;

public class DoCreateInstance extends HttpServlet {

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
		String insType=req.getParameter("insTypeList");
		String amid = req.getParameter("ami");
		String keyPair = req.getParameter("keypair");
		String endPoint = req.getParameter("endPoint");
		String maxIns = req.getParameter("maIns");
		String minIns = req.getParameter("miIns");
		String keyname = req.getParameter("keyName");
		
		String securityGroup = req.getParameter("securityGroup");
		String command = "node  C:\\Users\\ashutoshs.RLLABINDIA\\Documents\\ec2\\node_modules\\ec2\\bin\\ec2 RunInstances "+ "InstanceType " + insType  +" "+ "ImageId" + amid + "KeyName" + keyPair + "Placement.AvailabilityZone " + endPoint  +" "+ "MaxCount " + maxIns + " "+"MinCount " + minIns+" "+"SecurityGroupId.1"+ securityGroup;
		System.out.println(command);
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe",
				"/c",
				command
				);
		
		
		//builder.redirectOutput(new File("C:\\Users\\ashutoshs.RLLABINDIA\\Downloads\\json_jar\\create.json"));
		Process ps = builder.start();
		String str=null;
		StringBuilder sBuilder=new StringBuilder();
		BufferedReader br=null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			while((str=br.readLine())!=null)
			{
				//System.out.println(str);
				sBuilder.append(str);
			}
			pw=resp.getWriter();
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(sBuilder.toString());
			JSONObject jObject = (JSONObject) obj;
			JSONArray jsonArray = (JSONArray) jObject.get("instancesSet");
			for(int i = 0;i<jsonArray.size();i++)
			{
				JSONObject jObj = (JSONObject) jsonArray.get(i);
				String instanceId = (String) jObj.get("instanceId");
				String imageId = (String) jObj.get("imageId");
				String keyName = (String) jObj.get("keyName");
				
				String instanceType = (String) jObj.get("instanceType");
				JSONObject jobj1 = (JSONObject) jObj.get("instanceState");
				String name = (String) jobj1.get("name");
				System.out.println("id  -->"+ instanceId);
				System.out.println("imageId  -->"+ imageId);
				System.out.println("keyName  -->"+ keyName);
				System.out.println("name  -->"+ name);
				System.out.println("instanceType  -->"+ instanceType);
				List<String> lst = new ArrayList<String>();
				lst.add(instanceId);
				lst.add(imageId);
				lst.add(keyName);
				lst.add(instanceType);
				lst.add(name);
				pw.write(lst.toString().trim().substring(1, lst.toString().length()-1));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null)
			{
				br.close();
				pw.close();
			}
			
		}
		
		
		
	
	}

}
