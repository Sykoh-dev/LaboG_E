package MedicalAppointment.demo.controller;


import MedicalAppointment.demo.exception.ElementNotFoundException;
import MedicalAppointment.demo.metier.service.DoctorService;
import MedicalAppointment.demo.metier.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/home"})
public class HomeController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    public HomeController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping(path = {"", "/", "/index"})
    public String indexAction(Model view) throws ElementNotFoundException {
        view.addAttribute("nom", "User");
        view.addAttribute("users", this.patientService.getAll());
        view.addAttribute("Patient", this.patientService.getOne(1L));

        return "home/index";
    }
}
