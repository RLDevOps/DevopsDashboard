package servicelayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


import dto.Instancetype;


public class CallApi extends Thread implements CallApiInf {

	public CallApi() {

		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		doapicall();

	}

	public void doapicall() {
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe",
				"/c",
				"node  C:\\Users\\ashutoshs.RLLABINDIA\\Documents\\ec2\\node_modules\\ec2\\bin\\ec2 DescribeInstances");
		builder.redirectOutput(new File(
				"C:\\Users\\ashutoshs.RLLABINDIA\\Downloads\\json_jar\\region.json"));
		try {
			Process pr = builder.start();

		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		storeapi();
	}

	@Override
	public void storeapi() {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		Object obj = null;
		
		
		try {
			obj = parser
					.parse(new FileReader(
							"C:\\Users\\ashutoshs.RLLABINDIA\\Downloads\\json_jar\\region.json"));

			JSONObject json1 = (JSONObject) obj;
			String rqeId = (String) json1.get("requestId");
			System.out.println("requestId:" + rqeId);
			JSONArray array1 = (JSONArray) json1.get("reservationSet");
			int i = 0;
			while (i < array1.size()) {

				JSONObject json2 = (JSONObject) array1.get(i);
				String reserId = (String) json2.get("reservationId");
				String OwnerId = (String) json2.get("ownerId");
				System.out.println("reservationId:" + reserId);
				System.out.println("ownerId:" + OwnerId);
				JSONArray array2 = (JSONArray) json2.get("instancesSet");

				JSONObject json3 = (JSONObject) array2.get(0);
				String InstType = (String) json3.get("instanceType");
				String imgId = (String) json3.get("imageId");
				String keyName = (String) json3.get("keyName");
				System.out.println("InstanceType:" + InstType);
				System.out.println("InstanceType:" + imgId);
				System.out.println("Instancename:" + keyName);
				Instancetype insType = new Instancetype();
				insType.setResId(reserId);
				insType.setInstanceType(InstType);
				insType.setImgId(imgId);
				insType.setKeyname(keyName);
				ServiceInf sinf = new ServiceImple();
				sinf.insertInstanceDetails(insType);
				i++;
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
