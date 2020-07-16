package pl.coderslab.charity.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "To pole jest wymagane")
    @Size(min = 3, max = 50, message = "nieprawidłowe dane, minimalna długość to 3, maksymalna 50 znaków")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "To pole jest wymagane")
    @Size(min = 3, max = 50, message = "nieprawidłowe dane, minimalna długość to 3, maksymalna 50 znaków")
    private String lastName;

    @NotEmpty(message = "To pole jest wymagane")
    @Size(min = 3, max = 100, message = "nieprawidłowe dane, minimalna długość to 3")
    private String password;

    @Transient
    private String confirmPassword;

    private boolean enabled;

    private Role role;

    @NotEmpty(message = "To pole jest wymagane")
    @Email
    @Size(max = 40, message = "maksymalna długość to 40 znaków")
    private String email;


}
