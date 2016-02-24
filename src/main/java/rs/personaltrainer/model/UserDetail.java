package rs.personaltrainer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSONALTRAINER_USERDETAIL")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Izmena imena
    @Column
    private String name;
    //Izmena prezimena
    @Column
    private String surname;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Column(nullable = false)
    private Date created;

    @Column(nullable = false)
    private Date updated;
    //Grad u kom stanuje korisnik
    @Column
    private String city;

//Ovde treba radio button, sta da koristim, Integer ili String?
    //@Column
    //private

    //Teretana u koju ide korisnik
    @Column
    private String gym;

    @Column(name = "bodyType", nullable = false)
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    public UserDetail() {
    }

    public UserDetail(String name, String surname, Double height, Double weight, Date created, Date updated, String city, String gym, BodyType bodyType, User user) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.created = created;
        this.updated = updated;
        this.city = city;
        this.gym = gym;
        this.bodyType = bodyType;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
