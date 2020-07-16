package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.lang.reflect.MalformedParameterizedTypeException;
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



    @RequestMapping(value = "/addDonation", method = RequestMethod.GET)
    public String addDonationGet() {
        return "donation/addDonation";
    }

    @RequestMapping(value = "/addDonation", method = RequestMethod.POST)
    public String addDonationPost(@RequestParam @Validated Map<String, String> allParams){
//        if (bindingResult.hasErrors()) {
//            return "donation/addDonation";
//        }
        donationService.donationParametersHandler(allParams);
        return "donation/donationThankyou";
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
