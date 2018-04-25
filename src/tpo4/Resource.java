package tpo4;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Resource {
    private int id;
    private String name;
    private String content;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id == resource.id &&
                Objects.equals(name, resource.name) &&
                Objects.equals(content, resource.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, content);
    }

    @OneToMany(mappedBy = "resourceByIdResource")
    public Collection<Ownership> getOwnershipsById() {
        return ownershipsById;
    }

    public void setOwnershipsById(Collection<Ownership> ownershipsById) {
        this.ownershipsById = ownershipsById;
    }
}
