package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_users;
    @Column(name = "name_users")
    private String name_users;
    //можно не указывать Column name_users, если оно совпадает с названием столбца в таблице
    private int age_users;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    public User() {
    }

    public User(String name_users, int age_users) {
        this.name_users = name_users;
        this.age_users = age_users;
        autos = new ArrayList<>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public int getId_users() {
        return id_users;
    }

    public String getName_users() {
        return name_users;
    }

    public void setName_users(String name_users) {
        this.name_users = name_users;
    }

    public int getAge_users() {
        return age_users;
    }

    public void setAge_users(int age_users) {
        this.age_users = age_users;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id_users=" + id_users +
                ", name_users='" + name_users + '\'' +
                ", age_users=" + age_users +
                '}';
    }
}