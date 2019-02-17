package software.sigma.springbackend.user;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user",schema="sigma")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "firstname")
    @Size(max = 50)
    private String firstname;

    @NotNull
    @Size(max = 50)
    @Column(columnDefinition = "lastname")
    private String lastname;

    @NotNull
    @Column(columnDefinition = "email")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(columnDefinition = "password")
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getFirstname () {
        return this.firstname;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }

    public String getLastname () {
        return this.lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail () {
        return this.email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
