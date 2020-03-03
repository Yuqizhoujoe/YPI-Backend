package com.ypi;

import com.ypi.entity.Resource;
import com.ypi.util.DBUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class ResourceApplication {

    private SessionFactory sessionFactory = DBUtil.getSessionFactory();

    public Resource find(int id){
        Resource resource = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select r from Resource r where id = :id");
            query.setParameter("id", id);
            resource = (Resource) query.uniqueResult();
            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                session.close();
            }
        }
        return resource;
    }

    public void get(long id) {
        List<Resource> resources = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select r from Resource r");
            resources = query.getResultList();
            for (Iterator iter = resources.iterator(); iter.hasNext();) {
                Resource resource = (Resource) iter.next();
                if (resource.getResourceId() == id) {
                    System.out.println("Id: " + resource.getResourceId());
                    System.out.println("Name: " + resource.getResourceName());
                    System.out.println("Major: " + resource.getCost_Code());
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public boolean update(Resource resource) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(resource);
            transaction.commit();
        } catch (HibernateError e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public boolean delete(Resource resource) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(resource);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public void insertResource(String resourceName, String cost_code) {
        Session session = null;
        Resource resource = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            resource = new Resource(resourceName, cost_code);
            session.save(resource);
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void getAllResources(){
        List<Resource> resources = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select r from Resource r", Resource.class);
            resources = query.getResultList();
            for (Iterator iter = resources.iterator(); iter.hasNext();) {
                Resource resource = (Resource) iter.next();
                System.out.println("Id: " + resource.getResourceId());
                System.out.println("Name: " + resource.getResourceName());
                System.out.println("Cost_Code: " + resource.getCost_Code());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }


}
