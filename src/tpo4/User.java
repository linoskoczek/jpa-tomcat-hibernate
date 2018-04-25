package tpo4;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private Collection<Ownership> ownershipsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, firstName);
    }

    @OneToMany(mappedBy = "userByIdUser")
    public Collection<Ownership> getOwnershipsById() {
        return ownershipsById;
    }

    public void setOwnershipsById(Collection<Ownership> ownershipsById) {
        this.ownershipsById = ownershipsById;
    }
}
