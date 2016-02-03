package rs.personaltrainer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSONALTRAINER_USERDETAIL")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Column(nullable=false)
    private Date created;

    @Column(nullable=false)
    private Date updated;

    @Column(name = "bodyType", nullable = false)
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    public UserDetail() {}

    public UserDetail(Double height, Double weight, Date created, Date updated, BodyType bodyType) {
        this.height = height;
        this.weight = weight;
        this.created = created;
        this.updated = updated;
        this.bodyType = bodyType;
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
