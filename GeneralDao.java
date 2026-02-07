package com.lms.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lms.util.HibernateUtil;
import java.util.List;

public class GeneralDao {
    
    public void saveObject(Object obj) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getsessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
            System.out.println("Saved successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public <T> List<T> getAll(Class<T> type) {
        try (Session session = HibernateUtil.getsessionFactory().openSession()) {
            return session.createQuery("from " + type.getName(), type).list();
        }
    }

    public <T> void deleteObject(Class<T> type, String id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getsessionFactory().openSession()) {
            tx = session.beginTransaction();
            Object obj = session.get(type, id);
            if (obj != null) session.delete(obj);
            tx.commit();
            System.out.println("Deleted successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}