package entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @ManyToOne()
    @JoinColumn(name = "grooup_id")
    private Grooup grooup;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    public Student() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grooup getGrooup() {
        return grooup;
    }

    public void setGrooup(Grooup grooup) {
        this.grooup = grooup;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", grooup=" + grooup +
                ", city=" + city +
                '}';
    }
}
