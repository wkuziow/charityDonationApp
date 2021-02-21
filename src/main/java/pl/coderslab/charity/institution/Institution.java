package pl.coderslab.charity.institution;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "To pole nie może być puste")
    @Size(min=3,max = 30, message = "długość pola to minimalnie 3 a maksylanie 30 znaków")
    private String name;

    @Size(max = 255, message = "długość pola to minimalnie 255 znaków")
    private String description;
}
