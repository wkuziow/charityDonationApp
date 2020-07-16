package pl.coderslab.charity.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private InstitutionRepository institutionRepository;
    private DonationService donationService;

    public HomeController(DonationService donationService) {
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }

    @ModelAttribute("institutionList")
    public List<Institution> institutionList() {
        return institutionRepository.findAll();
    }

    @ModelAttribute("numberOfBags")
    public int numberOfBags() {
        return donationService.countBags();
    }

    @ModelAttribute("numberOfDonations")
    public int numberOfDonations(){
        return donationService.countDonations();
    }
}
