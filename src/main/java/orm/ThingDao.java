package orm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ThingDao {

    public Thing findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Thing.class, id);
    }

    public void save(Thing thing) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(thing);
        tx1.commit();
        session.close();
    }

    public void update(Thing thing) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(thing);
        tx1.commit();
        session.close();
    }

    public void delete(Thing thing) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(thing);
        tx1.commit();
        session.close();
    }

    public Thing getLast(String tag) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query idQuery = session.createQuery("SELECT Max(id) from Thing where tag = :tagParam");
            idQuery.setParameter("tagParam", tag);
            List idList = idQuery.list();
            int maxId = (int) idList.get(0);
            Query query = session.createQuery("from Thing where id = :idParam");
            query.setParameter("idParam", maxId);
            Thing thing = (Thing) query.list().get(0);
            session.close();
            return thing;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    public List<Thing> getAll(String tag) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Thing where tag = :tagParam");
            query.setParameter("tagParam", tag);
            List<Thing> thing = query.list();
            session.close();
            return thing;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }
}