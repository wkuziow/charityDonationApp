package pl.coderslab.charity.institution;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InstitutionController {

    private InstitutionRepository institutionRepository;

    public InstitutionController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping(value = "/console/allInstitutions", method = RequestMethod.GET)
    public String allInstitutionsGet(Model model) {
        model.addAttribute("allInstitutions", institutionRepository.findAll());
        return "/console/allInstitutions";
    }

    @RequestMapping(value = "/console/allInstitutions", method = RequestMethod.POST)
    public String allInstitutionsPost(){
       // model.addAttribute("allnIstitutions", institutionRepository.findAll());
        return "/console/allInstitutions";

    }
}
