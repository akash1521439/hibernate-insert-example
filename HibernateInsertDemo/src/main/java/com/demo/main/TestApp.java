package com.demo.main;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.model.Students;
import com.demo.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Students st1 = new Students("akash","aka@gmail.com");
		Students st2 = new Students("mahbub2","aka@gmail.com");
		
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionfactory().openSession()){
			transaction = session.beginTransaction();
			
			session.save(st1);
			session.save(st2);
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		

	}

}
