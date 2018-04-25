package tpo4;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ownership {
    private int id;
    private int idResource;
    private int idUser;
    private Resource resourceByIdResource;
    private User userByIdUser;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_resource")
    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ownership ownership = (Ownership) o;
        return id == ownership.id &&
                idResource == ownership.idResource &&
                idUser == ownership.idUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idResource, idUser);
    }

    @ManyToOne
    @JoinColumn(name = "id_resource", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Resource getResourceByIdResource() {
        return resourceByIdResource;
    }

    public void setResourceByIdResource(Resource resourceByIdResource) {
        this.resourceByIdResource = resourceByIdResource;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
