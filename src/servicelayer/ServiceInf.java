package servicelayer;

import java.util.List;

import dto.Instancetype;
import dto.User;

public interface ServiceInf {
	
	public String storeUser(User us);
	public List getRoleList();
	public void insertInstanceDetails(Instancetype insType);
	public List getInstances();
	public List getImageId();
	public List getKeyName();

}
