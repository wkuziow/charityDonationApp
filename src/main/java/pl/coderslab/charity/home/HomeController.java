package pl.coderslab.charity.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;
import pl.coderslab.charity.user.CurrentUser;
import pl.coderslab.utils.Utils;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private InstitutionRepository institutionRepository;
    private DonationService donationService;
    private Utils utils;

    public HomeController(DonationService donationService, Utils utils) {
        this.donationService = donationService;
        this.utils = utils;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "home/index";
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

    @ModelAttribute("currentUserFullName")
    public String currentUser(@AuthenticationPrincipal CurrentUser customUser) {
        return utils.currentUser(customUser);
    }
}
