package website.resources;

import javassist.NotFoundException;
import repositories.UserRepository;
import tpo4.Connector;
import tpo4.Resource;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ResourcesLogic {
    private String login;

    public ResourcesLogic(String login) {
        this.login = login;
    }

    public ResourcesModel getResult() {
        EntityManager em = Connector.getEntityManager();
        UserRepository ur = new UserRepository();
        try {
            int id = ur.findIdByLogin(this.login);
            Query query = em.createQuery("select r from Resource r " +
                    "join Ownership o on r.id = o.idResource " +
                    "where o.idUser = :id");
            query.setParameter("id", id);
            List<Resource> listOfResources = query.getResultList();

            return new ResourcesModel(listOfResources);

        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResourcesModel(new ArrayList<>());
        }
        finally {
            em.close();
        }

    }
}
