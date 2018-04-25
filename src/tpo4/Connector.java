package tpo4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connector {

    private Connector() {}

    private static EntityManagerFactory _factory;

    public static synchronized EntityManager getEntityManager() {
        if (_factory == null) {
            _factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        }
        return _factory.createEntityManager();
    }
}
