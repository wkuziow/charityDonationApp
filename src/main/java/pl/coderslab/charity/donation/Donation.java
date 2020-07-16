package pl.coderslab.charity.donation;

import lombok.*;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "To pole nie może być puste")
    @Min(value = 1, message = "Minimalna wartość to 1")
    private Integer quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.EAGER)
    private Institution institution;

    @Size(max = 50, message = "Maksymalna długość pola to 50 znaków")
    private String street;

    @NotEmpty(message = "To pole nie może być puste")
    @Size(max = 50, message = "Maksymalna długość pola to 50 znaków")
    private String city;

    @NotEmpty(message = "To pole nie może być puste")
    @Size(max = 6, message = "Maksymalna długość pola to 6 znaków")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Nieprawidłowy format danych")
    private String zipCode;

   @NotNull(message = "To pole nie może być puste")
    @FutureOrPresent
    private LocalDate pickUpDate;

    @NotNull(message = "To pole nie może być puste")
    private LocalTime pickUpTime;

    @Size(max = 300, message = "Maksymalna długość pola to 300 znaków")
    private String pickUpComment;

    public static final class DonationBuilder {
        private Integer quantity;
        private List<Category> categories;
        private Institution institution;
        private String street;
        private String city;
        private String zipCode;
        private LocalDate pickUpDate;
        private LocalTime pickUpTime;
        private String pickUpComment;


        public DonationBuilder() {
        }

        public static DonationBuilder aDonation() {
            return new DonationBuilder();
        }

        public DonationBuilder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public DonationBuilder withCategories(List<Category> categories) {
            this.categories = categories;
            return this;
        }

        public DonationBuilder withInstitution(Institution institution) {
            this.institution = institution;
            return this;
        }

        public DonationBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public DonationBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public DonationBuilder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public DonationBuilder withPickUpDate(LocalDate pickUpDate) {
            this.pickUpDate = pickUpDate;
            return this;
        }

        public DonationBuilder withPickUpTime(LocalTime pickUpTime) {
            this.pickUpTime = pickUpTime;
            return this;
        }

        public DonationBuilder withPickUpComment(String pickUpComment) {
            this.pickUpComment = pickUpComment;
            return this;
        }

        public Donation build() {
            Donation donation = new Donation();
            donation.setQuantity(quantity);
            donation.setCategories(categories);
            donation.setInstitution(institution);
            donation.setStreet(street);
            donation.setCity(city);
            donation.setZipCode(zipCode);
            donation.setPickUpDate(pickUpDate);
            donation.setPickUpTime(pickUpTime);
            donation.setPickUpComment(pickUpComment);
            return donation;
        }
    }

    public static DonationBuilder donationBuilder() {
        return new DonationBuilder();
    }

//    @ManyToOne (fetch = FetchType.EAGER)
//    private User user;



}
