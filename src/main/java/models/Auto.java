package models;

import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_autos;

    @Column (name = "model_autos")
    private String model_autos;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String color_autos;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {
    }

    public Auto(String model_autos, String color_autos) {
        this.model_autos = model_autos;
        this.color_autos = color_autos;
    }

    public int getId_autos() {
        return id_autos;
    }

    public String getModel_autos() {
        return model_autos;
    }

    public void setModel_autos(String model_autos) {
        this.model_autos = model_autos;
    }

    public String getColor_autos() {
        return color_autos;
    }

    public void setColor_autos(String color_autos) {
        this.color_autos = color_autos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return color_autos + " " + model_autos;
    }
}