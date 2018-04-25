package repositories;

import javassist.NotFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tpo4.Connector;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserRepository implements IUserRepository {

    @Override
    public boolean checkPassword(String login, String password) {
        EntityManager em = Connector.getEntityManager();

        //criteria based queries
        Query query = em.createQuery("select password from User where login = :login");
        query.setParameter("login", login);
        try {
            String pass = (String) query.getSingleResult();
            return pass.equals(password);
        } catch(NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean exists(String login) {
        throw new NotImplementedException();
    }

    @Override
    public int findIdByLogin(String login) throws NotFoundException {
        EntityManager em = Connector.getEntityManager();

        Query query = em.createQuery("select id from User where login = :login");
        query.setParameter("login", login);
        try {
            return (int) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
