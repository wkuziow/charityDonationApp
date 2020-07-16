package pl.coderslab.charity.donation;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class DonationValidator {

    public List<String> validateDonation(Map<String, String> parametersMap) {
        List<String> errors = new ArrayList<>();
        Optional<String> numberOfBags = Optional.ofNullable(parametersMap.get("numberOfBagsSummary"));
        if (numberOfBags.isEmpty() || numberOfBags.get().isEmpty()) {
            errors.add("Pole Ilość worków nie może być puste");
        } else if (Integer.parseInt(numberOfBags.get()) <= 0) {
            errors.add("Ilość worków musi być liczbą dodatnią");
        }

        if (parametersMap.get("categorriesSummary").isEmpty()) {
            errors.add("Musisz wybrać przynajmniej jedną kategorię");
        }

        if (parametersMap.get("institutionSummary").isEmpty()) {
            errors.add("Wybierz instytucję");
        }

        Optional<String> adressSummary = Optional.ofNullable(parametersMap.get("adressSummary"));
        if (adressSummary.isEmpty()) {
            errors.add("Pole adres nie może być puste");
        } else if (adressSummary.get().length() > 50) {
            errors.add("Zbyt długi adres");
        }

        Optional<String> citySummary = Optional.ofNullable(parametersMap.get("citySummary"));
        if (citySummary.isEmpty()) {
            errors.add("Uzupełnij miasto!");
        } else if (citySummary.get().length() > 50) {
            errors.add("Zbyt długa nazwa miasta");
        }

        Optional<String> postCodeSummary = Optional.ofNullable(parametersMap.get("postCodeSummary"));
        if (postCodeSummary.isEmpty()) {
            errors.add("Uzupełnj kod pocztowy");
        } else if (postCodeSummary.get().length() > 6) {
            errors.add("Zbyt długi kod pocztowy");
        }

        if (postCodeSummary.isPresent() && !postCodeSummary.get().matches("\\d{2}-\\d{3}")) {
            errors.add("Nieprawidłowy format kodu pocztowego");
        }

        LocalDate dateNow = LocalDate.now();
        Optional<String> pickUpDate = Optional.ofNullable(parametersMap.get("pickUpDateSummary"));
        if (pickUpDate.isEmpty() || pickUpDate.get().isEmpty()) {
            errors.add("Data odbioru nie może być pusta");
        } else if (LocalDate.parse(pickUpDate.get()).isBefore(dateNow)) {
            errors.add("Data odbioru nie może być w przeszłości");
        }

        Optional<String> pickUpTime = Optional.ofNullable(parametersMap.get("pickUpTimeSummary"));
        if (pickUpTime.isEmpty() || pickUpTime.get().isEmpty()) {
            errors.add("Uzupełnij godzinę odbioru");
        }

        Optional<String> pickUpCommentsSummary = Optional.ofNullable(parametersMap.get("pickUpCommentsSummary"));
        if (pickUpCommentsSummary.isPresent() && pickUpCommentsSummary.get().length() > 300) {
            errors.add("Zbyt długi komentarz");
        }

        return errors;
    }
}
