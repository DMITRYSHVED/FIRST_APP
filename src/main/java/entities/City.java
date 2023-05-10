package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City extends MyEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "city" ,fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Student> students;

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", students=" + students +
                '}';
    }
}
