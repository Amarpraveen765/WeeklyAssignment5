package com.codingassignment5;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusinessLogic {
	void insertdata() {
		Session s = Helper.setUp();
		ElectronicShop a = new ElectronicShop(1, "Bulb", 26);
		ElectronicShop b = new ElectronicShop(2, "Tester", 15);
		ElectronicShop c = new ElectronicShop(3, "Plug", 30);
		ElectronicShop d = new ElectronicShop(4, "Switch", 55);
		ElectronicShop e = new ElectronicShop(5, "LED Light", 150);
		s.save(a);
		s.save(b);
		s.save(c);
		s.save(d);
		s.save(e);
		System.out.println("Data Inserted!!!");
		s.close();
	}

	void readdata() {
		Session s = Helper.setUp();
		Query q = s.createQuery("from ElectronicShop");
		List list = q.list();
		ArrayList<ElectronicShop> list1 = (ArrayList<ElectronicShop>) q.list();
		for (ElectronicShop o : list1) {
			System.out.println(o);
		}
		System.out.println("Products in Shop.......");
	}

	void updatedata() {
		Session s = Helper.setUp();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("update ElectronicShop set price=:p1 where id=:p2");
		q.setParameter("p1", 100);
		q.setParameter("p2", 5);
		int status = q.executeUpdate();
		System.out.println(status);
		t.commit();
		System.out.println("Data Updated!!!");
		s.close();

	}

	void deletedata() {
		Session s = Helper.setUp();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("delete ElectronicShop where id=:p1");
		q.setParameter("p1", 5);
		int status = q.executeUpdate();
		System.out.println(status);
		t.commit();
		System.out.println("Data Deleted!!!");
		s.close();

	}

}
