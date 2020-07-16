package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class DonationController {
    @Autowired
    DonationService donationService;
    DonationRepository donationRepository;
    CategoryRepository categoryRepository;
    InstitutionRepository institutionRepository;
    DonationValidator donationValidator;



    @RequestMapping(value = "/addDonation", method = RequestMethod.GET)
    public String addDonationGet() {
        return "donation/addDonation";
    }

    @RequestMapping(value = "/addDonation", method = RequestMethod.POST)
    public String addDonationPost(@RequestParam Map<String, String> allParams, Model model){
        List<String> errors = donationValidator.validateDonation(allParams);
        String result = "";
       if (!errors.isEmpty() && errors != null) {
           model.addAttribute("errors", errors);
            result =  "donation/addDonation";
        } else {
           donationService.donationParametersHandler(allParams);
           result = "donation/donationThankyou";
       }
        return result;
    }

    @ModelAttribute("categoriesList")
    public List<Category> listOfCategories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutionList")
    public List<Institution> institutionList() {
        return institutionRepository.findAll();
    }

}
