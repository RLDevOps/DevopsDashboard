package dao;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import dto.Instancetype;
import dto.Role;
import dto.User;

@SuppressWarnings("deprecation")
public class DaoImple implements DaoInf {
 
	
	
	static SessionFactory sess;
	static{
		try {
			sess = new Configuration(). 
	                   configure("/hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failed to create sessionfactory object");
		}
		
	}
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		String status=null;
		Session session = sess.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			
			session.save(user);
			tx.commit();
			status="insertion done";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
			}
	}
	@Override
	public List selectRole() {
		// TODO Auto-generated method stub
		Session session=sess.openSession();
		Transaction tx = null;
		List lstrole=null;
		try {
			tx=session.beginTransaction();
			lstrole=(List) session.createQuery("Select role FROM Role").list();
			
		    for(Iterator itr = lstrole.iterator(); itr.hasNext();)
		    {
		      String mylist =   (String) itr.next();
		      Role role=new Role();
		      role.setRole(mylist);
		      //System.out.println(role.getRole());
		      
		     }
		    tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstrole;
	}
	@Override
	public void insertInstance(Instancetype instype) {
		// TODO Auto-generated method stub
		String status=null;
		Session session = sess.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			
			session.save(instype);
			tx.commit();
			status="insertion done";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
			}
	}
	@Override
	public List selectInstances() {
		// TODO Auto-generated method stub
		Session session=sess.openSession();
		Transaction tx = null;
		List lstInstance=null;
		try {
			tx=session.beginTransaction();
			lstInstance=(List) session.createQuery("Select InstanceType FROM Instancetype").list();
			System.out.println("@@@@ _> "+lstInstance.size());
		    for(Iterator itr = lstInstance.iterator(); itr.hasNext();)
		    {
		      String mylist =   (String) itr.next();
		      Instancetype instType=new Instancetype();
		      instType.setInstanceType(mylist);
		      //System.out.println(role.getRole());
		      
		     }
		    tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstInstance;
	}
	@Override
	public List selectImageId() {
		// TODO Auto-generated method stub
		Session session=sess.openSession();
		Transaction tx = null;
		List lstImageId=null;
		try {
			tx=session.beginTransaction();
			lstImageId=(List) session.createQuery("Select imgId FROM Instancetype").list();
			System.out.println("@@@@ _> "+lstImageId.size());
		    for(Iterator itr = lstImageId.iterator(); itr.hasNext();)
		    {
		      String mylist =   (String) itr.next();
		      Instancetype instType=new Instancetype();
		      instType.setInstanceType(mylist);
		      //System.out.println(role.getRole());
		      
		     }
		    tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstImageId;
	}
	@Override
	public List selectKeyName() {
		// TODO Auto-generated method stub
		Session session=sess.openSession();
		Transaction tx = null;
		List lstKeyName=null;
		try {
			tx=session.beginTransaction();
			lstKeyName=(List) session.createQuery("Select keyname FROM Instancetype").list();
			System.out.println("@@@@ _> "+lstKeyName.size());
		    for(Iterator itr = lstKeyName.iterator(); itr.hasNext();)
		    {
		      String mylist =   (String) itr.next();
		      Instancetype instType=new Instancetype();
		      instType.setInstanceType(mylist);
		      //System.out.println(role.getRole());
		      
		     }
		    tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstKeyName;
	}
}
	
	

	


