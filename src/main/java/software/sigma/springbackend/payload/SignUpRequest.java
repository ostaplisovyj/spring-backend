package software.sigma.springbackend.payload;

import javax.validation.constraints.*;

public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max = 50)
    private String firstname;

    @NotBlank
    @Size(min = 4, max = 50)
    private String lastname;

    @NotBlank
    @Size(max = 300)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
