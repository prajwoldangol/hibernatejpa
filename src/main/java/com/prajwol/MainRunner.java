package com.prajwol;

import com.prajwol.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class MainRunner {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            //createDepartment(session);
            //findDepartment(session,2);
//            updateDepartment(session,2);
            //deleteDepartment(session,2);

            TypedQuery<Department> d = session.createNamedQuery("getAllDepartments", Department.class);
            List<Department> ld = d.getResultList();
            ld.stream().forEach(dept -> System.out.println(dept.getName()));
        } finally {
            session.close();
            factory.close();
        }
    }

    public static void createDepartment(Session s){
        Transaction transaction = s.beginTransaction();
        try {
            Department d1 = new Department("IT", "CA");
            Department d2= new Department("SALES", "GA");
            Department d3 = new Department("MANAGERS", "FL");
            s.persist(d1);
            s.persist(d2);
            s.persist(d3);
            transaction.commit();
            System.out.println("Departments added successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public static void findDepartment(Session session, int dId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, dId);
            if (dept != null) {
                System.out.println("Department found: " + dept.getName());
            } else {
                System.out.println("No user found with ID: " + dId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void updateDepartment(Session session, int dId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, dId);
            if (dept != null) {
                dept.setName("MINNI");
                dept.setState("MI");
                session.update(dept);
                transaction.commit();
                System.out.println("Department updated successfully");
            } else {
                System.out.println("No dept found to update.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteDepartment(Session session, int deptId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, deptId);
            if (dept != null) {
                session.delete(dept);
                transaction.commit();
                System.out.println("Department deleted successfully.");
            } else {
                System.out.println("No user found to delete.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


}

