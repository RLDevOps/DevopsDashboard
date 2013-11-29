package servicelayer;

import java.util.List;

import org.hibernate.HibernateException;

import dao.DaoImple;
import dao.DaoInf;
import dto.Instancetype;
import dto.User;

public class ServiceImple implements ServiceInf{

	
	String status=null;
	@Override
	public String storeUser(User user) {
		// TODO Auto-generated method stub
		DaoInf dinf = new DaoImple();
		try {
			dinf.insertUser(user);
			status="insert successfull";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="insert unsuccessful";
		}
		return status;
	}
	
	@Override
	public List getRoleList() {
		// TODO Auto-generated method stub
		DaoInf dinf =  new DaoImple();
		List lstrole=dinf.selectRole();
		return lstrole;
		
	}

	@Override
	public void insertInstanceDetails(Instancetype insType) {
		// TODO Auto-generated method stub
		DaoInf dinf =  new DaoImple();
		dinf.insertInstance(insType);
		
		
	}

	@Override
	public List getInstances() {
		// TODO Auto-generated method stub
		DaoInf dinf =  new DaoImple();
		List lstInstances=dinf.selectInstances();
		return lstInstances;
	}

	@Override
	public List getImageId() {
		// TODO Auto-generated method stub
		DaoInf dinf =  new DaoImple();
		List lstImgId=dinf.selectImageId();
		return lstImgId;
	}

	@Override
	public List getKeyName() {
		// TODO Auto-generated method stub
		DaoInf dinf =  new DaoImple();
		List lstKeyname=dinf.selectKeyName();
		return lstKeyname;
	}
	
	
}
