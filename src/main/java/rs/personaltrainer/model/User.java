package rs.personaltrainer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "PERSONALTRAINER_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(nullable=false, updatable = false, unique = true)
    private String email;

    @Column
    @NotNull(message = "error.loginname.notnull")
    @Size(min = 3, max = 30,  message = "error.loginname.size")
    private String loginname;

    @NotNull
    @Size(max = 64)
    @Column(name = "password_hash", nullable = false)
    private String hashedPassword;

    @Column(nullable=false)
    private Date created;

    @Column(nullable=false)
    private Date updated;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private Boolean enabled;

    @Column
    Boolean verified;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private UserDetail userDetail;

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public User() {}

    public User(String loginname, String password, String email) {
        this.loginname = loginname;
        this.hashedPassword = password;
        this.created = new Date();
        this.updated = new Date();
        this.enabled = true;
        this.role = Role.ADMIN;
        this.email = email;
    }

    public Integer getId() {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Boolean isVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", loginname=" + loginname + "]";
    }
}
