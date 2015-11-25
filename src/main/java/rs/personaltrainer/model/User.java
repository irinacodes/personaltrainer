package rs.personaltrainer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @NotNull
    @Size(max = 64)
    @Column(nullable = false, updatable = false)
    private String id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(nullable=false, updatable = false)
    private String email;

    @Column
    @NotNull(message = "error.title.notnull")
    @Size(min = 3, max = 30,  message = "error.title.size")
    private String loginname;

    @NotNull
    @Size(max = 64)
    @Column(name = "password", nullable = false)
    private String hashedPassword;

    @Column(nullable=false)
    private Date created;

    @Column(nullable=false)
    private Date updated;


    public User() {}

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", loginname=" + loginname + "]";
    }
}
