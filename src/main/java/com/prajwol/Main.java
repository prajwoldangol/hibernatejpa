//package com.prajwol;
//
//import com.prajwol.model.Department;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) {
////        Configuration configuration = new Configuration();
////
////        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
////                .configure("hibernate.props").build();
////        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
////        Session session = factory.openSession();
////        Transaction transaction = session.beginTransaction();
////        try {
////            Department uOne = new Department("james","sfds");
////
////
////            session.persist(uOne);
////
////            transaction.commit();
////            System.out.println("Users added successfully");
////        } catch (Exception e) {
////            if (transaction != null) transaction.rollback();
////            e.printStackTrace();
////        }
////        factory.close();
////        session.close();
//        getCurrentSession();
//    }
//    public static Session getCurrentSession() {
//        // Hibernate 5.4 SessionFactory example without XML
//        Map<String, String> settings = new HashMap<>();
//        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
//        settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
//        settings.put("hibernate.connection.url",
//                "jdbc:mysql://localhost:3306/userDb");
//        settings.put("hibernate.connection.username", "root");
//        settings.put("hibernate.connection.password", "root");
//        settings.put("hibernate.current_session_context_class", "thread");
//        settings.put("hibernate.show_sql", "true");
//        settings.put("hibernate.format_sql", "true");
//
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(settings).build();
//
//        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
//         metadataSources.addAnnotatedClass(Department.class);
//        Metadata metadata = metadataSources.buildMetadata();
//
//        // here we build the SessionFactory (Hibernate 5.4)
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//        Session session = sessionFactory.getCurrentSession();
//        return session;
//    }
//}