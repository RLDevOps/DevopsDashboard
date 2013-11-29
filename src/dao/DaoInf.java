package dao;

import java.util.List;

import dto.Instancetype;
import dto.User;

public interface DaoInf {
	public void insertUser(User user);
	public List selectRole();
	public void insertInstance(Instancetype instype);
	public List selectInstances();
	public List selectImageId();
	public List selectKeyName();

}
