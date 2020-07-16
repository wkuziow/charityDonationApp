package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;
    private CategoryRepository categoryRepository;

    public DonationService(InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
    }

    public int countBags() {
        int totalNumberOfBags = 0;
        List<Donation> listOfDonations = donationRepository.findAll();
        totalNumberOfBags = listOfDonations.stream()
                .map(x -> x.getQuantity())
                .reduce(0, Integer::sum);
        return totalNumberOfBags;
    }

    public int countDonations() {
        int totalNumberOfDonations = 0;
        List<Donation> listOfDonations = donationRepository.findAll();
        totalNumberOfDonations = listOfDonations.size();
        return totalNumberOfDonations;
    }

    public void donationParametersHandler(Map<String, String> parametersMap) {
        int numberOfBags = Integer.parseInt(parametersMap.get("numberOfBagsSummary"));
        List<Category> categories = Arrays.stream(parametersMap.get("categorriesSummary")
                .split(","))
                .map(x -> Long.parseLong(x))
                .map(y -> categoryRepository.findCategoryById(y))
                .collect(Collectors.toList());
        Long institutionSummaryLong = Long.parseLong(parametersMap.get("institutionSummary"));
        Institution institutionSummary = institutionRepository.findInstitutionById(institutionSummaryLong);
        String adressSummary = parametersMap.get("adressSummary");
        String citySummary = parametersMap.get("citySummary");
        String postCodeSummary = parametersMap.get("postCodeSummary");
        String phoneSummary = parametersMap.get("phoneSummary");
        LocalDate pickUpDate = LocalDate.parse(parametersMap.get("pickUpDateSummary"));
        LocalTime pickUpTime = LocalTime.parse(parametersMap.get("pickUpTimeSummary"));
        String pickUpCommentsSummary = parametersMap.get("pickUpCommentsSummary");

        Donation donation = Donation.donationBuilder()
                .withQuantity(numberOfBags)
                .withCategories(categories)
                .withInstitution(institutionSummary)
                .withCity(citySummary)
                .withStreet(adressSummary)
                .withZipCode(postCodeSummary)
                .withPickUpComment(pickUpCommentsSummary)
                .withPickUpDate(pickUpDate)
                .withPickUpTime(pickUpTime)
                .build();

        donationRepository.save(donation);
    }
}

