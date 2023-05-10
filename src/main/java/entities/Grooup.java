package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grooup")
public class Grooup extends MyEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "grooup",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Student> students;

    public Grooup() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grooup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                //", students=" + students +
                '}';
    }
}
